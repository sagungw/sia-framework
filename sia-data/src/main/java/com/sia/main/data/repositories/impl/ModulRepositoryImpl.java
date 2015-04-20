package com.sia.main.data.repositories.impl;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sia.main.data.repositories.ModulRepository;
import com.sia.main.data.sessionfactory.SecuritySessionFactoryManager;
import com.sia.main.domain.Modul;

@Repository
public class ModulRepositoryImpl implements ModulRepository{

	private Session session;
	
	@Transactional
	@Override
	public void insertInto(Modul modul) {
		session = SecuritySessionFactoryManager.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(modul);
		transaction.commit();
	}

	@Transactional
	@Override
	public void update(Modul modul) {
		session = SecuritySessionFactoryManager.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.update(modul);
		transaction.commit();
	}

	@Transactional
	@Override
	public void delete(Modul modul) {
		session = SecuritySessionFactoryManager.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.delete(modul);
		transaction.commit();
	}

	@Transactional
	@Override
	public List<Modul> getAll() {
		session = SecuritySessionFactoryManager.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		return session.createQuery("from Modul").list();
	}

	@Transactional
	@Override
	public Modul getById(UUID idModul) {
		session = SecuritySessionFactoryManager.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		return (Modul)session.get(Modul.class, idModul);
	}

}
