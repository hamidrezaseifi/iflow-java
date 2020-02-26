package com.pth.iflow.core.service.interfaces;

import java.util.List;

import com.pth.iflow.common.models.edo.CompanyEdo;
import com.pth.iflow.common.models.edo.CompanyWorkflowtypeItemOcrSettingEdo;
import com.pth.iflow.core.model.entity.CompanyEntity;
import com.pth.iflow.core.model.entity.CompanyWorkflowtypeItemOcrSettingPresetItemEntity;
import com.pth.iflow.core.service.base.ICoreModelEdoMapperService;

public interface ICompanyService extends ICoreModelEdoMapperService<CompanyEntity, CompanyEdo> {

  CompanyEntity save(CompanyEntity model);

  CompanyEntity getByIdentity(final String identifyId);

  List<CompanyWorkflowtypeItemOcrSettingPresetItemEntity> readCompanyWorkflowtypeItemOcrSettings(Long id);

  List<CompanyWorkflowtypeItemOcrSettingPresetItemEntity> readCompanyWorkflowtypeItemOcrSettingsByCompanyIdentity(String identity);

  List<CompanyWorkflowtypeItemOcrSettingPresetItemEntity> saveCompanyWorkflowtypeItemOcrSettings(
      final List<CompanyWorkflowtypeItemOcrSettingPresetItemEntity> list);

  List<CompanyWorkflowtypeItemOcrSettingPresetItemEntity>
      fromCompanyWorkflowtypeItemOcrSettingEdoList(List<CompanyWorkflowtypeItemOcrSettingEdo> edoList);

  List<CompanyWorkflowtypeItemOcrSettingEdo>
      toCompanyWorkflowtypeItemOcrSettingEdoList(List<CompanyWorkflowtypeItemOcrSettingPresetItemEntity> modelList);
}
