package com.sia.main.data.dao.impl;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.sia.main.data.dao.TipePenggunaDAO;
import com.sia.main.data.sessionfactory.SessionFactoryManager;
import com.sia.main.domain.TipePengguna;

@Repository
public class TipePenggunaDAOImpl implements TipePenggunaDAO {

	private static final Logger logger = LoggerFactory.getLogger(TipePenggunaDAOImpl.class);
	
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
	public void insert(TipePengguna tipePengguna) {
		final Session session = this.getSession();
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				session.save(tipePengguna);
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
	public void update(TipePengguna tipePengguna) {
		final Session session = this.getSession();
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				session.update(tipePengguna);
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
	public void delete(TipePengguna tipePengguna) {
		final Session session = this.getSession();
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				session.delete(tipePengguna);
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
	public List<TipePengguna> getAll() {
		final Session session = this.getSession();
		List<TipePengguna> tipePenggunaes = null;
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				tipePenggunaes = session.createQuery("from TipePengguna").list();
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return tipePenggunaes;
	}

	@Override
	public TipePengguna getById(UUID idTipePengguna) {
		final Session session = this.getSession();
		TipePengguna tipePengguna = null;
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				tipePengguna = (TipePengguna)session.get(TipePengguna.class, idTipePengguna);
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return tipePengguna;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipePengguna> getByParam(String queryParam) {
		final Session session = this.getSession();
		List<TipePengguna> daftarTipePengguna = null;
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				daftarTipePengguna = session.createQuery("from TipePengguna " + queryParam).list();
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return daftarTipePengguna;
	}
	
}
