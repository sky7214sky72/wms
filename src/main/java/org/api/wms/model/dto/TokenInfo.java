package org.api.wms.model.dto;

import lombok.Builder;

@Builder
public record TokenInfo(
    String grantType, String accessToken, String refreshToken) {

}
