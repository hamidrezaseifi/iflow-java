package com.pth.iflow.core.service.interfaces;

import java.util.Collection;
import java.util.List;

import com.pth.iflow.common.models.DepartmentGroupEdo;
import com.pth.iflow.core.model.entity.DepartmentGroupEntity;
import com.pth.iflow.core.service.base.ICoreModelEdoMapperService;

public interface IDepartmentGroupService extends ICoreModelEdoMapperService<DepartmentGroupEntity, DepartmentGroupEdo> {

  DepartmentGroupEntity save(DepartmentGroupEntity model);

  DepartmentGroupEntity getByIdentity(final String identity);

  List<DepartmentGroupEntity> getListByIdentityList(final Collection<String> idList);

}
