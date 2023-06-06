package com.springcore.service;

import com.springcore.model.Users;
import org.apache.catalina.User;
import utils.LoginCredentialsDto;
import utils.userLogin;

public interface UserService {

	Users createUser(Users user);

	Users updateUserPassword(String password, Integer userId);

	Users getUserById(Integer userId);

    Users getUserByEmail(LoginCredentialsDto loginCredentialsDto);
	Users userlogin(userLogin user);
}
