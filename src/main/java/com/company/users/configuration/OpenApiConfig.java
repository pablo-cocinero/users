package com.company.users.configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(name = "api", bearerFormat = "JWT", scheme = "bearer", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class OpenApiConfig {}
