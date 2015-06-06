package com.sia.main.data.repositories.impl;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	public void insertInto(Pengguna pengguna) {
		Session session = sessionFactoryManager.getSecuritySessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(pengguna);
		transaction.commit();
	}

	@Override
	public void update(Pengguna pengguna) {
		Session session = sessionFactoryManager.getSecuritySessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.update(pengguna);
		transaction.commit();
	}

	@Override
	public void delete(Pengguna pengguna) {
		Session session = sessionFactoryManager.getSecuritySessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.delete(pengguna);
		transaction.commit();
	}

	@Override
	public List<Pengguna> getAll() {
		Session session = sessionFactoryManager.getSecuritySessionFactory()
				.getCurrentSession();
		session.beginTransaction();
		return session.createQuery("from Pengguna").list();
	}

	@Override
	public Pengguna getById(UUID idPengguna) {
		Session session = sessionFactoryManager.getSecuritySessionFactory()
				.getCurrentSession();
		session.beginTransaction();
		return (Pengguna) session.get(Pengguna.class, idPengguna);
	}

}
