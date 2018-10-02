package com.bedodev.ethicsport.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bedodev.ethicsport.dao.IUserDAO;
import com.bedodev.ethicsport.dto.User;


@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDAO userDAO;
	
	private List<User> users;
	
	@Override
	public List<User> filterUsers(String filter) {
		if(users == null) {
			users = getUserDAO().getUsers();
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
	@Transactional
	public void save(User paUser) throws Exception {
		if(paUser == null || paUser.getLogin() == null || paUser.getLogin().isEmpty()) {
			throw new Exception("Login povinný");
		}
		if(users == null) {
			users = getUserDAO().getUsers();
		}
		users.add(paUser);
				
		userDAO.insert(paUser);
		
	}

	@Override
	@Transactional
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

}
