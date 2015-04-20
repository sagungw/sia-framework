package com.sia.main.data.repositories.impl;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import com.sia.main.data.repositories.SatuanManajemenRepository;
import com.sia.main.data.sessionfactory.SecuritySessionFactoryManager;
import com.sia.main.domain.SatuanManajemen;

public class SatuanManajemenRepositoryImpl implements SatuanManajemenRepository{
	
	private Session session;
	
	@Transactional
	@Override
	public void insertInto(SatuanManajemen satuanManajemen) {
		session = SecuritySessionFactoryManager.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(satuanManajemen);
		transaction.commit();
	}

	@Transactional
	@Override
	public void update(SatuanManajemen satuanManajemen) {
		session = SecuritySessionFactoryManager.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.update(satuanManajemen);
		transaction.commit();
	}

	@Transactional
	@Override
	public void delete(SatuanManajemen satuanManajemen) {
		session = SecuritySessionFactoryManager.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.delete(satuanManajemen);
		transaction.commit();
	}

	@Transactional
	@Override
	public List<SatuanManajemen> getAll() {
		session = SecuritySessionFactoryManager.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		return session.createQuery("from SatuanManajemen").list();
	}

	@Transactional
	@Override
	public SatuanManajemen getById(UUID idSatuanManajemen) {
		session = SecuritySessionFactoryManager.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		return (SatuanManajemen) session.get(SatuanManajemen.class, idSatuanManajemen);
	}

}
