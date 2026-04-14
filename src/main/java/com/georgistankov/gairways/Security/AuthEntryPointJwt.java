package com.georgistankov.gairways.Security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import java.io.IOException;
@Component
public class AuthEntryPointJwt  implements AuthenticationEntryPoint {
    @Override
    public void commence(
            @NotNull HttpServletRequest request,
            HttpServletResponse response,
            @NotNull AuthenticationException authException
    ) throws IOException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized");
    }
}