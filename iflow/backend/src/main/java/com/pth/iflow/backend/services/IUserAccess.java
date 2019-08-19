package com.pth.iflow.backend.services;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.backend.exceptions.BackendCustomizedException;
import com.pth.iflow.backend.models.BackendUser;

public interface IUserAccess {

  BackendUser readUser(final Long userId) throws BackendCustomizedException, MalformedURLException;

  BackendUser saveUser(final BackendUser user) throws BackendCustomizedException, MalformedURLException;

  List<BackendUser> readCompanyUserList(final Long companyId) throws BackendCustomizedException, MalformedURLException;

}
