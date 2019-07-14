package com.pth.iflow.common.edo.models.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateEdoAdapter extends XmlAdapter<String, Date> {

  private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

  @Override
  public Date unmarshal(final String v) throws Exception {
    return this.dateFormat.parse(v);
  }

  @Override
  public String marshal(final Date v) throws Exception {
    return this.dateFormat.format(v);
  }

}
