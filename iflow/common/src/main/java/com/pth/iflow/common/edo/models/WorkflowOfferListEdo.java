package com.pth.iflow.common.edo.models;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.pth.iflow.common.edo.models.base.IFlowJaxbDefinition;

@XmlRootElement(name = "WorkflowOfferList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = IFlowJaxbDefinition.IFlow.NAMESPACE, name = "WorkflowOfferList" + IFlowJaxbDefinition.TYPE_PREFIX)
public class WorkflowOfferListEdo {

  @XmlElementWrapper(name = "WorkflowOfferList", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  @XmlElement(name = "WorkflowOffer", namespace = IFlowJaxbDefinition.IFlow.NAMESPACE)
  private List<WorkflowOfferEdo> workflowOffers = new ArrayList<>();

  public WorkflowOfferListEdo() {

  }

  public WorkflowOfferListEdo(final List<WorkflowOfferEdo> workflowOfferss) {
    this.setWorkflowOffers(workflowOfferss);
  }

  public List<WorkflowOfferEdo> getWorkflowOffers() {
    return workflowOffers;
  }

  public void setWorkflowOffers(final List<WorkflowOfferEdo> workflowOffers) {
    this.workflowOffers = workflowOffers;
  }

}