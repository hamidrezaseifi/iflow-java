package com.pth.iflow.core.service.interfaces;

import java.util.List;

import com.pth.iflow.common.models.edo.CompanyEdo;
import com.pth.iflow.common.models.edo.CompanyWorkflowtypeItemOcrSettingPresetEdo;
import com.pth.iflow.core.model.entity.CompanyEntity;
import com.pth.iflow.core.model.entity.CompanyWorkflowTypeOcrSettingPresetEntity;
import com.pth.iflow.core.service.base.ICoreModelEdoMapperService;

public interface ICompanyService extends ICoreModelEdoMapperService<CompanyEntity, CompanyEdo> {

  CompanyEntity save(CompanyEntity model);

  CompanyEntity getByIdentity(final String identifyId);

  List<CompanyWorkflowTypeOcrSettingPresetEntity> readCompanyWorkflowtypeItemOcrSettings(Long id);

  List<CompanyWorkflowTypeOcrSettingPresetEntity> readCompanyWorkflowtypeItemOcrSettingsByCompanyIdentity(String identity);

  CompanyWorkflowTypeOcrSettingPresetEntity saveCompanyWorkflowtypeItemOcrSetting(
      final CompanyWorkflowTypeOcrSettingPresetEntity preset);

  CompanyWorkflowTypeOcrSettingPresetEntity
      fromCompanyWorkflowtypeItemOcrSettingPresetEdo(final CompanyWorkflowtypeItemOcrSettingPresetEdo edo);

  List<CompanyWorkflowTypeOcrSettingPresetEntity>
      fromCompanyWorkflowtypeItemOcrSettingPresetEdoList(List<CompanyWorkflowtypeItemOcrSettingPresetEdo> edoList);

  List<CompanyWorkflowtypeItemOcrSettingPresetEdo>
      toCompanyWorkflowtypeItemOcrSettingPresetEdoList(List<CompanyWorkflowTypeOcrSettingPresetEntity> modelList);

  CompanyWorkflowtypeItemOcrSettingPresetEdo
      toCompanyWorkflowtypeItemOcrSettingPresetEdo(CompanyWorkflowTypeOcrSettingPresetEntity modelSaved);
}
