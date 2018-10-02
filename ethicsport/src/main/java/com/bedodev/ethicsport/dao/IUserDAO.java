package com.bedodev.ethicsport.dao;

import java.util.List;

import com.bedodev.ethicsport.dto.User;

public interface IUserDAO {
	
	public List<User> fetchUsers();
	
	public void insert(User user) throws Exception;
	
	public void update(User user) throws Exception;
	
	public void delete(User user) throws Exception;
	
}
