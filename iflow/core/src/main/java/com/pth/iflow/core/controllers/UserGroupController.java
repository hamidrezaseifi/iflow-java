package com.pth.iflow.core.controllers;

import java.util.List;

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

import com.pth.iflow.common.edo.models.UserGroupEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.core.model.UserGroup;
import com.pth.iflow.core.model.Workflow;
import com.pth.iflow.core.service.IUserGroupService;

@RestController
@RequestMapping
public class UserGroupController {

  final IUserGroupService userGroupService;

  public UserGroupController(@Autowired final IUserGroupService userGroupService) {
    this.userGroupService = userGroupService;
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = IflowRestPaths.Core.USERGROUP_READ_BY_ID, produces = MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<UserGroupEdo> readUserGroup(@PathVariable(name = "id") final Long groupid) throws Exception {

    final UserGroup model = this.userGroupService.getById(groupid);

    return new ResponseEntity<>(model.toEdo(), HttpStatus.ACCEPTED);
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = IflowRestPaths.Core.USERGROUP_READ_LIST, produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<List<UserGroupEdo>> readUserGroupList(@RequestBody final List<Long> idList) throws Exception {

    final List<UserGroup> modelList = this.userGroupService.getListByIdList(idList);

    return new ResponseEntity<>(Workflow.toEdoList(modelList), HttpStatus.OK);
  }
  
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = IflowRestPaths.Core.USERGROUP_READ_LIST_BY_COMPANY, produces = MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<List<UserGroupEdo>> readUserGroupListByCompany(@PathVariable(name = "id") final Long id) throws Exception {
    
    final List<UserGroup> modelList = this.userGroupService.getListByIdCompanyId(id);
    
    return new ResponseEntity<>(Workflow.toEdoList(modelList), HttpStatus.OK);
  }

}
