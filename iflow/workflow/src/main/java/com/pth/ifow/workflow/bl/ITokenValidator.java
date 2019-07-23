package com.pth.ifow.workflow.bl;

import java.net.MalformedURLException;

import com.pth.ifow.workflow.exceptions.WorkflowCustomizedException;
import com.pth.ifow.workflow.models.ProfileResponse;

public interface ITokenValidator {
  ProfileResponse isTokenValid(String token) throws WorkflowCustomizedException, MalformedURLException;
}
