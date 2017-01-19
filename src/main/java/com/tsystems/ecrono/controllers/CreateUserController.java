package com.tsystems.ecrono.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tsystems.ecrono.dto.User;
import com.tsystems.ecrono.dto.create.CreateUser;
import com.tsystems.ecrono.usercase.CreateUserUserCase;

@RestController
@RequestMapping(value = "users")
public class CreateUserController {

    private CreateUserUserCase createUserUserCase;

    @Autowired
    public CreateUserController(CreateUserUserCase createUserUserCase) {
	super();
	this.createUserUserCase = createUserUserCase;
    }

    @RequestMapping(value = "{userName}", method = RequestMethod.POST)
    public ResponseEntity<User> createNewUser(@RequestBody @Valid CreateUser createUser) {
	return new ResponseEntity<User>(createUserUserCase.createNewUser(createUser), HttpStatus.CREATED);
    }

}
