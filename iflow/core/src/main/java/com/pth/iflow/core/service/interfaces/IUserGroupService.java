package com.pth.iflow.core.service.interfaces;

import java.util.Collection;
import java.util.List;

import com.pth.iflow.common.edo.models.UserGroupEdo;
import com.pth.iflow.core.model.entity.UserGroupEntity;
import com.pth.iflow.core.service.base.ICoreModelEdoMapperService;

public interface IUserGroupService extends ICoreModelEdoMapperService<UserGroupEntity, UserGroupEdo> {

  UserGroupEntity save(UserGroupEntity model);

  UserGroupEntity getByIdentity(final String identity);

  List<UserGroupEntity> getListByIdentityList(final Collection<String> idList);

  List<UserGroupEntity> getListByIdCompanyIdentity(final String companyIdentity);
}
