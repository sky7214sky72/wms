package org.api.wms.model.dto;


import org.api.wms.model.ErrorCode;
import org.api.wms.model.enums.CommonErrorCode;

public record ApiResponse<T>(String code, String message, T data) {

  public static <T> ApiResponse<T> success(T data) {
    return new ApiResponse<>(CommonErrorCode.SUCCESS.getCode(), CommonErrorCode.SUCCESS.getMessage(), data);
  }

  public static <T> ApiResponse<T> success(String message, T data) {
    return new ApiResponse<>(CommonErrorCode.SUCCESS.getCode(), message, data);
  }

  public static <T> ApiResponse<T> error(ErrorCode errorCode) {
    return new ApiResponse<>(errorCode.getCode(), errorCode.getMessage(), null);
  }

  public static <T> ApiResponse<T> error(ErrorCode errorCode, String customMessage) {
    return new ApiResponse<>(errorCode.getCode(), customMessage, null);
  }
}
