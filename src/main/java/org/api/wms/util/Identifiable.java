package org.api.wms.util;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface Identifiable {
  Long getId();

  static <T extends Identifiable> List<Long> extractIds(List<T> list) {
    return list.stream()
        .map(Identifiable::getId)
        .toList();
  }

  static <T extends Identifiable> Map<Long, T> toMap(List<T> list) {
    return list.stream()
        .collect(Collectors.toMap(Identifiable::getId, Function.identity()));
  }
}
