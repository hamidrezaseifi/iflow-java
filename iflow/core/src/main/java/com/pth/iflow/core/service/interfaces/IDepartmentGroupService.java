package com.pth.iflow.core.service.interfaces;

import java.util.Collection;
import java.util.List;

import com.pth.iflow.core.model.entity.DepartmentGroupEntity;

public interface IDepartmentGroupService {

  DepartmentGroupEntity save(DepartmentGroupEntity model);

  DepartmentGroupEntity getByIdentity(final String identity);

  List<DepartmentGroupEntity> getListByIdentityList(final Collection<String> idList);

}
