package com.pth.iflow.core.service.interfaces;

import java.util.Collection;
import java.util.List;

import com.pth.iflow.core.model.entity.DepartmentEntity;
import com.pth.iflow.core.model.entity.DepartmentGroupEntity;

public interface IDepartmentService {

  DepartmentEntity save(DepartmentEntity model);

  DepartmentEntity getByIdentity(final String identity);

  List<DepartmentEntity> getListByIdentityList(final Collection<String> idList);

  List<DepartmentEntity> getListByIdCompanyIdentity(final String identity);

  List<DepartmentGroupEntity> getDepartmentGroups(final String identity);

}
