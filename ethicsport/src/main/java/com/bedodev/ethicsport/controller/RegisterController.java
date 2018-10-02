package com.bedodev.ethicsport.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bedodev.ethicsport.dto.User;
import com.bedodev.ethicsport.service.IUserService;

@Controller
@ManagedBean
@RequestScoped
public class RegisterController {
	
	final static Logger logger = Logger.getLogger(RegisterController.class);
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private User user;
	
	public void execute() {
		logger.info("Executing register user");
		FacesContext currentInstance = FacesContext.getCurrentInstance();
		FacesMessage fm = null;
		try {
			userService.save(user);
			logger.info("Registering user successful " + user.getLogin());
			fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Pridaný", "Používate¾ bol pridaný.");			
			user = null;
		} catch (Exception e) {
			logger.error("Error while registering new user " + e.getMessage());
			
			e.printStackTrace();
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
