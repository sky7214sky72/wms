package org.api.wms.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.api.wms.model.ErrorCode;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum CommonErrorCode implements ErrorCode {
  SUCCESS("SUCCESS", "요청 성공", HttpStatus.OK),
  BAD_REQUEST("BAD_REQUEST", "잘못된 요청입니다.", HttpStatus.BAD_REQUEST),
  UNAUTHORIZED("UNAUTHORIZED", "인증이 필요합니다.", HttpStatus.UNAUTHORIZED),
  FORBIDDEN("FORBIDDEN", "권한이 없습니다.", HttpStatus.FORBIDDEN),
  NOT_FOUND("NOT_FOUND", "리소스를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
  INTERNAL_ERROR("INTERNAL_ERROR", "서버 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);

  private final String code;
  private final String message;
  private final HttpStatus status;


  @Override
  public HttpStatus getHttpStatus() {
    return this.status;
  }
}
