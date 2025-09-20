package org.api.wms.config;

import lombok.RequiredArgsConstructor;
import org.api.wms.service.oauth.CustomOAuth2UserService;
import org.api.wms.service.oauth.OAuth2LoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

  private final String[] allowedUrls = {"/", "/swagger-ui/**", "/v3/**", "/login/**",
      "/actuator/prometheus", "/baseball/**", "/static/**",
      "/logs/**", "/swagger-ui/index.html", "/swagger-resources/**", "/resources/**",
      "/resources/**", "/static/**", "/public/**", "/webui/**", "/h2-console/**",
      "/configuration/**", "/*.html", "/favicon.ico"};
  private final CustomOAuth2UserService customOAuth2UserService;
  private final OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        // 기본 설정
        .csrf(AbstractHttpConfigurer::disable)
        .formLogin(AbstractHttpConfigurer::disable)
        .httpBasic(AbstractHttpConfigurer::disable)
        .sessionManagement(
            sessions -> sessions.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

        // 권한 설정
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers(allowedUrls).permitAll()
            .anyRequest().authenticated())
        // OAuth2 로그인 설정
        .oauth2Login(oauth2 -> oauth2
            .successHandler(oAuth2LoginSuccessHandler)
            .userInfoEndpoint(userInfo -> userInfo
                .userService(customOAuth2UserService)));
    return http.build();
  }
}
