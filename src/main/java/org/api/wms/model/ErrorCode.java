package org.api.wms.model;

import org.springframework.http.HttpStatus;

public interface ErrorCode {

  String getCode();
  String getMessage();
  HttpStatus getHttpStatus();
}
