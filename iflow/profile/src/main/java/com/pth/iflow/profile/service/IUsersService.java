package com.pth.iflow.profile.service;

import java.net.MalformedURLException;
import java.util.List;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.User;

public interface IUsersService {

  User getUserByEmail(final String email) throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  User getUserById(final Long id) throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;

  List<User> getUserListByCompanyId(final Long companyId) throws ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException;
}
