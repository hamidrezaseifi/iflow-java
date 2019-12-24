package com.pth.iflow.gui.helper;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class GuiDateSerializer extends StdSerializer<LocalDate> {

  private static final long serialVersionUID = 1L;

  protected GuiDateSerializer() {
    super(LocalDate.class);
  }

  private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

  @Override
  public void serialize(final LocalDate value, final JsonGenerator gen, final SerializerProvider provider) throws IOException {
    final String strDate = value.format(this.formatter);
    gen.writeString(strDate);
  }

}
