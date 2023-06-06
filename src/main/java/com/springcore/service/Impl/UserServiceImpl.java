package com.springcore.service.Impl;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;

import com.springcore.model.Users;
import com.springcore.repository.UserRepository;
import com.springcore.service.UserService;
import org.springframework.stereotype.Service;
import utils.LoginCredentialsDto;
import utils.userLogin;

@Service
public class UserServiceImpl implements UserService {


	@Autowired
	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	// create User
	@Override
	public Users createUser(Users user) {
		return userRepository.save(user);
	}

	// update user
	@Override
	public Users updateUserPassword(String password, Integer userId) {
		Users eUser = this.userRepository.findById(userId).orElseThrow();
		eUser.setPassword(password);
		Users updatedUser = this.userRepository.save(eUser);
		return updatedUser;

	}
	@Override
	public Users getUserById(Integer userId){
		Users users = this.userRepository.findById(userId).orElseThrow();
		return users;
	}

	@Override
	public Users getUserByEmail(LoginCredentialsDto loginCredentialsDto) {
		Users users = this.userRepository.findUsersByEmailAndPassword(loginCredentialsDto.getEmail(), loginCredentialsDto.getPassword());

		return users;
	}

	@Override
	public Users userlogin(userLogin user) {
		String email=user.getEmail();
		String password=user.getPassword();
		Users user1=this.userRepository.findUsersByEmailAndPassword(email,password);
		if(user!=null){
			return user1;
		}
		return null;

	}

}
