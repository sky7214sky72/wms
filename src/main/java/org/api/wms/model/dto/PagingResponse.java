package org.api.wms.model.dto;

import java.util.List;
import org.springframework.data.domain.Page;

public record PagingResponse<T>(
    List<T> content,
    int page,
    int size,
    long totalElements,
    int totalPages
) {

  public static <T> PagingResponse<T> of(Page<T> page) {
    return new PagingResponse<>(
        page.getContent(),
        page.getNumber(),
        page.getSize(),
        page.getTotalElements(),
        page.getTotalPages()
    );
  }
}
