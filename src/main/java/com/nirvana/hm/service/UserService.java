package com.nirvana.hm.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nirvana.hm.dao.UserRepository;
import com.nirvana.hm.entity.User;


@Service
@Transactional
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepo) {
		this.userRepository = userRepo;
	}
	
	public User findByUsernameAndPassword(String userName, String password) {
		return userRepository.findByUserNameAndPassword(userName, password);
	}
}
