package com.pth.iflow.gui.models.ui.ocr;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

public class OcrResultWord extends OcrResultItem {

  private boolean isStrong;
  private String text;
  private Set<OcrResultWord> values = new HashSet<>();
  private final OcrResultLine parent;

  public OcrResultWord(final OcrResultLine parent) {

    this.parent = parent;
  }

  public boolean isStrong() {

    return this.isStrong;
  }

  public void setStrong(final boolean isStrong) {

    this.isStrong = isStrong;
  }

  public String getText() {

    return this.text;
  }

  public void setText(final String text) {

    this.text = text;
  }

  public Set<OcrResultWord> getValues() {

    return this.values;
  }

  public void setValues(final Set<OcrResultWord> values) {

    this.values = values;
  }

  public void addValue(final OcrResultWord value) {

    this.values.add(value);
  }

  @Override
  public OcrResultWord clone() {

    final OcrResultWord word = new OcrResultWord(this.parent);
    word.setBox(this.box);
    word.setClassName(this.className);
    word.setId(this.id);
    word.setStrong(this.isStrong);
    word.setText(this.text);
    word.setTitle(this.title);

    return word;
  }

  public boolean IsValueTypeCorrect(final OcrResultValueType valueType) {

    if (StringUtils.isEmpty(this.text)) {
      return false;
    }

    if (valueType == OcrResultValueType.INTEGER) {
      return this.text.matches("-?(\\d+[.]){1,10}\\d+");

    }

    if (valueType == OcrResultValueType.FLOAT) {
      return this.text.matches("-?(\\d+[.]\\d+){1,10}[,]\\d+");

    }

    if (valueType == OcrResultValueType.DATE) {
      return this.text.matches("^[0-9]{2}.[0-9]{2}.[0-9]{4}");

    }

    return false;
  }
}
