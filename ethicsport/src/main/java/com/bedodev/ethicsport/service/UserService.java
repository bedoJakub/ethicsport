package com.bedodev.ethicsport.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.bedodev.ethicsport.dao.IUserDAO;
import com.bedodev.ethicsport.dto.User;

@Named
public class UserService implements IUserService {

	@Inject
	private IUserDAO userDAO;
	private List<User> users;
	
	@Override
	public List<User> filterUsers(String filter) {
		if(users == null) {
			users = getUserDAO().fetchUsers();
		}
		List<User> filterd = new ArrayList<User>();
		if(filter == null || filter.length() == 0) {
			filterd = users;
		}else {
			for (User user : users) {
				if(user.getFirstName().toLowerCase().contains(filter.toLowerCase())) {
					filterd.add(user);
				}
			}
		}
		
		return filterd;
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public void save(User paUser) throws Exception {
		if(paUser == null || paUser.getLogin() == null || paUser.getLogin().isEmpty()) {
			throw new Exception("Login povinný");
		}
		if(users == null) {
			users = getUserDAO().fetchUsers();
		}
		users.add(paUser);
				
		userDAO.insert(paUser);
		
	}

}
