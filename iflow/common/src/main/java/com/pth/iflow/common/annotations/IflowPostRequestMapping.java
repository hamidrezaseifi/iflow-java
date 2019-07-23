package com.pth.iflow.common.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_XML_VALUE,
    MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE })
public @interface IflowPostRequestMapping {

  @AliasFor(annotation = RequestMapping.class)
  String[] path() default {};

  @AliasFor(annotation = RequestMapping.class)
  String name() default "";

  @AliasFor(annotation = RequestMapping.class)
  String[] value() default {};

  @AliasFor(annotation = RequestMapping.class)
  String[] params() default {};

  /**
   * Alias for {@link RequestMapping#headers}.
   */
  @AliasFor(annotation = RequestMapping.class)
  String[] headers() default {};

  /**
   * Alias for {@link RequestMapping#consumes}.
   *
   * @since 4.3.5
   */
  @AliasFor(annotation = RequestMapping.class)
  String[] consumes() default {};

  /**
   * Alias for {@link RequestMapping#produces}.
   */
  @AliasFor(annotation = RequestMapping.class)
  String[] produces() default {};
}
