package com.sia.main.data.dao.impl;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.sia.main.data.dao.PtkDAO;
import com.sia.main.data.sessionfactory.SessionFactoryManager;
import com.sia.main.domain.Ptk;

@Repository
public class PtkDAOImpl implements PtkDAO {

	private static final Logger logger = LoggerFactory.getLogger(PtkDAOImpl.class);
	
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
	public void insert(Ptk ptk) {
		final Session session = this.getSession();
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				session.save(ptk);
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
	public void update(Ptk ptk) {
		final Session session = this.getSession();
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				session.update(ptk);
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
	public void delete(Ptk ptk) {
		final Session session = this.getSession();
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				session.delete(ptk);
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
	public List<Ptk> getAll() {
		final Session session = this.getSession();
		List<Ptk> ptks = null;
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				ptks = session.createQuery("from Ptk").list();
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return ptks;
	}

	@Override
	public Ptk getById(UUID idPtk) {
		final Session session = this.getSession();
		Ptk ptk = null;
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				ptk = (Ptk)session.get(Ptk.class, idPtk);
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return ptk;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ptk> getByParam(String queryParam) {
		final Session session = this.getSession();
		List<Ptk> ptks = null;
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				ptks = session.createQuery("from Ptk " + queryParam).list();
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return ptks;
	}
	
}
