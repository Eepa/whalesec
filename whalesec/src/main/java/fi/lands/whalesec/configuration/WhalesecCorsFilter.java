package fi.lands.whalesec.configuration;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

public class WhalesecCorsFilter extends OncePerRequestFilter {

    private static final List<String> CORS_PROTECTED_PATHS = Collections.singletonList("/whales/sounds");

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        String address = request.getRequestURI();

        String method = request.getMethod();

        if (CORS_PROTECTED_PATHS.contains(address) && method.equals("POST")) {

            response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
            response.setHeader("Access-Control-Allow-Headers", "content-type");
            response.setHeader("Access-Control-Max-Age", "3600");

            filterChain.doFilter(request, response);
        } else {
            filterChain.doFilter(request, response);
        }
    }

}
