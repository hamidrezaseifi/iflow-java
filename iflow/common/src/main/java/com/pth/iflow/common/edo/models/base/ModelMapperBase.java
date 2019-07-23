package com.pth.iflow.common.edo.models.base;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public abstract class ModelMapperBase<E, M> {
  
  public ModelMapperBase() {
    
  }
  
  public boolean isNew() {
    return (getId() == null) || (getId() <= 0);
  }
  
  public abstract Integer getVersion();
  
  public abstract Long getId();
  
  public abstract void setVersion(final Integer version);
  
  public void increaseVersion() {
    this.setVersion(this.getVersion() == null ? 1 : this.getVersion() + 1);
  }
  
  public abstract String getModelId();
  
  public abstract void setModelId(String modelId);
  
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
  
  public static String generateNextModelId(String prevModelId) {
    String modelId = "";

    validateModelIdValidStringList();

    prevModelId = StringUtils.isEmpty(prevModelId) ? "" : prevModelId;

    if (prevModelId.isEmpty()) {
      modelId = StringUtils.repeat("0", ModelIdSize);

    }
    else {
      int lastIndex = 0;
      String lastString = "";
      final String lastStringValid = ModelIdValidStringList.get(ModelIdValidStringList.size() - 1);

      for (int i = prevModelId.length() - 1; i >= 0; i--) {
        if (prevModelId.substring(i, i + 1).equals(lastStringValid) == false) {
          lastIndex = i;
          lastString = prevModelId.substring(i, i + 1);
          break;
        }
      }

      final int lastStringIndex = ModelIdValidStringList.indexOf(lastString);

      modelId = prevModelId.substring(0, lastIndex) + ModelIdValidStringList.get(lastStringIndex + 1) + prevModelId.substring(lastIndex + 1);

    }
    return modelId;
  }
  
  private static void validateModelIdValidStringList() {
    if (ModelIdValidStringList.isEmpty()) {

      for (int i = 48; i < 58; i++) {
        ModelIdValidStringList.add(String.valueOf((char) i));
      }
      
      for (int i = 65; i < 91; i++) {
        ModelIdValidStringList.add(String.valueOf((char) i));
      }

      for (int i = 97; i < 123; i++) {
        ModelIdValidStringList.add(String.valueOf((char) i));
      }
      
    }
  }
  
  private static List<String> ModelIdValidStringList = new ArrayList<>();
  private static final int    ModelIdSize            = 15;

}
