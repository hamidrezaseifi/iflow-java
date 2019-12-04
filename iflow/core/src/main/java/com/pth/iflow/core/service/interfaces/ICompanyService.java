package com.pth.iflow.core.service.interfaces;

import com.pth.iflow.common.edo.models.CompanyEdo;
import com.pth.iflow.core.model.entity.CompanyEntity;
import com.pth.iflow.core.service.base.ICoreModelEdoMapperService;

public interface ICompanyService extends ICoreModelEdoMapperService<CompanyEntity, CompanyEdo> {

  CompanyEntity save(CompanyEntity model);

  CompanyEntity getByIdentity(final String identifyId);

}
