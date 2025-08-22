package org.api.wms.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.api.wms.model.BaseTimeEntity;
import org.api.wms.util.Identifiable;
import org.hibernate.annotations.ColumnDefault;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "warehouse", schema = "public")
public class Warehouse extends BaseTimeEntity implements Identifiable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String code;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
  @ColumnDefault("1")
  private Boolean isActive;
}
