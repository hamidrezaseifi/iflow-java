package com.pth.iflow.core.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.edo.CompanyEdo;
import com.pth.iflow.common.models.edo.CompanyWorkflowtypeItemOcrSettingPresetEdo;
import com.pth.iflow.common.models.edo.CompanyWorkflowtypeItemOcrSettingPresetItemEdo;
import com.pth.iflow.core.model.entity.CompanyEntity;
import com.pth.iflow.core.model.entity.CompanyWorkflowtypeItemOcrSettingPresetEntity;
import com.pth.iflow.core.model.entity.CompanyWorkflowtypeItemOcrSettingPresetItemEntity;
import com.pth.iflow.core.service.base.CoreModelEdoMapperService;
import com.pth.iflow.core.service.interfaces.ICompanyService;
import com.pth.iflow.core.storage.dao.helper.ICoreEntityVersion;
import com.pth.iflow.core.storage.dao.impl.base.EntityDaoBase;
import com.pth.iflow.core.storage.dao.interfaces.ICompanyDao;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowTypeDao;

@Service
public class CompanyService extends CoreModelEdoMapperService<CompanyEntity, CompanyEdo> implements ICompanyService {

  private final ICompanyDao companyDao;
  private final IWorkflowTypeDao workflowTypeDao;

  public CompanyService(@Autowired final ICompanyDao companyDao, @Autowired final IWorkflowTypeDao workflowDao) {

    this.companyDao = companyDao;
    this.workflowTypeDao = workflowDao;

  }

  @Override
  public CompanyEntity getByIdentity(final String identity) {

    return this.companyDao.getByIdentity(identity);
  }

  @Override
  public CompanyEntity save(final CompanyEntity model) {

    if (model.isNew()) {

      return companyDao.create(model);
    }

    final CompanyEntity exists = companyDao.getByIdentity(model.getIdentity());
    model.verifyVersion(exists);
    model.increaseVersion();

    return companyDao.update(model);
  }

  @Override
  public List<CompanyWorkflowtypeItemOcrSettingPresetEntity> readCompanyWorkflowtypeItemOcrSettings(final Long id) {

    return companyDao.readCompanyWorkflowtypeItemOcrSettings(id);
  }

  @Override
  public List<CompanyWorkflowtypeItemOcrSettingPresetEntity>
      readCompanyWorkflowtypeItemOcrSettingsByCompanyIdentity(final String identity) {

    return companyDao.readCompanyWorkflowtypeItemOcrSettingsByCompanyIdentity(identity);
  }

  @Override
  public List<CompanyWorkflowtypeItemOcrSettingPresetEntity> saveCompanyWorkflowtypeItemOcrSettings(
      final List<CompanyWorkflowtypeItemOcrSettingPresetEntity> list) {

    return companyDao.saveCompanyWorkflowtypeItemOcrSettings(list);
  }

  protected CompanyEntity prepareSavingModel(final CompanyEntity model) {

    return model;
  }

  @Override
  public CompanyEntity fromEdo(final CompanyEdo edo) throws IFlowMessageConversionFailureException {

    validateCustomer(edo);

    final CompanyEntity model = new CompanyEntity();

    this.setIdFromIdentity(model, edo.getIdentity(), (EntityDaoBase<ICoreEntityVersion>) this.companyDao);

    model.setCompanyName(edo.getCompanyName());
    model.setIdentity(edo.getIdentity());
    model.setStatus(edo.getStatus());
    model.setVersion(edo.getVersion());
    model.setCompanyType(edo.getCompanyType());
    model.setCompanyTypeCustome(edo.getCompanyTypeCustome());

    return model;
  }

  @Override
  public CompanyEdo toEdo(final CompanyEntity model) {

    final CompanyEdo edo = new CompanyEdo();
    edo.setCompanyName(model.getCompanyName());
    edo.setIdentity(model.getIdentity());
    edo.setStatus(model.getStatus());
    edo.setVersion(model.getVersion());
    edo.setCompanyType(model.getCompanyType());
    edo.setCompanyTypeCustome(model.getCompanyTypeCustome());

    return edo;
  }

  @Override
  public List<CompanyWorkflowtypeItemOcrSettingPresetEntity>
      fromCompanyWorkflowtypeItemOcrSettingPresetEdoList(final List<CompanyWorkflowtypeItemOcrSettingPresetEdo> edoList) {

    final List<CompanyWorkflowtypeItemOcrSettingPresetEntity> modelList = new ArrayList<>();
    for (final CompanyWorkflowtypeItemOcrSettingPresetEdo edo : edoList) {
      modelList.add(fromCompanyWorkflowtypeItemOcrSettingPresetEdo(edo));
    }

    return modelList;
  }

  @Override
  public List<CompanyWorkflowtypeItemOcrSettingPresetEdo>
      toCompanyWorkflowtypeItemOcrSettingPresetEdoList(final List<CompanyWorkflowtypeItemOcrSettingPresetEntity> modelList) {

    final List<CompanyWorkflowtypeItemOcrSettingPresetEdo> edoList = new ArrayList<>();
    for (final CompanyWorkflowtypeItemOcrSettingPresetEntity model : modelList) {
      edoList.add(toCompanyWorkflowtypeItemOcrSettingPresetEdo(model));
    }

    return edoList;
  }

  private CompanyWorkflowtypeItemOcrSettingPresetEntity
      fromCompanyWorkflowtypeItemOcrSettingPresetEdo(final CompanyWorkflowtypeItemOcrSettingPresetEdo edo) {

    final CompanyWorkflowtypeItemOcrSettingPresetEntity model = new CompanyWorkflowtypeItemOcrSettingPresetEntity();
    model.setCompany(this.companyDao.getByIdentity(edo.getCompanyIdentity()));
    model.setPresetName(edo.getPresetName());
    model.setStatus(edo.getStatus());
    model.setVersion(edo.getVersion());
    model.setWorkflowType(workflowTypeDao.getByIdentity(edo.getWorkflowTypeIdentity()));

    final List<CompanyWorkflowtypeItemOcrSettingPresetItemEntity> itemList = edo
        .getItems()
        .stream()
        .map(i -> fromCompanyWorkflowtypeItemOcrSettingPresetItemEdo(i))
        .collect(Collectors.toList());

    model.setItems(itemList);

    return model;
  }

  private CompanyWorkflowtypeItemOcrSettingPresetEdo
      toCompanyWorkflowtypeItemOcrSettingPresetEdo(final CompanyWorkflowtypeItemOcrSettingPresetEntity model) {

    final CompanyWorkflowtypeItemOcrSettingPresetEdo edo = new CompanyWorkflowtypeItemOcrSettingPresetEdo();
    edo.setCompanyIdentity(model.getCompany().getIdentity());
    edo.setPresetName(model.getPresetName());
    edo.setStatus(model.getStatus());
    edo.setVersion(model.getVersion());
    edo.setWorkflowTypeIdentity(model.getWorkflowType().getIdentity());

    final List<CompanyWorkflowtypeItemOcrSettingPresetItemEdo> itemEdoList = model
        .getItems()
        .stream()
        .map(i -> toCompanyWorkflowtypeItemOcrSettingPresetItemEdo(i))
        .collect(Collectors.toList());

    edo.setItems(itemEdoList);

    return edo;
  }

  private CompanyWorkflowtypeItemOcrSettingPresetItemEntity
      fromCompanyWorkflowtypeItemOcrSettingPresetItemEdo(final CompanyWorkflowtypeItemOcrSettingPresetItemEdo edo) {

    final CompanyWorkflowtypeItemOcrSettingPresetItemEntity model = new CompanyWorkflowtypeItemOcrSettingPresetItemEntity();
    model.setOcrType(edo.getOcrType());
    model.setPropertyName(edo.getPropertyName());
    model.setStatus(edo.getStatus());
    model.setValue(edo.getValue());
    model.setVersion(edo.getVersion());

    return model;
  }

  private CompanyWorkflowtypeItemOcrSettingPresetItemEdo
      toCompanyWorkflowtypeItemOcrSettingPresetItemEdo(final CompanyWorkflowtypeItemOcrSettingPresetItemEntity model) {

    final CompanyWorkflowtypeItemOcrSettingPresetItemEdo edo = new CompanyWorkflowtypeItemOcrSettingPresetItemEdo();
    edo.setOcrType(model.getOcrType());
    edo.setPropertyName(model.getPropertyName());
    edo.setStatus(model.getStatus());
    edo.setValue(model.getValue());
    edo.setVersion(model.getVersion());

    return edo;
  }

}
