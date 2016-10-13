package com.JES.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.JES.model.Manager;

public class Managerimpl{

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void save(Manager manager) {
		try {
			getCurrentSession().save(manager);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void delete(Manager manager) {
		try {
			getCurrentSession().delete(manager);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public List findByMname(Manager manager) {
		try {
			List results = getCurrentSession()
					.createCriteria("com.JES.model.Manager")
					.add(Example.create(manager)).list();
			return results;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public String getMname(Manager manager) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query=session.createQuery("from Manager where mname=='"+manager.getMname() + "'");
		List transferInfo = query.list();
		
		if (transferInfo.size() == 0) {
			return "";
		}
		session.close();
		return null;
	}

	public String getPassword(Manager manager) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query=session.createQuery("from Manager where mname=='"+manager.getMname() + ",");
		List transferInfo = query.list();
		session.close();
		return null;
	}

}
