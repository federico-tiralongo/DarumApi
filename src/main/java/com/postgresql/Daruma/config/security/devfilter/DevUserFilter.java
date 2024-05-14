package com.postgresql.Daruma.config.security.devfilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DevUserFilter extends OncePerRequestFilter {
    private final String USER_HEADER = "X-USER-ID";
    private final String ROLES_HEADER = "X-ROLES";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String userId = request.getHeader(USER_HEADER);
        String roles = request.getHeader(ROLES_HEADER);

        boolean userIdAdded = StringUtils.hasText(userId);
        boolean rolesAdded = StringUtils.hasText(roles);

        // If one exists, the other must exist too
        if (!(userIdAdded && rolesAdded)) {
            throw new BadRequestException(String.format("%s and %s must exist together", USER_HEADER, ROLES_HEADER));
        } else {

            Set<GrantedAuthority> authorities = Arrays.asList(roles.split(","))
                    .stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet());

            DevToken devToken = new DevToken(authorities, userId);

            SecurityContextHolder.getContext().setAuthentication(devToken);

            filterChain.doFilter(request, response);
        }
    }

    protected boolean shouldNotFilter(HttpServletRequest request) {
        return HttpMethod.OPTIONS.matches(request.getMethod());
    }

}
