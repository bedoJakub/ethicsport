package com.bedodev.ethicsport.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.apache.log4j.Logger;

import com.bedodev.ethicsport.dto.User;

@Named("userDAOStub")
public class UserDAOStub implements IUserDAO {
	
	final static Logger logger = Logger.getLogger(UserDAOStub.class);
	
	@Override
	public List<User> getUsers() {
		return createUsers();
	}

	private List<User> createUsers() {
		List<User> users = new ArrayList<User>();
		User user = new User();
		user.setFirstName("Lejla");
		user.setLastName("Lušiová");
		users.add(user);
		user = new User();
		user.setFirstName("Jakub");
		user.setLastName("Bedlek");
		users.add(user);
		user = new User();
		user.setFirstName("Radovan");
		user.setLastName("Jurík");
		users.add(user);
		user = new User();
		user.setFirstName("Romèa");
		user.setLastName("Záhumenská");
		users.add(user);
		return users;
	}

	@Override
	public void insert(User user) throws Exception {
		// TODO Auto-generated method stub
		logger.warn("Inserting to stub, this does NOT persist the item");
	}

	@Override
	public void update(User user) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User user) throws Exception {
		// TODO Auto-generated method stub

	}

}
