package com.pth.iflow.common.edo.models.base;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class ModelMapperBase<E, M> {

  public ModelMapperBase() {

  }

  public boolean isNew() {
    return getId() == null || getId() <= 0;
  }

  public abstract Integer getVersion();

  public abstract Long getId();

  public abstract void setVersion(final Integer version);

  public void increaseVersion() {
    this.setVersion(this.getVersion() == null ? 1 : this.getVersion() + 1);
  }

  public abstract E toEdo();

  public abstract M fromEdo(E edo);

  public static <E, M extends ModelMapperBase<E, M>> List<E> toEdoList(final List<M> list) {

    final List<E> edoList = list.stream().map(m -> m.toEdo()).collect(Collectors.toList());

    return edoList;
  }

  public static <E, M extends ModelMapperBase<E, M>> List<E> toEdoList(final Set<M> list) {

    return toEdoList(list.stream().collect(Collectors.toList()));
  }

  public List<M> fromEdoList(final List<E> list) {

    return list.stream().map(m -> this.fromEdo(m)).collect(Collectors.toList());
  }

  public List<M> fromEdoList(final Set<E> list) {

    return fromEdoList(list.stream().collect(Collectors.toList()));
  }

}
