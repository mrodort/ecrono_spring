package com.tsystems.ecrono.configuration;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.tsystems.ecrono.configuration.component.MyUserDetalis;
import com.tsystems.ecrono.domain.UserEntity;
import com.tsystems.ecrono.repository.CreateUserRepository;

public class MyUserDetailService implements UserDetailsService {

    private final CreateUserRepository createUserRepostitory;

    public MyUserDetailService(CreateUserRepository createUserRepostitory) {
	super();
	this.createUserRepostitory = createUserRepostitory;
    }

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {

	UserEntity userInBd = createUserRepostitory.findByUserName(user);

	if (userInBd != null) {
	    return new MyUserDetalis(userInBd);
	} else {
	    throw new UsernameNotFoundException("Usuario no encontrado");
	}
    }

}
