package com.bedodev.ethicsport.service;

import java.util.List;
import com.bedodev.ethicsport.dto.User;

/**
 * IUserService includes all business related functions for a User
 * @author bedodev
 *
 */
public interface IUserService {
	
	/**
	 * Return a collection of filterd User objects
	 * @param filter
	 * @return list of users
	 */
	public List<User> filterUsers(String filter);

	/**
	 * Save the user, probably registration
	 * @param user
	 * @throws Exception
	 */
	public void save(User user) throws Exception;
	
}
