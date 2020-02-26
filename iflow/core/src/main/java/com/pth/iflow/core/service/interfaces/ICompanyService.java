package com.pth.iflow.core.service.interfaces;

import java.util.List;

import com.pth.iflow.common.models.edo.CompanyEdo;
import com.pth.iflow.common.models.edo.CompanyWorkflowtypeItemOcrSettingPresetEdo;
import com.pth.iflow.core.model.entity.CompanyEntity;
import com.pth.iflow.core.model.entity.CompanyWorkflowtypeItemOcrSettingPresetEntity;
import com.pth.iflow.core.service.base.ICoreModelEdoMapperService;

public interface ICompanyService extends ICoreModelEdoMapperService<CompanyEntity, CompanyEdo> {

  CompanyEntity save(CompanyEntity model);

  CompanyEntity getByIdentity(final String identifyId);

  List<CompanyWorkflowtypeItemOcrSettingPresetEntity> readCompanyWorkflowtypeItemOcrSettings(Long id);

  List<CompanyWorkflowtypeItemOcrSettingPresetEntity> readCompanyWorkflowtypeItemOcrSettingsByCompanyIdentity(String identity);

  List<CompanyWorkflowtypeItemOcrSettingPresetEntity> saveCompanyWorkflowtypeItemOcrSettings(
      final List<CompanyWorkflowtypeItemOcrSettingPresetEntity> list);

  List<CompanyWorkflowtypeItemOcrSettingPresetEntity>
      fromCompanyWorkflowtypeItemOcrSettingPresetEdoList(List<CompanyWorkflowtypeItemOcrSettingPresetEdo> edoList);

  List<CompanyWorkflowtypeItemOcrSettingPresetEdo>
      toCompanyWorkflowtypeItemOcrSettingPresetEdoList(List<CompanyWorkflowtypeItemOcrSettingPresetEntity> modelList);
}
