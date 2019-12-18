package com.pth.iflow.core.service.interfaces;

import java.util.Collection;
import java.util.List;

import com.pth.iflow.common.models.edo.DepartmentEdo;
import com.pth.iflow.core.model.entity.DepartmentEntity;
import com.pth.iflow.core.model.entity.DepartmentGroupEntity;
import com.pth.iflow.core.service.base.ICoreModelEdoMapperService;

public interface IDepartmentService extends ICoreModelEdoMapperService<DepartmentEntity, DepartmentEdo> {

  DepartmentEntity save(DepartmentEntity model);

  DepartmentEntity getByIdentity(final String identity);

  List<DepartmentEntity> getListByIdentityList(final Collection<String> idList);

  List<DepartmentEntity> getListByIdCompanyIdentity(final String identity);

  List<DepartmentGroupEntity> getDepartmentGroups(final String identity);

}
