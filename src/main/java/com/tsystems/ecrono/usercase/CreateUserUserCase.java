package com.tsystems.ecrono.usercase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsystems.ecrono.domain.UserEntity;
import com.tsystems.ecrono.dto.User;
import com.tsystems.ecrono.dto.create.CreateUser;
import com.tsystems.ecrono.mapper.UserMapper;
import com.tsystems.ecrono.repository.CreateUserRepository;

@Service
public class CreateUserUserCase {

    private final CreateUserRepository createUserRepository;
    private final UserMapper mapper;

    @Autowired
    public CreateUserUserCase(CreateUserRepository createUserRepository, UserMapper mapper) {
	super();
	this.createUserRepository = createUserRepository;
	this.mapper = mapper;
    }

    public User createNewUser(CreateUser createUser) {

	UserEntity userToCreate = mapper.toUserEntity(createUser);
	createUserRepository.save(userToCreate);
	User user = mapper.toUser(userToCreate);
	return user;
    }

}
