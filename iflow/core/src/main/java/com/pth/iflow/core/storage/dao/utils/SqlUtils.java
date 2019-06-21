package com.pth.iflow.core.storage.dao.utils;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class SqlUtils {
  
  public static LocalDateTime getDatetimeFromTimestamp(final Timestamp timestamp) {
    
    if (timestamp != null) {
      return timestamp.toLocalDateTime();
    }
    return null;
  }
  
  public static LocalDate getDateFromTimestamp(final Timestamp timestamp) {
    
    if (timestamp != null) {
      return timestamp.toLocalDateTime().toLocalDate();
    }
    return null;
  }
  
  public static Timestamp getTimestampFromDatetime(final LocalDateTime date) {
    
    if (date != null) {
      return Timestamp.valueOf(date);
    }
    return null;
  }
  
  public static Timestamp getTimestampFromDate(final LocalDate date) {
    
    if (date != null) {
      return Timestamp.valueOf(date.atStartOfDay());
    }
    return null;
  }

}
