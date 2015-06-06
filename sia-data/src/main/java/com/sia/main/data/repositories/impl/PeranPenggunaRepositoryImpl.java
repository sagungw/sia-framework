package com.sia.main.data.repositories.impl;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sia.main.data.repositories.PeranPenggunaRepository;
import com.sia.main.data.sessionfactory.SessionFactoryManager;
import com.sia.main.domain.PeranPengguna;

public class PeranPenggunaRepositoryImpl implements PeranPenggunaRepository {
	
	@Autowired
	private SessionFactoryManager sessionFactoryManager;
	
	@Transactional
	@Override
	public void insertInto(PeranPengguna peranPengguna) {
		Session session = sessionFactoryManager.getSecuritySessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(peranPengguna);
		transaction.commit();
	}

	@Transactional
	@Override
	public void update(PeranPengguna peranPengguna) {
		Session session = sessionFactoryManager.getSecuritySessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.update(peranPengguna);
		transaction.commit();
	}

	@Transactional
	@Override
	public void delete(PeranPengguna peranPengguna) {
		Session session = sessionFactoryManager.getSecuritySessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.delete(peranPengguna);
		transaction.commit();
	}

	@Transactional
	@Override
	public List<PeranPengguna> getAll() {
		Session session = sessionFactoryManager.getSecuritySessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		return session.createQuery("from PeranPengguna").list();
	}

	@Transactional
	@Override
	public PeranPengguna getById(UUID idPeranPengguna) {
		Session session = sessionFactoryManager.getSecuritySessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		return (PeranPengguna) session.get(PeranPengguna.class, idPeranPengguna);
	}

}
