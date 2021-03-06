package com.pth.iflow.core.service.interfaces;

import java.util.Collection;
import java.util.List;

import com.pth.iflow.common.models.edo.DepartmentEdo;
import com.pth.iflow.core.model.entity.DepartmentEntity;
import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.service.base.ICoreModelEdoMapperService;

public interface IDepartmentService extends ICoreModelEdoMapperService<DepartmentEntity, DepartmentEdo> {

  DepartmentEntity save(DepartmentEntity model);

  void delete(DepartmentEntity model);

  DepartmentEntity getByIdentity(final String identity);

  List<DepartmentEntity> getListByIdentityList(final Collection<String> idList);

  List<DepartmentEntity> getListByIdCompanyIdentity(final String identity);

  UserEntity getDepartmentManager(final String identity);

  UserEntity getDepartmentDeputy(final String identity);

}
