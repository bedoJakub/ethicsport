package com.bedodev.ethicsport.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bedodev.ethicsport.dto.User;
import com.bedodev.ethicsport.service.IUserService;

@Controller
@ManagedBean
@ViewScoped
public class UserController {

	private String filterUser;
	private List<User> users;
	
	@Autowired
	private IUserService userService;
	
	@PostConstruct
	public void init() {
//		 users = userService.filterUsers(null);
		users = userService.getUsers();
	}
			
	public List<User> getUsers(){
		return users;
	}

	public String getFilterUser() {
		return filterUser;
	}

	public void setFilterUser(String filterUser) {
		this.filterUser = filterUser;
	}
	
}
