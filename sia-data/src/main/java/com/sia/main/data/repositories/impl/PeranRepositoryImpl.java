package com.sia.main.data.repositories.impl;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import com.sia.main.data.repositories.PeranRepository;
import com.sia.main.data.sessionfactory.SecuritySessionFactoryManager;
import com.sia.main.domain.Peran;

public class PeranRepositoryImpl implements PeranRepository {

	private Session session;
	
	@Transactional
	@Override
	public void insertInto(Peran peran) {
		session = SecuritySessionFactoryManager.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(peran);
		transaction.commit();
	}

	@Transactional
	@Override
	public void update(Peran peran) {
		session = SecuritySessionFactoryManager.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.update(peran);
		transaction.commit();
	}

	@Transactional
	@Override
	public void delete(Peran peran) {
		session = SecuritySessionFactoryManager.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.delete(peran);
		transaction.commit();
	}

	@Transactional
	@Override
	public List<Peran> getAll() {
		session = SecuritySessionFactoryManager.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		return session.createQuery("from Peran").list();
	}

	@Transactional
	@Override
	public Peran getById(UUID idPeran) {
		session = SecuritySessionFactoryManager.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		return (Peran) session.get(Peran.class, idPeran);
	}

}
