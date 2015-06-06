package com.sia.main.data.repositories.impl;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sia.main.data.repositories.MenuRepository;
import com.sia.main.data.sessionfactory.SessionFactoryManager;
import com.sia.main.domain.Menu;

public class MenuRepositoryImpl implements MenuRepository {

	@Autowired
	private SessionFactoryManager sessionFactoryManager;
	
	@Transactional
	@Override
	public void insertInto(Menu menu) {
		Session session = sessionFactoryManager.getSecuritySessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(menu);
		transaction.commit();
	}

	@Transactional
	@Override
	public void update(Menu menu) {
		Session session = sessionFactoryManager.getSecuritySessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.update(menu);
		transaction.commit();
	}

	@Transactional
	@Override
	public void delete(Menu menu) {
		Session session = sessionFactoryManager.getSecuritySessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.delete(menu);
		transaction.commit();
	}

	@Transactional
	@Override
	public List<Menu> getAll() {
		Session session = sessionFactoryManager.getSecuritySessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		return session.createQuery("from Menu").list();
	}

	@Transactional
	@Override
	public Menu getById(UUID idMenu) {
		Session session = sessionFactoryManager.getSecuritySessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		return (Menu)session.get(Menu.class, idMenu);
	}
}
