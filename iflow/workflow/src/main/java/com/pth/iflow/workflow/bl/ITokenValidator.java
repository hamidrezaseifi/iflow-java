package com.pth.iflow.workflow.bl;

import java.net.MalformedURLException;

import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.iflow.workflow.models.ProfileResponse;

public interface ITokenValidator {
  
  ProfileResponse isTokenValid(String token) throws WorkflowCustomizedException, MalformedURLException;
}
