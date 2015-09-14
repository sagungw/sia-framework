package com.sia.main.data.dao.impl;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.sia.main.data.dao.ModulDAO;
import com.sia.main.data.sessionfactory.SessionFactoryManager;
import com.sia.main.domain.Modul;

@Repository
public class ModulDAOImpl implements ModulDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ModulDAOImpl.class);
	
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
	
	@Override
	public void insert(Modul modul) {
		final Session session = this.getSession();
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				session.save(modul);
				transaction.commit();
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
	}

	@Override
	public void update(Modul modul) {
		final Session session = this.getSession();
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				session.update(modul);
				transaction.commit();
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
	}

	@Override
	public void delete(Modul modul) {
		final Session session = this.getSession();
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				session.delete(modul);
				transaction.commit();
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Modul> getAll() {
		final Session session = this.getSession();
		List<Modul> modules = null;
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				modules = session.createQuery("from Modul").list();
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return modules;
	}

	@Override
	public Modul getById(UUID idModul) {
		final Session session = this.getSession();
		Modul modul = null;
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				modul = (Modul)session.get(Modul.class, idModul);
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return modul;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Modul> getByParam(String queryParam) {
		final Session session = this.getSession();
		List<Modul> modules = null;
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				modules = session.createQuery("from Modul " + queryParam).list();
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return modules;
	}

}
