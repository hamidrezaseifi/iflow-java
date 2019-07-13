package com.pth.ifow.profile.service;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

import com.pth.ifow.profile.exceptions.ProfileCustomizedException;
import com.pth.ifow.profile.model.Department;
import com.pth.ifow.profile.model.DepartmentGroup;
import com.pth.ifow.profile.model.ProfileResponse;
import com.pth.ifow.profile.model.User;
import com.pth.ifow.profile.model.UserGroup;

public interface ITokenUserDataManager {

  ProfileResponse getProfileByToken(String token) throws ProfileCustomizedException, MalformedURLException, URISyntaxException;

  ProfileResponse getProfileByTokenAndCheckCompany(String token, Long companyId)
      throws ProfileCustomizedException, MalformedURLException, URISyntaxException;

  ProfileResponse getProfileByTokenEmail(String email, String token)
      throws ProfileCustomizedException, MalformedURLException, URISyntaxException;

  List<User> getUserListByToken(String token, Long companyId)
      throws ProfileCustomizedException, MalformedURLException, URISyntaxException;

  List<UserGroup> getUserGroupListByToken(String token, Long companyId)
      throws ProfileCustomizedException, MalformedURLException, URISyntaxException;

  List<Department> getDepartmentListByToken(String token, Long companyId)
      throws ProfileCustomizedException, MalformedURLException, URISyntaxException;

  Department getDepartmentById(String token, Long id) throws ProfileCustomizedException, MalformedURLException, URISyntaxException;

  List<DepartmentGroup> getDepartmentGroupListByDepartmentId(String token, Long id)
      throws ProfileCustomizedException, MalformedURLException, URISyntaxException;

  List<User> getAllUserListByDepartmentId(String token, Long id)
      throws ProfileCustomizedException, MalformedURLException, URISyntaxException;

  DepartmentGroup getDepartmentGroupById(String token, Long id)
      throws ProfileCustomizedException, MalformedURLException, URISyntaxException;

  List<User> getAllUserListByDepartmentGroupId(String token, Long id)
      throws ProfileCustomizedException, MalformedURLException, URISyntaxException;

}
