package com.pth.iflow.workflow.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.net.URI;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.models.edo.ProfileResponseEdo;
import com.pth.iflow.workflow.TestDataProducer;
import com.pth.iflow.workflow.bl.ITokenValidator;
import com.pth.iflow.workflow.bl.impl.TokenValidator;
import com.pth.iflow.workflow.config.WorkflowConfiguration;
import com.pth.iflow.workflow.models.ProfileResponse;
import com.pth.iflow.workflow.models.mapper.WorkflowModelEdoMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TokenValidatorTest extends TestDataProducer {

  private ITokenValidator                          tokenValidator;

  @Mock
  private IRestTemplateCall                        restTemplate;

  @MockBean
  private WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig;

  @Before
  public void setUp() throws Exception {
    this.tokenValidator = new TokenValidator(this.restTemplate, this.moduleAccessConfig);

    when(this.moduleAccessConfig.generateCoreUrl(any(URI.class))).thenReturn(new URI("http://any-string"));

    when(this.moduleAccessConfig.generateProfileUrl(any(URI.class))).thenReturn(new URI("http://any-string"));
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testIsTokenValid() throws Exception {

    final ProfileResponseEdo profileResponseEdo = new ProfileResponseEdo(WorkflowModelEdoMapper.toEdo(this.getTestUser()),
        WorkflowModelEdoMapper.toEdo(this.getTestCompanyProfile()), "sessionid");

    when(this.restTemplate.callRestPost(any(URI.class), any(String.class), any(EModule.class), any(), eq(ProfileResponseEdo.class),
        any(boolean.class))).thenReturn(profileResponseEdo);

    final ProfileResponse resProfileResponse = this.tokenValidator.isTokenValid("token");

    Assert.assertNotNull("Result profile-response is not null!", resProfileResponse);
    Assert.assertNotNull("Result user from profile-response is not null!", resProfileResponse.getUser());
    Assert.assertNotNull("Result company from profile-response is not null!", resProfileResponse.getCompanyProfile());
    Assert.assertEquals("Result session-id from profile-response is as expected!", resProfileResponse.getSessionid(),
        profileResponseEdo.getSessionid());
    Assert.assertEquals("Result companyname from profile-response is as expected !",
        resProfileResponse.getCompanyProfile().getCompany().getCompanyName(),
        profileResponseEdo.getCompanyProfile().getCompany().getCompanyName());
    Assert.assertEquals("Result the email from user from profile-response is as expected !", resProfileResponse.getUser().getEmail(),
        profileResponseEdo.getUser().getEmail());

  }

}
