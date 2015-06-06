package com.sia.main.data.repositories.impl;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sia.main.data.repositories.MenuPeranRepository;
import com.sia.main.data.sessionfactory.SessionFactoryManager;
import com.sia.main.domain.MenuPeran;

public class MenuPeranRepositoryImpl implements MenuPeranRepository {

	@Autowired
	private SessionFactoryManager sessionFactoryManager;
	
	@Transactional
	@Override
	public void insertInto(MenuPeran menuPeran) {
		Session session = sessionFactoryManager.getSecuritySessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(menuPeran);
		transaction.commit();
	}

	@Transactional
	@Override
	public void update(MenuPeran menuPeran) {
		Session session = sessionFactoryManager.getSecuritySessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.update(menuPeran);
		transaction.commit();
	}

	@Transactional
	@Override
	public void delete(MenuPeran menuPeran) {
		Session session = sessionFactoryManager.getSecuritySessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.delete(menuPeran);
		transaction.commit();
	}

	@Transactional
	@Override
	public List<MenuPeran> getAll() {
		Session session = sessionFactoryManager.getSecuritySessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		return session.createQuery("from MenuPeran").list();
	}

	@Transactional
	@Override
	public MenuPeran getById(UUID idMenuPeran) {
		Session session = sessionFactoryManager.getSecuritySessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		return(MenuPeran)session.get(MenuPeran.class, idMenuPeran);
	}

}
