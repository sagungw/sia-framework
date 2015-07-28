package com.sia.main.data.repositories.impl;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sia.main.data.repositories.SatuanManajemenRepository;
import com.sia.main.data.sessionfactory.SessionFactoryManager;
import com.sia.main.domain.SatMan;

@Repository
public class SatuanManajemenRepositoryImpl implements SatuanManajemenRepository{
	
	private SessionFactoryManager sessionFactoryManager;
	
	public SessionFactoryManager getSessionFactoryManager() {
		return sessionFactoryManager;
	}

	public void setSessionFactoryManager(SessionFactoryManager sessionFactoryManager) {
		this.sessionFactoryManager = sessionFactoryManager;
	}

	@Transactional
	@Override
	public void insertInto(SatMan satuanManajemen) {
		Session session = sessionFactoryManager.getSecuritySessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(satuanManajemen);
		transaction.commit();
	}

	@Transactional
	@Override
	public void update(SatMan satuanManajemen) {
		Session session = sessionFactoryManager.getSecuritySessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.update(satuanManajemen);
		transaction.commit();
	}

	@Transactional
	@Override
	public void delete(SatMan satuanManajemen) {
		Session session = sessionFactoryManager.getSecuritySessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.delete(satuanManajemen);
		transaction.commit();
	}

	@Transactional
	@Override
	public List<SatMan> getAll() {
		Session session = sessionFactoryManager.getSecuritySessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		return session.createQuery("from SatuanManajemen").list();
	}

	@Transactional
	@Override
	public SatMan getById(UUID idSatuanManajemen) {
		Session session = sessionFactoryManager.getSecuritySessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		return (SatMan) session.get(SatMan.class, idSatuanManajemen);
	}

}
