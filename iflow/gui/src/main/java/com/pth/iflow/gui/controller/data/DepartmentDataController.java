package com.pth.iflow.gui.controller.data;

import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.models.Department;
import com.pth.iflow.gui.services.IDepartmentHandler;

@Controller
@RequestMapping(value = "/departments/data")
public class DepartmentDataController extends GuiDataControllerBase {

  @Autowired
  private IDepartmentHandler departmentHandler;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/list" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public List<Department> listDepartments() throws MalformedURLException, IFlowMessageConversionFailureException {

    return this.departmentHandler.getCompanyDepartmentList(this.getLoggedCompany().getIdentity());
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/create" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public Department createDepartment(@RequestBody final Department requestDepartment)
      throws MalformedURLException, IFlowMessageConversionFailureException {

    requestDepartment.setCompanyIdentity(this.getLoggedCompany().getIdentity());
    final Department department = this.departmentHandler.createDepartment(requestDepartment);
    return department;
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/update" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public Department saveDepartment(@RequestBody final Department requestUser)
      throws MalformedURLException, IFlowMessageConversionFailureException {

    requestUser.setCompanyIdentity(this.getLoggedCompany().getIdentity());
    final Department department = this.departmentHandler.updateDepartment(requestUser);
    return department;
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/delete" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public void deleteDepartment(@RequestBody final Department department)
      throws MalformedURLException, IFlowMessageConversionFailureException {

    this.departmentHandler.deleteDepartment(department);
  }

}
