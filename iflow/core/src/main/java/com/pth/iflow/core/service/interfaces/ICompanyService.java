package com.pth.iflow.core.service.interfaces;

import java.util.List;

import com.pth.iflow.common.models.edo.CompanyEdo;
import com.pth.iflow.common.models.edo.CompanyWorkflowtypeItemOcrSettingEdo;
import com.pth.iflow.core.model.entity.CompanyEntity;
import com.pth.iflow.core.model.entity.CompanyWorkflowtypeItemOcrSettingEntity;
import com.pth.iflow.core.service.base.ICoreModelEdoMapperService;

public interface ICompanyService extends ICoreModelEdoMapperService<CompanyEntity, CompanyEdo> {

  CompanyEntity save(CompanyEntity model);

  CompanyEntity getByIdentity(final String identifyId);

  List<CompanyWorkflowtypeItemOcrSettingEntity> readCompanyWorkflowtypeItemOcrSettings(Long id);

  List<CompanyWorkflowtypeItemOcrSettingEntity> readCompanyWorkflowtypeItemOcrSettingsByCompanyIdentity(String identity);

  List<CompanyWorkflowtypeItemOcrSettingEntity> saveCompanyWorkflowtypeItemOcrSettings(
      final List<CompanyWorkflowtypeItemOcrSettingEntity> list);

  List<CompanyWorkflowtypeItemOcrSettingEntity>
      fromCompanyWorkflowtypeItemOcrSettingEdoList(List<CompanyWorkflowtypeItemOcrSettingEdo> edoList);

  List<CompanyWorkflowtypeItemOcrSettingEdo>
      toCompanyWorkflowtypeItemOcrSettingEdoList(List<CompanyWorkflowtypeItemOcrSettingEntity> modelList);
}
