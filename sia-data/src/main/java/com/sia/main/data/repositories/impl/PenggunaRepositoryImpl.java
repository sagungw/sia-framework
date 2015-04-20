package com.sia.main.data.repositories.impl;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sia.main.data.repositories.PenggunaRepository;
import com.sia.main.data.sessionfactory.SecuritySessionFactoryManager;
import com.sia.main.domain.Pengguna;

@Repository
public class PenggunaRepositoryImpl implements PenggunaRepository {

	private Session session;

	@Transactional
	@Override
	public void insertInto(Pengguna pengguna) {
		session = SecuritySessionFactoryManager.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(pengguna);
		transaction.commit();
	}

	@Transactional
	@Override
	public void update(Pengguna pengguna) {
		session = SecuritySessionFactoryManager.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.update(pengguna);
		transaction.commit();
	}

	@Transactional
	@Override
	public void delete(Pengguna pengguna) {
		session = SecuritySessionFactoryManager.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.delete(pengguna);
		transaction.commit();
	}

	@Transactional
	@Override
	public List<Pengguna> getAll() {
		session = SecuritySessionFactoryManager.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		return session.createQuery("from Pengguna").list();
	}

	@Transactional
	@Override
	public Pengguna getById(UUID idPengguna) {
		session = SecuritySessionFactoryManager.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		return (Pengguna) session.get(Pengguna.class, idPengguna);
	}

}
