package com.tsystems.ecrono.mapper;

import org.springframework.stereotype.Component;

import com.tsystems.ecrono.domain.UserEntity;
import com.tsystems.ecrono.dto.User;
import com.tsystems.ecrono.dto.create.CreateUser;

@Component
public class UserMapper {

    public UserEntity toUserEntity(CreateUser source) {
	UserEntity target = new UserEntity();
	target.setUserName(source.getUserName());
	target.setPassword(source.getPassword());
	target.setRole(source.getRole());
	return target;
    }

    public User toUser(UserEntity source) {
	User target = new User();
	target.setUserName(source.getUserName());
	target.setRole(source.getRole());
	return target;
    }
}
