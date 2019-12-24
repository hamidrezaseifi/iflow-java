package com.pth.iflow.gui.helper;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class GuiDateDeserializer extends StdDeserializer<LocalDate> {
  private static final long       serialVersionUID = 1L;
  private final DateTimeFormatter formatter        = DateTimeFormatter.ofPattern("dd.MM.yyyy");

  protected GuiDateDeserializer() {
    super(LocalDate.class);

  }

  @Override
  public LocalDate deserialize(final JsonParser jsonparser, final DeserializationContext ctxt)
      throws IOException, JsonProcessingException {
    final String date = jsonparser.getText();

    return LocalDate.parse(date, this.formatter);

  }
}
