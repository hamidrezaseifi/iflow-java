package com.pth.iflow.profile.test.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.pth.iflow.common.models.edo.AuthenticatedProfileRequestEdo;
import com.pth.iflow.common.models.edo.ProfileResponseEdo;
import com.pth.iflow.common.models.edo.TokenProfileRequestEdo;
import com.pth.iflow.common.moduls.security.IJwtTokenProvider;
import com.pth.iflow.common.moduls.security.JWTAuthorizationFilter;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.profile.model.Company;
import com.pth.iflow.profile.model.ProfileResponse;
import com.pth.iflow.profile.model.User;
import com.pth.iflow.profile.model.mapper.ProfileModelEdoMapper;
import com.pth.iflow.profile.service.handler.ITokenUserDataManager;
import com.pth.iflow.profile.test.TestDataProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProfileControllerTest extends TestDataProducer {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

  @Autowired
  private IJwtTokenProvider jwtTokenProvider;

  @MockBean
  private ITokenUserDataManager tokenUserDataManager;

  private User user;

  private Company company;

  private ProfileResponse validProfileResponse;

  private String validToken;

  private final String validSession = "valid-session";

  @Before
  public void setUp() throws Exception {

    final Set<String> roles = new HashSet<>();
    roles.add("USER");

    this.validToken = this.jwtTokenProvider.createToken("user@company.com", roles);

    this.user = this.getTestUser();
    this.company = this.getTestCompany();

    this.validProfileResponse = this.getTestProfileResponse(this.validSession);

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testReadAuthenticatedInfo() throws Exception {

    final AuthenticatedProfileRequestEdo profReq = this
        .getTestAuthenticatedProfileRequestEdo("valid-user", this.validToken);

    final ProfileResponseEdo responseEdo = this
        .getTestProfileResponseEdo(this.validSession,
            ProfileModelEdoMapper.toEdo(this.user), ProfileModelEdoMapper.toEdo(this.company));

    final String modelAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(profReq);
    final String responseAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(responseEdo);

    when(this.tokenUserDataManager.getProfileByTokenUserIdentity(any(String.class), any(String.class), any()))
        .thenReturn(this.validProfileResponse);

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .post(IflowRestPaths.ProfileModule.PROFILE_READ_AUTHENTOCATEDINFO)
            .content(modelAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .header(JWTAuthorizationFilter.AUTHORIZATION_HEADER_KEY, JWTAuthorizationFilter.AUTHORIZATION_PREFIX + this.validToken))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(responseAsXmlString));

    verify(this.tokenUserDataManager, times(1)).getProfileByTokenUserIdentity(any(String.class), any(String.class), any());

  }

  @Test
  public void testReadTokenInfo() throws Exception {

    final TokenProfileRequestEdo tokenInoRequest = this.getTokenProfileRequestEdo(this.validToken);

    final ProfileResponseEdo responseEdo = this
        .getTestProfileResponseEdo(this.validSession,
            ProfileModelEdoMapper.toEdo(this.user), ProfileModelEdoMapper.toEdo(this.company));

    final String modelAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(tokenInoRequest);
    final String responseAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(responseEdo);

    when(this.tokenUserDataManager.getProfileByToken(any(String.class), any()))
        .thenReturn(this.validProfileResponse);

    this.mockMvc
        .perform(MockMvcRequestBuilders
            .post(IflowRestPaths.ProfileModule.PROFILE_READ_TOKENINFO)
            .content(modelAsXmlString)
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .header(JWTAuthorizationFilter.AUTHORIZATION_HEADER_KEY, JWTAuthorizationFilter.AUTHORIZATION_PREFIX + this.validToken))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(responseAsXmlString));

    verify(this.tokenUserDataManager, times(1)).getProfileByToken(any(String.class), any());

  }

}
