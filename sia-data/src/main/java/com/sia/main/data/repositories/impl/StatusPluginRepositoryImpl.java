package com.sia.main.data.repositories.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.sia.main.data.repositories.StatusPluginRepository;
import com.sia.main.data.sessionfactory.SessionFactoryManager;
import com.sia.main.domain.StatusPlugin;

@Repository
public class StatusPluginRepositoryImpl implements StatusPluginRepository{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

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
			if(this.logger.isInfoEnabled()) {
				this.logger.info("hibernate session is either null or closed. will open a new one instead");
			}
			session = sessionFactoryManager.getSecuritySessionFactory().openSession();
		}
		return session;
	}
	
	@Override
	public StatusPlugin insertInto(StatusPlugin statusPlugin) {
		final Session session = this.getSession();
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				session.save(statusPlugin);
				transaction.commit();
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return statusPlugin;
	}

	@Override
	public StatusPlugin update(StatusPlugin statusPlugin) {
		final Session session = this.getSession();
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				session.update(statusPlugin);
				transaction.commit();
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return statusPlugin;
	}

	@Override
	public StatusPlugin delete(StatusPlugin statusPlugin) {
		final Session session = this.getSession();
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				session.delete(statusPlugin);
				transaction.commit();
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return statusPlugin;
	}

	@Override
	public StatusPlugin getById(UUID idStatus) {
		final Session session = this.getSession();
		StatusPlugin statusPlugin = null;
		try{
			session.beginTransaction();
			try {
				statusPlugin = (StatusPlugin)session.get(StatusPlugin.class, idStatus);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return statusPlugin;
	}

	@Override
	public List<StatusPlugin> getByParam(String queryParam) {
		final Session session = this.getSession();
		List<StatusPlugin> result = new ArrayList<StatusPlugin>();
		try{
			session.beginTransaction();
			try {
				result = session.createQuery("from StatusPlugin " + queryParam).list();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return result;
	}

	@Override
	public List<StatusPlugin> getAll() {
		final Session session = this.getSession();
		List<StatusPlugin> result = new ArrayList<StatusPlugin>();
		try{
			session.beginTransaction();
			try {
				result = session.createQuery("from StatusPlugin").list();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return result;
	}

}
