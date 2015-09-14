package com.sia.main.data.dao.impl;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.sia.main.data.dao.PeranDAO;
import com.sia.main.data.sessionfactory.SessionFactoryManager;
import com.sia.main.domain.Peran;

@Repository
public class PeranDAOImpl implements PeranDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(PeranDAOImpl.class);
	
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
	public void insert(Peran peran) {
		final Session session = this.getSession();
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				session.save(peran);
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
	public void update(Peran peran) {
		final Session session = this.getSession();
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				session.update(peran);
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
	public void delete(Peran peran) {
		final Session session = this.getSession();
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				session.delete(peran);
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
	public List<Peran> getAll() {
		final Session session = this.getSession();
		List<Peran> daftarPeran = null;
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				daftarPeran = session.createQuery("from Peran").list();
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return daftarPeran;
	}

	
	@Override
	public Peran getById(UUID idPeran) {
		final Session session = this.getSession();
		Peran peran = null;
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				peran = (Peran)session.get(Peran.class, idPeran);
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return peran;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Peran> getByParam(String queryParam) {
		final Session session = this.getSession();
		List<Peran> daftarPeran = null;
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				daftarPeran = session.createQuery("from Param " + queryParam).list();
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return daftarPeran;
	}
	
}
