package org.api.wms.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ItemUnit {
  EA("개"),       // Each
  BOX("박스"),
  PACK("팩"),
  KG("킬로그램"),
  G("그램"),
  L("리터"),
  ML("밀리리터");

  private final String displayName;
}
