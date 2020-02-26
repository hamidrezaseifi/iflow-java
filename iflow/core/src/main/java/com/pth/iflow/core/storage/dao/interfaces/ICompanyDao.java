package com.pth.iflow.core.storage.dao.interfaces;

import java.util.List;

import com.pth.iflow.core.model.entity.CompanyEntity;
import com.pth.iflow.core.model.entity.CompanyWorkflowTypeControllerEntity;
import com.pth.iflow.core.model.entity.CompanyWorkflowtypeItemOcrSettingPresetEntity;
import com.pth.iflow.core.storage.dao.exception.IFlowStorageException;

public interface ICompanyDao {

  public CompanyEntity create(CompanyEntity model) throws IFlowStorageException;

  public CompanyEntity update(CompanyEntity model) throws IFlowStorageException;

  public CompanyEntity getById(Long id) throws IFlowStorageException;

  public CompanyEntity getByIdentity(final String identity);

  void deleteById(Long id) throws IFlowStorageException;

  public List<CompanyWorkflowTypeControllerEntity> readCompanyWorkflowTypeController(Long id);

  public List<CompanyWorkflowtypeItemOcrSettingPresetEntity> readCompanyWorkflowtypeItemOcrSettings(Long id);

  public List<CompanyWorkflowtypeItemOcrSettingPresetEntity> readCompanyWorkflowtypeItemOcrSettingsByCompanyIdentity(String identity);

  public List<CompanyWorkflowtypeItemOcrSettingPresetEntity> saveCompanyWorkflowtypeItemOcrSettings(
      final List<CompanyWorkflowtypeItemOcrSettingPresetEntity> list);

}
