package com.pth.iflow.core.service.interfaces;

import com.pth.iflow.core.model.entity.CompanyEntity;

public interface ICompanyService {

  CompanyEntity save(CompanyEntity model);

  CompanyEntity getByIdentity(final String identifyId);

}
