package com.pth.iflow.core.service.interfaces;

import java.util.Collection;
import java.util.List;

import com.pth.iflow.common.models.edo.DepartmentGroupEdo;
import com.pth.iflow.core.model.entity.DepartmentGroupEntity;
import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.service.base.ICoreModelEdoMapperService;

public interface IDepartmentGroupService extends ICoreModelEdoMapperService<DepartmentGroupEntity, DepartmentGroupEdo> {

  DepartmentGroupEntity save(DepartmentGroupEntity model);

  DepartmentGroupEntity getByIdentity(final String identity);

  List<DepartmentGroupEntity> getListByIdentityList(final Collection<String> idList);

  public UserEntity getDepartmentGroupManager(final String identity);

  public UserEntity getDepartmentGroupDeputy(final String identity);

}
