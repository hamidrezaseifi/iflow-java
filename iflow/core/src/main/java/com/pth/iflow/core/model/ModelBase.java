package com.pth.iflow.core.model;

import java.util.ArrayList;
import java.util.List;

public abstract class ModelBase<E> {

  public abstract E toEdo();

  public static <E, T extends ModelBase<E>> List<E> toEdoList(final List<T> list) {

    final List<E> edoList = new ArrayList<>();
    for (final T model : list) {
      edoList.add(model.toEdo());
    }
    return edoList;
  }
}
