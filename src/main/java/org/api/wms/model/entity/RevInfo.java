package org.api.wms.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.api.wms.util.Identifiable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "revinfo", schema = "public")
public class RevInfo implements Identifiable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long rev;

  // epoch millis (BIGINT)
  private Long revstmp;

  // FK가 명시되어 있지 않으므로 단순 값으로 매핑
  private Long auditorId;

  @Override
  public Long getId() {
    return rev;
  }
}
