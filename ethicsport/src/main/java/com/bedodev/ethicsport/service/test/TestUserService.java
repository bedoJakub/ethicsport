package com.bedodev.ethicsport.service.test;

import org.junit.Test;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import com.bedodev.ethicsport.dao.IUserDAO;
import com.bedodev.ethicsport.dto.User;
import com.bedodev.ethicsport.service.UserService;

import junit.framework.TestCase;

public class TestUserService extends TestCase {
	
	private UserService userService;
	private List<User> filterUsers;

	@Test
	public void testFilterUsers() {
		givenThatUserServiceIsPopulatedWithUserDAO();
		whenFilterWithJ();
		thenVerifyTwoResult();
	}

	private void thenVerifyTwoResult() {
		assertEquals(2, filterUsers.size());
	}

	private void whenFilterWithJ() {
		filterUsers = userService.filterUsers("j");		
	}

	private void givenThatUserServiceIsPopulatedWithUserDAO() {
		userService = new UserService();
		IUserDAO userDAO = mock(IUserDAO.class);
		List<User> userList = createUsers();
		when(userDAO.getUsers()).thenReturn(userList);
		userService.setUserDAO(userDAO);
	};
	
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
}
