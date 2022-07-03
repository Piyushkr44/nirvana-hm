package com.nirvana.hm.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nirvana.hm.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	public User findByUserNameAndPassword(String userName, String password);
}
