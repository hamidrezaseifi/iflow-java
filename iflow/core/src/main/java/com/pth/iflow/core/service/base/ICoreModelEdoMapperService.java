package com.pth.iflow.core.service.base;

import java.util.List;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;

public interface ICoreModelEdoMapperService<M, E> {

  M fromEdo(E edo) throws IFlowMessageConversionFailureException;

  E toEdo(M model);

  List<E> toEdoList(final List<M> modelList);

  List<M> fromEdoList(final List<E> edoList) throws IFlowMessageConversionFailureException;

}
