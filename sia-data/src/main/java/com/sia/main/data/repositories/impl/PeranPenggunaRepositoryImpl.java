package com.sia.main.data.repositories.impl;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import com.sia.main.data.repositories.PeranPenggunaRepository;
import com.sia.main.data.sessionfactory.SessionFactoryManager;
import com.sia.main.domain.Peran;
import com.sia.main.domain.PeranPengguna;

public class PeranPenggunaRepositoryImpl implements PeranPenggunaRepository {

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
	public void insertInto(PeranPengguna peranPengguna) {
		final Session session = this.getSession();
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				session.save(peranPengguna);
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
	public void update(PeranPengguna peranPengguna) {
		final Session session = this.getSession();
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				session.update(peranPengguna);
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
	public void delete(PeranPengguna peranPengguna) {
		final Session session = this.getSession();
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				session.delete(peranPengguna);
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
	public List<PeranPengguna> getAll() {
		final Session session = this.getSession();
		List<PeranPengguna> daftarPeranPengguna = null;
		try{
			session.beginTransaction();
			try {
				daftarPeranPengguna = session.createQuery("from PeranPengguna").list();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return daftarPeranPengguna;
	}

	@Override
	public PeranPengguna getById(UUID idPeranPengguna) {
		final Session session = this.getSession();
		PeranPengguna peranPengguna = null;
		try{
			session.beginTransaction();
			try {
				peranPengguna = (PeranPengguna)session.get(PeranPengguna.class, idPeranPengguna);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return peranPengguna;
	}

	@Transactional
	@Override
	public List<PeranPengguna> getByParam(String queryParam) {
		final Session session = this.getSession();
		List<PeranPengguna> daftarPeranPengguna = null;
		try{
			session.beginTransaction();
			try {
				daftarPeranPengguna = session.createQuery("from PeranPengguna " + queryParam).list();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return daftarPeranPengguna;
	}

}
