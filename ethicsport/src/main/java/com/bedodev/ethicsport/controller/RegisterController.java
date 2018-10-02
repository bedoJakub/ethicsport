package com.bedodev.ethicsport.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bedodev.ethicsport.dto.User;
import com.bedodev.ethicsport.service.IUserService;

@Controller
@Named
@ManagedBean
@RequestScoped
public class RegisterController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private User user;
	
	public void execute() {
//		String output = null;
		FacesContext currentInstance = FacesContext.getCurrentInstance();
		FacesMessage fm = null;
		try {
			userService.save(user);			
			 fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Pridaný", "Používate¾ bol pridaný.");			
//			output = "succesful";
			user = null;
		} catch (Exception e) {
			e.printStackTrace();
//			output="fail";
			fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nepridaný", "Používate¾ nebol pridaný.");
		}
		currentInstance.addMessage(null, fm);		
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
