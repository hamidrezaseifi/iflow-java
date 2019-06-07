package com.pth.ifow.profile.service;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import com.pth.ifow.profile.exceptions.ProfileCustomizedException;
import com.pth.ifow.profile.model.Company;

public interface ICompanyService {

  Company getById(final Long comapnyId) throws ProfileCustomizedException, URISyntaxException, MalformedURLException;
}
