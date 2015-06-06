package com.sia.main.data.repositories.impl;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sia.main.data.repositories.ModulRepository;
import com.sia.main.data.sessionfactory.SessionFactoryManager;
import com.sia.main.domain.Modul;

@Repository
public class ModulRepositoryImpl implements ModulRepository{

	@Autowired
	private SessionFactoryManager sessionFactoryManager;
	
	@Transactional
	@Override
	public void insertInto(Modul modul) {
		Session session = sessionFactoryManager.getSecuritySessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(modul);
		transaction.commit();
	}

	@Transactional
	@Override
	public void update(Modul modul) {
		Session session = sessionFactoryManager.getSecuritySessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.update(modul);
		transaction.commit();
	}

	@Transactional
	@Override
	public void delete(Modul modul) {
		Session session = sessionFactoryManager.getSecuritySessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.delete(modul);
		transaction.commit();
	}

	@Transactional
	@Override
	public List<Modul> getAll() {
		Session session = sessionFactoryManager.getSecuritySessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		return session.createQuery("from Modul").list();
	}

	@Transactional
	@Override
	public Modul getById(UUID idModul) {
		Session session = sessionFactoryManager.getSecuritySessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		return (Modul)session.get(Modul.class, idModul);
	}

}
