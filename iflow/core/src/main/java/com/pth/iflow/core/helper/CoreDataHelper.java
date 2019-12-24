package com.pth.iflow.core.helper;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CoreDataHelper {

  public static LocalDateTime toLocalDateTime(final Date date) {
    return new Timestamp(date.getTime()).toLocalDateTime();
  }

  public static Date fromLocalDateTime(final LocalDateTime datetime) {
    return new Date(java.sql.Timestamp.valueOf(datetime).getTime());
  }

  public static LocalDate toLocalDate(final Date date) {
    return date.toLocalDate();
  }

  public static Date fromLocalDate(final LocalDate date) {
    return Date.valueOf(date);
  }
}
