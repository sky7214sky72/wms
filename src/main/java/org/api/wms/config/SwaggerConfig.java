package org.api.wms.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityScheme.Type;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

  private static final String SECURITY_SCHEME_NAME = "authorization";

  @Bean
  public GroupedOpenApi getMemberApi() {
    return GroupedOpenApi.builder()
        .group("member")
        .pathsToMatch("/api/member/**", "/api/login")
        .build();
  }

  @Bean
  public OpenAPI swaggerApi() {
    return new OpenAPI()
        .components(new Components()
            .addSecuritySchemes(SECURITY_SCHEME_NAME, new SecurityScheme()
                .name(SECURITY_SCHEME_NAME)
                .type(Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")
            ))
        .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))
        .info(getInfo());
  }

  private Info getInfo() {
    return new Info()
        .title("WMS API 문서")
        .description("WMS API 문서입니다.")
        .version("1.0.0");
  }
}
