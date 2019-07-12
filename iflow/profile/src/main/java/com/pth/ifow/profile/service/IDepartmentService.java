package com.pth.ifow.profile.service;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.ifow.profile.exceptions.ProfileCustomizedException;
import com.pth.ifow.profile.model.Department;

public interface IDepartmentService {

  Department getById(final Long id) throws ProfileCustomizedException, MalformedURLException;

  List<Department> getListByComaonyId(final Long companyId) throws ProfileCustomizedException, MalformedURLException;
}
