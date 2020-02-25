package com.pth.iflow.common.models.edo;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.pth.iflow.common.models.base.IFlowJaxbDefinition;

@XmlRootElement(name = "CompanyWorkflowtypeItemOcrSettingList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "CompanyWorkflowtypeItemOcrSettingList" + IFlowJaxbDefinition.TYPE_PREFIX)
public class CompanyWorkflowtypeItemOcrSettingListEdo {

  @NotNull
  @XmlElementWrapper(name = "CompanyWorkflowtypeItemOcrSettingList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "CompanyWorkflowtypeItemOcrSetting", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private final List<CompanyWorkflowtypeItemOcrSettingEdo> companyWorkflowtypeItemOcrSettings = new ArrayList<>();

  public CompanyWorkflowtypeItemOcrSettingListEdo() {

  }

  public CompanyWorkflowtypeItemOcrSettingListEdo(final List<CompanyWorkflowtypeItemOcrSettingEdo> companyWorkflowtypeItemOcrSettings) {

    this.setCompanyWorkflowtypeItemOcrSettings(companyWorkflowtypeItemOcrSettings);
  }

  public List<CompanyWorkflowtypeItemOcrSettingEdo> getCompanyWorkflowtypeItemOcrSettings() {

    return this.companyWorkflowtypeItemOcrSettings;
  }

  @JsonSetter
  public void setCompanyWorkflowtypeItemOcrSettings(final List<CompanyWorkflowtypeItemOcrSettingEdo> companyWorkflowtypeItemOcrSettings) {

    this.companyWorkflowtypeItemOcrSettings.clear();
    if (companyWorkflowtypeItemOcrSettings != null) {
      this.companyWorkflowtypeItemOcrSettings.addAll(companyWorkflowtypeItemOcrSettings);
    }
  }

}
