package com.sia.main.data.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.sia.main.data.sessionfactory.SessionFactoryManager;

@Repository
public class BasicDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(BasicDAO.class);
	
	private SessionFactoryManager sessionFactoryManager;
	
	public SessionFactoryManager getSessionFactoryManager() {
		return sessionFactoryManager;
	}

	public void setSessionFactoryManager(SessionFactoryManager sessionFactoryManager) {
		this.sessionFactoryManager = sessionFactoryManager;
	}
	
	private Session getSession() {
		Session session = sessionFactoryManager.getSecuritySessionFactory().getCurrentSession();
		if(session == null || !session.isOpen()) {
			if(logger.isInfoEnabled()) logger.info("hibernate session is either null or closed. will open a new one instead");
			session = sessionFactoryManager.getSecuritySessionFactory().openSession();
		}
		return session;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> getObjects(String query) {
		final Session session = this.getSession();
		List<Object> queryResult = new ArrayList<Object>();
		try{
			session.beginTransaction();
			queryResult = session.createQuery(query).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session.isOpen())
				session.close();
		}
		return queryResult;
	}
	
}
