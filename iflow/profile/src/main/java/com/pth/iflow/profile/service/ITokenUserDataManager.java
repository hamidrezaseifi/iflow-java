package com.pth.iflow.profile.service;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.Department;
import com.pth.iflow.profile.model.DepartmentGroup;
import com.pth.iflow.profile.model.ProfileResponse;
import com.pth.iflow.profile.model.User;
import com.pth.iflow.profile.model.UserAuthenticationSession;
import com.pth.iflow.profile.model.UserGroup;

public interface ITokenUserDataManager {

  ProfileResponse getProfileByToken(String token) throws ProfileCustomizedException, MalformedURLException, URISyntaxException, IFlowMessageConversionFailureException;

  UserAuthenticationSession validateToken(String token) throws ProfileCustomizedException, IFlowMessageConversionFailureException;

  ProfileResponse getProfileByTokenAndCheckCompany(String token, Long companyId) throws ProfileCustomizedException, MalformedURLException, URISyntaxException, IFlowMessageConversionFailureException;

  ProfileResponse getProfileByTokenEmail(String email, String token) throws ProfileCustomizedException, MalformedURLException, URISyntaxException, IFlowMessageConversionFailureException;

  List<User> getUserListByToken(String token, Long companyId) throws ProfileCustomizedException, MalformedURLException, URISyntaxException, IFlowMessageConversionFailureException;

  List<UserGroup> getUserGroupListByToken(String token, Long companyId) throws ProfileCustomizedException, MalformedURLException, URISyntaxException, IFlowMessageConversionFailureException;

  List<Department> getDepartmentListByToken(String token, Long companyId) throws ProfileCustomizedException, MalformedURLException, URISyntaxException, IFlowMessageConversionFailureException;

  Department getDepartmentById(String token, Long id) throws ProfileCustomizedException, MalformedURLException, URISyntaxException, IFlowMessageConversionFailureException;

  List<DepartmentGroup> getDepartmentGroupListByDepartmentId(String token, Long id) throws ProfileCustomizedException, MalformedURLException, URISyntaxException, IFlowMessageConversionFailureException;

  List<User> getAllUserListByDepartmentId(String token, Long id) throws ProfileCustomizedException, MalformedURLException, URISyntaxException, IFlowMessageConversionFailureException;

  DepartmentGroup getDepartmentGroupById(String token, Long id) throws ProfileCustomizedException, MalformedURLException, URISyntaxException, IFlowMessageConversionFailureException;

  List<User> getAllUserListByDepartmentGroupId(String token, Long id) throws ProfileCustomizedException, MalformedURLException, URISyntaxException, IFlowMessageConversionFailureException;

}
