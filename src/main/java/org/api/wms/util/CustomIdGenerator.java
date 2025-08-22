package org.api.wms.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.api.wms.model.enums.IdType;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomIdGenerator {

  public static String generateId(IdType idType, String code, String sequence) {

    // 원하는 형식으로 변환 (예: yyyy-MM-dd HH:mm:ss)
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    String formattedDateTime = LocalDateTime.now().format(formatter);
    if (idType.equals(IdType.WR)) {
      return idType.name() + "-" + formattedDateTime + "-" + sequence;
    }

    return idType.name() + "-" + code + "-" + formattedDateTime + "-" + sequence;
  }
}
