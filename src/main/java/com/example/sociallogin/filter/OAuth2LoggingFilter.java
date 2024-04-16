package com.example.sociallogin.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.Instant;

@Component
public class OAuth2LoggingFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(OAuth2LoggingFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            long startTime = Instant.now().toEpochMilli();
            request.setAttribute("startTime", startTime);
            LOGGER.info("(start time): " + startTime);
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            String query = httpRequest.getQueryString();
            if (query != null) {
                LOGGER.info("Incoming OAuth2 redirect with query: {}", query);
            }
        }
        chain.doFilter(request, response);
    }
}