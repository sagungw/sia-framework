package com.sia.main.data.repositories.impl;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.sia.main.data.repositories.PeranRepository;
import com.sia.main.data.sessionfactory.SessionFactoryManager;
import com.sia.main.domain.Modul;
import com.sia.main.domain.Peran;

@Repository
public class PeranRepositoryImpl implements PeranRepository {
	
	private SessionFactoryManager sessionFactoryManager;
	
	public SessionFactoryManager getSessionFactoryManager() {
		return sessionFactoryManager;
	}

	public void setSessionFactoryManager(SessionFactoryManager sessionFactoryManager) {
		this.sessionFactoryManager = sessionFactoryManager;
	}

	private Session getSession() {
		Session session = sessionFactoryManager.getSecuritySessionFactory().getCurrentSession();
		System.out.println("retrieving current hibernate session");
		if(session == null || !session.isOpen()) {
			System.out.println("hibernate session is either null or closed. will open a new one instead");
			session = sessionFactoryManager.getSecuritySessionFactory().openSession();
		}
		return session;
	}
	
	@Override
	public void insertInto(Peran peran) {
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

	@Override
	public List<Peran> getPeranWithParam(String param) {
		final Session session = this.getSession();
		List<Peran> daftarPeran = null;
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				daftarPeran = session.createQuery("from Param " + param).list();
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
