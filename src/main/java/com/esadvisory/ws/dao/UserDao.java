package com.esadvisory.ws.dao;

import java.util.List;

import com.esadvisory.ws.domain.User;

public interface UserDao {
	
		void create(User user);

	   void update(User user);

	   void delete(User user);

	   List<String> getAllUserNames();

	   List<User> findAll();

	   User findByPrimaryKey(String employeeID);

}
