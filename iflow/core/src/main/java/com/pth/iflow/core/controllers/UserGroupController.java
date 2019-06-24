package com.pth.iflow.core.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pth.iflow.common.controllers.helper.ControllerHelper;
import com.pth.iflow.common.edo.models.UserGroupEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.core.model.UserGroup;
import com.pth.iflow.core.service.IUserGroupService;

@RestController
@RequestMapping
public class UserGroupController {
  
  final IUserGroupService userGroupService;
  
  public UserGroupController(@Autowired final IUserGroupService userGroupService) {
    this.userGroupService = userGroupService;
  }
  
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = IflowRestPaths.CoreModul.USERGROUP_READ_BY_ID, produces = {
      MediaType.APPLICATION_XML_VALUE,
      MediaType.APPLICATION_JSON_UTF8_VALUE })
  public ResponseEntity<UserGroupEdo> readUserGroup(@PathVariable(name = "id") final Long groupid, final HttpServletRequest request)
      throws Exception {
    
    final UserGroup model = this.userGroupService.getById(groupid);
    
    return ControllerHelper.createResponseEntity(request, model.toEdo(), HttpStatus.OK);
  }
  
  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = IflowRestPaths.CoreModul.USERGROUP_READ_LIST, consumes = {
      MediaType.APPLICATION_XML_VALUE,
      MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = {
          MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
  public ResponseEntity<List<UserGroupEdo>> readUserGroupList(@RequestBody final List<Long> idList, final HttpServletRequest request)
      throws Exception {
    
    final List<UserGroup> modelList = this.userGroupService.getListByIdList(idList);
    
    return ControllerHelper.createResponseEntity(request, UserGroup.toEdoList(modelList), HttpStatus.OK);
  }
  
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = IflowRestPaths.CoreModul.USERGROUP_READ_LIST_BY_COMPANY, produces = {
      MediaType.APPLICATION_XML_VALUE,
      MediaType.APPLICATION_JSON_UTF8_VALUE })
  public ResponseEntity<List<UserGroupEdo>> readUserGroupListByCompany(@PathVariable(name = "id") final Long id,
      final HttpServletRequest request) throws Exception {
    
    final List<UserGroup> modelList = this.userGroupService.getListByIdCompanyId(id);
    
    return ControllerHelper.createResponseEntity(request, UserGroup.toEdoList(modelList), HttpStatus.OK);
  }
  
}
