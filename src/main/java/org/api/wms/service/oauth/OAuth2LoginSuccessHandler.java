package org.api.wms.service.oauth;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.api.wms.jwt.JwtTokenProvider;
import org.api.wms.model.dto.TokenInfo;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OAuth2LoginSuccessHandler implements AuthenticationSuccessHandler {

  private final JwtTokenProvider jwtTokenProvider;
  private final ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {
    try {
      TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);
      // 응답 설정
      response.setContentType("application/json");
      response.setCharacterEncoding("utf-8");

      // JSON으로 변환하여 응답 바디에 쓰기
      String result = objectMapper.writeValueAsString(tokenInfo);
      response.getWriter().write(result);
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
