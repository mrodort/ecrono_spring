package com.tsystems.ecrono.configuration.component;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.tsystems.ecrono.domain.UserEntity;

public class MyUserDetalis implements UserDetails {

    private static final long serialVersionUID = 1L;
    private final UserEntity user;

    public MyUserDetalis(UserEntity user) {
	super();
	this.user = user;
    }

    @Override // Esto son los roles de usuario
    public Collection<? extends GrantedAuthority> getAuthorities() {
	List<GrantedAuthority> authorities = new LinkedList<>();
	for (String role : user.getRole()) {
	    authorities.add(new SimpleGrantedAuthority(role));
	}
	return authorities;
    }

    @Override
    public String getPassword() {
	return user.getPassword();
    }

    @Override
    public String getUsername() {
	return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
	return true;
    }

    @Override
    public boolean isAccountNonLocked() {
	return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
	return true;
    }

    @Override
    public boolean isEnabled() {
	return true;
    }
}
