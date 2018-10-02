package com.bedodev.ethicsport.dao;

import java.util.List;

import javax.inject.Named;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bedodev.ethicsport.dto.User;

@Repository
@Named
public class UserDAO implements IUserDAO {
	
	final static Logger logger = Logger.getLogger(UserDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<User> getUsers() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query  ... sort by last name
		Query<User> theQuery = currentSession.createQuery("from User order by lastName", User.class);
		
		return theQuery.getResultList();
		
	}
	
	@Override
	public void insert(User user) throws Exception {

		logger.warn("Inserting user to database");
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
