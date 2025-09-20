package org.api.wms.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
public abstract class BaseTimeEntity {

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @Column(name = "created_date", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP(0)")
  private LocalDateTime createdDate;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @Column(name = "updated_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP(0)")
  private LocalDateTime updatedDate;

  @PrePersist
  public void onPersist() {
    this.createdDate = LocalDateTime.now();
    this.updatedDate = LocalDateTime.now();
  }

  @PreUpdate
  public void onUpdate() {
    this.updatedDate = LocalDateTime.now();
  }

}
