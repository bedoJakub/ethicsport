package com.bedodev.ethicsport.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bedodev.ethicsport.dto.User;
import com.bedodev.ethicsport.service.IUserService;

@Controller
@RequestMapping("/user")
@Named
@ManagedBean
@SessionScoped
public class UserController {

	private String filterUser;
	private List<User> users;
	
	@Inject
	private IUserService userService;
	
	@PostConstruct
	public void init() {
		 users = userService.filterUsers(null);
	}
	
	@RequestMapping("/list")
	public String listUsers(Model paModel){
		return "list-users";
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
