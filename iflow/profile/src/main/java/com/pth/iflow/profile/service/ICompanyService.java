package com.pth.iflow.profile.service;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.Company;

public interface ICompanyService {

  Company getById(final Long comapnyId) throws ProfileCustomizedException, URISyntaxException, MalformedURLException;
}