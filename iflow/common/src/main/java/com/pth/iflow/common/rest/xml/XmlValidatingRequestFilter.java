package com.pth.iflow.common.rest.xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingResponseWrapper;
import com.pth.iflow.common.controllers.helper.IflowSpringProfiles;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.exceptions.IflowConfigurationException;
import com.pth.iflow.common.response.IFlowErrorRestResponse;

/**
 * pluggable filter to do XML Validation for customizable schemas.
 *
 *
 * <h3>Design Choice</h2> Although its possible to config spring serialization to use JAXB and valdiate thru this, this is the more general
 * approach albeit less performant, as we dont expect to validate by default in production.
 *
 * @see hint for JAXB Validation: https://stackoverflow.com/questions/34929016/spring-validate-rest-controller-against-xsd-schema
 */
@Component
@Profile(IflowSpringProfiles.SERVICE_APP)
public class XmlValidatingRequestFilter extends OncePerRequestFilter /*
                                                                      * extending from this out of pure convenience, so i dont have to do
                                                                      * so much copy paste of code
                                                                      */ {

  private final Logger log = LoggerFactory.getLogger(getClass());

  private final XmlValidator xmlValidator;

  /** if set, overrides the given urlPatterns */
  private boolean validateAllIncoming;

  /** if set, overrides the given urlPatterns */
  private boolean validateAllOutgoing;

  /** i keep this only for debugging purposes, so we can still see what the poriginal pattern were */
  transient private final String[] urlPatterns;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

  private final List<Pattern> incomingPatterns = new ArrayList<>();
  private final List<Pattern> outgoingPatterns = new ArrayList<>();

  @Autowired
  public XmlValidatingRequestFilter(@NotNull final XmlValidator xmlValidator,
                                    @Value("${mdm.common.rest.xml-validation.all-incoming:false}") final boolean validateAllIncoming,
                                    @Value("${mdm.common.rest.xml-validation.all-outgoing:false}") final boolean validateAllOutgoing,
                                    @Value("${mdm.common.rest.xml-validation.url-patterns}") final String[] urlPatterns) {
    this.xmlValidator = xmlValidator;

    if (ArrayUtils.isEmpty(urlPatterns)
        || ((urlPatterns.length == 1) && urlPatterns[0].equals("${mdm.common.rest.xml-validation.url-patterns}"))) {
      log.warn("No URL patterns defined via config ${mdm.common.rest.xml-validation.url-patterns}! "
               + "Validation is only controlled via ${mdm.common.rest.xml-validation.all-incoming/outgoing}");
      this.urlPatterns = new String[0];
    }
    else {
      log.info("URL patterns defined: {}", String.join(",", urlPatterns));
      this.urlPatterns = urlPatterns;
    }
    initPatterns();

    this.setValidateAllIncoming(validateAllIncoming);
    this.setValidateAllOutgoing(validateAllOutgoing);
    log.info("${mdm.common.rest.xml-validation.all-outgoing}: {}", isValidateAllOutgoing());
    log.info("${mdm.common.rest.xml-validation.all-incoming}: {}", isValidateAllIncoming());
  }

  /**
   *
   */
  private void initPatterns() {
    for (int i = 0; i < urlPatterns.length; i++) {
      final String pattern = urlPatterns[i];
      final String[] parts = StringUtils.split(pattern, " ");
      if (parts == null) {
        throw new IflowConfigurationException("Illegal URL pattern. It must be of the format: <URL RegEx Pattern> [i][o] but was NULL");
      }
      else if (parts.length == 0) {
        throw new IflowConfigurationException("Illegal URL pattern. It must be of the format: <URL RegEx Pattern> [i][o] but was EMPTY");
      }
      else if (parts.length > 2) {
        throw new IflowConfigurationException("Illegal URL pattern. It must be of the format: <URL RegEx Pattern> [i][o] but had >1 spaces: %s",
                                              pattern);
      }

      final Pattern regex = Pattern.compile(parts[0]);

      // if neither i nor o given, then default to incoming only
      final String mask;
      if (parts.length == 1) {
        mask = "i";
        urlPatterns[i] = parts[0] + " -> " + mask;
        log.debug("Effective URL pattern config: {}", urlPatterns[i]);
      }
      else {
        mask = parts[1];
      }

      if (mask.contains("i")) {
        incomingPatterns.add(regex);
      }

      if (mask.contains("o")) {
        outgoingPatterns.add(regex);
      }
    }

  }

  /**
   * @basedon org.springframework.web.filter.AbstractRequestLoggingFilter#doFilterInternal(javax.servlet.http.HttpServletRequest,
   *          javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain)
   */
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, final FilterChain filterChain) throws ServletException, IOException {

    final HttpServletResponse origResponse = response;
    final boolean isFirstRequest = !isAsyncDispatch(request);

    final String requestPath = request.getRequestURI();
    final boolean effectiveValidateIncoming = isFirstRequest
                                              && (isValidateAllIncoming() || anyMatch(requestPath, incomingPatterns));
    if (effectiveValidateIncoming && !(request instanceof BufferedHttpServletRequestWrapper)) {
      request = new BufferedHttpServletRequestWrapper(request);
    }
    final boolean effectiveValidateOutgoing = !isAsyncStarted(request)
                                              && (isValidateAllOutgoing() || anyMatch(requestPath, outgoingPatterns));
    if (effectiveValidateOutgoing && !(response instanceof ContentCachingResponseWrapper)) {
      response = new ContentCachingResponseWrapper(response);
    }
    log.trace("Validating URL on in/out: {} -> {}/{}", requestPath, effectiveValidateIncoming, effectiveValidateOutgoing);

    boolean isIncoming = true;
    try {
      if (effectiveValidateIncoming) {
        validateIncoming((BufferedHttpServletRequestWrapper) request);
      }
      filterChain.doFilter(request, response);
      isIncoming = false;

      // note: this will not validate an error response which i dont think we need, or ?
      if (effectiveValidateOutgoing) {
        validateOutgoing((ContentCachingResponseWrapper) response);
      }
    }
    catch (final XmlValidationException e) {
      /*
       * NOTE: cant use the generic error handler here, as it is not a filter. they seem to be a layer directly over the controller but
       * AFTER the filters are called, see also
       * https://stackoverflow.com/questions/34595605/how-to-manage-exceptions-thrown-in-filters-in-spring| menzelt @ 25.07.2018
       */
      e.setIsOnIncoming(isIncoming);

      final IFlowErrorRestResponse errorResponse = new IFlowErrorRestResponse(HttpStatus.BAD_REQUEST,
                                                                              EIFlowErrorType.MESSAGE_CONVERSION_FAILURE.name(),
                                                                              ExceptionUtils.getStackTrace(e));
      origResponse.setStatus(HttpStatus.BAD_REQUEST.value());

      final String respXml = xmlConverter.getObjectMapper().writeValueAsString(errorResponse);
      origResponse.getWriter().write(respXml);
    }

  }

  /**
   */
  private boolean anyMatch(final String requestPath, final List<Pattern> patterns) {
    for (final Pattern pattern : patterns) {
      if (pattern.matcher(requestPath).matches()) {
        return true;
      }
    }
    return false;
  }

  /**
   * @throws XmlValidationException
   * @throws IOException
   */
  private void validateOutgoing(final ContentCachingResponseWrapper response) throws XmlValidationException, IOException {

    final String body = IOUtils.toString(response.getContentInputStream(), response.getCharacterEncoding());
    log.trace("Response body: {}", body);
    xmlValidator.validate(body);
    // this needs to happen, otherwise response is empty
    response.copyBodyToResponse();

  }

  /**
   * @throws XmlValidationException
   */
  private void validateIncoming(final BufferedHttpServletRequestWrapper requestToUse) throws IOException, XmlValidationException {
    requestToUse.getInputStream().mark(Integer.MAX_VALUE);
    final String body = IOUtils.toString(requestToUse.getInputStream(), requestToUse.getCharacterEncoding());
    requestToUse.getInputStream().reset();

    log.trace("Request Body: {}", body);
    xmlValidator.validate(body);
  }

  public boolean isValidateAllIncoming() {
    return validateAllIncoming;
  }

  public void setValidateAllIncoming(final boolean validateAllIncoming) {
    this.validateAllIncoming = validateAllIncoming;
  }

  public boolean isValidateAllOutgoing() {
    return validateAllOutgoing;
  }

  public void setValidateAllOutgoing(final boolean validateAllOutgoing) {
    this.validateAllOutgoing = validateAllOutgoing;
  }

}
