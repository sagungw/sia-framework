package com.sia.main.data.repositories.impl;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.sia.main.data.repositories.PenggunaRepository;
import com.sia.main.data.sessionfactory.SessionFactoryManager;
import com.sia.main.domain.Pengguna;

@Repository
public class PenggunaRepositoryImpl implements PenggunaRepository {

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
	public void insertInto(Pengguna pengguna) {
		final Session session = this.getSession();
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				session.save(pengguna);
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
	public void update(Pengguna pengguna) {
		final Session session = this.getSession();
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				session.update(pengguna);
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
	public void delete(Pengguna pengguna) {
		final Session session = this.getSession();
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				session.delete(pengguna);
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
	public List<Pengguna> getAll() {
		final Session session = this.getSession();
		List<Pengguna> penggunaList = null;
		try{
			session.beginTransaction();
			try {
				penggunaList = session.createQuery("from Pengguna").list();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return penggunaList;
	}

	@Override
	public Pengguna getById(UUID idPengguna) {
		final Session session = this.getSession();
		Pengguna pengguna = null;
		try{
			session.beginTransaction();
			try {
				pengguna = (Pengguna)session.get(Pengguna.class, idPengguna);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return pengguna;
	}

	@Override
	public List<Pengguna> getByParam(String queryParam) {
		final Session session = this.getSession();
		List<Pengguna> penggunaList = null;
		try{
			session.beginTransaction();
			try {
				penggunaList = session.createQuery("from Pengguna " + queryParam).list();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return penggunaList;
	}

}
