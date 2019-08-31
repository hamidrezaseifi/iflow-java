package com.pth.iflow.common.edo.models.base;

import java.util.List;
import java.util.stream.Collectors;

public abstract class ModelMapperBase<E, M> {

  public ModelMapperBase() {

  }

  public abstract E toEdo();

  public abstract M fromEdo(E edo);

  public static <E, M extends ModelMapperBase<E, M>> List<E> toEdoList(final List<M> list) {
    if (list == null) {
      return null;
    }
    final List<E> edoList = list.stream().map(m -> m.toEdo()).collect(Collectors.toList());

    return edoList;
  }

  public List<M> fromEdoList(final List<E> list) {
    if (list == null) {
      return null;
    }
    return list.stream().map(m -> this.fromEdo(m)).collect(Collectors.toList());
  }

}
