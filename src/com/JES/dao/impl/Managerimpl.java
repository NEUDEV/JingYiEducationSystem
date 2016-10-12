package com.JES.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.JES.dao.Managerdao;
import com.JES.model.Manager;

public class Managerimpl implements Managerdao{

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public String getMname(Manager manager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword(Manager manager) {
		// TODO Auto-generated method stub
		return null;
	}

}
