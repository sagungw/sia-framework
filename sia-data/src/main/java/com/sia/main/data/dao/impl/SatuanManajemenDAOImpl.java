package com.sia.main.data.dao.impl;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.sia.main.data.dao.SatuanManajemenDAO;
import com.sia.main.data.sessionfactory.SessionFactoryManager;
import com.sia.main.domain.SatMan;

@Repository
public class SatuanManajemenDAOImpl implements SatuanManajemenDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(SatuanManajemenDAOImpl.class);
	
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
	public void insert(SatMan satuanManajemen) {
		final Session session = this.getSession();
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				session.save(satuanManajemen);
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
	public void update(SatMan satuanManajemen) {
		final Session session = this.getSession();
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				session.update(satuanManajemen);
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
	public void delete(SatMan satuanManajemen) {
		final Session session = this.getSession();
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				session.delete(satuanManajemen);
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
	public List<SatMan> getAll() {
		final Session session = this.getSession();
		List<SatMan> satManList = null;
		try{
			session.beginTransaction();
			try {
				satManList = session.createQuery("from SatMan").list();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return satManList;
	}

	@Override
	public SatMan getById(UUID idSatuanManajemen) {
		final Session session = this.getSession();
		SatMan satMan = null;
		try{
			session.beginTransaction();
			try {
				satMan = (SatMan)session.get(SatMan.class, idSatuanManajemen);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return satMan;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SatMan> getByParam(String queryParam) {
		final Session session = this.getSession();
		List<SatMan> satManList = null;
		try{
			session.beginTransaction();
			try {
				satManList = session.createQuery("from SatMan " + queryParam).list();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return satManList;
	}

}
