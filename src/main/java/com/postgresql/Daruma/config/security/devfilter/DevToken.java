package com.postgresql.Daruma.config.security.devfilter;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

public class DevToken extends AbstractAuthenticationToken {

    private final String userId;

    public DevToken(Collection<? extends GrantedAuthority> authorities, String userId) {
        super(authorities);
        Assert.hasText(userId, "Invalid userId");
        this.userId = userId;
        super.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return "";
    }

    @Override
    public Object getPrincipal() {
        return this.userId;
    }

}
