package com.pth.iflow.common.edo.models.base;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class ModelMapperBase<E, EJ, M> {

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

  public abstract EJ toJsonEdo();

  public abstract M fromJsonEdo(EJ edo);

  public static <E, EJ, M extends ModelMapperBase<E, EJ, M>> List<E> toEdoList(final List<M> list) {

    final List<E> edoList = list.stream().map(m -> m.toEdo()).collect(Collectors.toList());

    return edoList;
  }

  public static <E, EJ, M extends ModelMapperBase<E, EJ, M>> List<EJ> toJsonEdoList(final List<M> list) {

    final List<EJ> edoJsonList = list.stream().map(m -> m.toJsonEdo()).collect(Collectors.toList());

    return edoJsonList;
  }

  public static <E, EJ, M extends ModelMapperBase<E, EJ, M>> List<E> toEdoList(final Set<M> list) {

    return toEdoList(list.stream().collect(Collectors.toList()));
  }

  public static <E, EJ, M extends ModelMapperBase<E, EJ, M>> List<EJ> toJsonEdoList(final Set<M> list) {

    return toJsonEdoList(list.stream().collect(Collectors.toList()));
  }

  public List<M> fromEdoList(final List<E> list) {

    return list.stream().map(m -> this.fromEdo(m)).collect(Collectors.toList());
  }

  public List<M> fromJsonEdoList(final List<EJ> list) {

    return list.stream().map(m -> this.fromJsonEdo(m)).collect(Collectors.toList());
  }

  public List<M> fromEdoList(final Set<E> list) {

    return fromEdoList(list.stream().collect(Collectors.toList()));
  }

  public List<M> fromJsonEdoList(final Set<EJ> list) {

    return fromJsonEdoList(list.stream().collect(Collectors.toList()));
  }

}
