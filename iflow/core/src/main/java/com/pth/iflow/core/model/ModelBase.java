package com.pth.iflow.core.model;

import java.util.List;
import java.util.stream.Collectors;

public abstract class ModelBase<E> {

  public ModelBase() {

  }

  public abstract E toEdo();

  protected abstract void initFromEdo(E edo);

  public static <E, T extends ModelBase<E>> List<E> toEdoList(final List<T> list) {

    final List<E> edoList = list.stream().map(m -> m.toEdo()).collect(Collectors.toList());

    return edoList;
  }

}
