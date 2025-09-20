package org.api.wms.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.api.wms.model.BaseTimeEntity;
import org.api.wms.model.enums.RoleType;
import org.hibernate.annotations.ColumnDefault;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "member", schema = "public")
public class Member extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 50)
  private String type;

  @Column(nullable = false, length = 50)
  private String username;

  private String password;

  private LocalDateTime lastLoginDate;

  @Column(nullable = false, length = 10)
  @Enumerated(EnumType.STRING)
  private RoleType role;

  @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
  @ColumnDefault("1")
  private Boolean isActive;

  @Builder
  public Member(String username, String password, LocalDateTime lastLoginDate, String type) {
    this.username = username;
    this.password = password;
    this.lastLoginDate = lastLoginDate;
    this.role = RoleType.ROLE_USER;
    this.type = type;
    this.isActive = true;
  }

  public Member updateLastLoginDate(LocalDateTime lastLoginDate) {
    this.lastLoginDate = lastLoginDate;
    return this;
  }

  public Member updateIsActive(Boolean isActive) {
    this.isActive = isActive;
    return this;
  }
}
