package com.sia.main.data.repositories.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import com.sia.main.data.repositories.MenuRepository;
import com.sia.main.data.sessionfactory.SecuritySessionFactoryManager;
import com.sia.main.domain.Menu;

public class MenuRepositoryImpl implements MenuRepository {

	private Session session;

	@Transactional
	@Override
	public void insertInto(Menu menu) {
		session = SecuritySessionFactoryManager.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(menu);
		transaction.commit();
	}

	@Transactional
	@Override
	public void update(Menu menu) {
		session = SecuritySessionFactoryManager.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.update(menu);
		transaction.commit();
	}

	@Transactional
	@Override
	public void delete(Menu menu) {
		session = SecuritySessionFactoryManager.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.delete(menu);
		transaction.commit();
	}

	@Transactional
	@Override
	public List<Menu> getAll() {
		session = SecuritySessionFactoryManager.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		return session.createQuery("from Menu").list();
	}

	@Transactional
	@Override
	public Menu getById(String idMenu) {
		session = SecuritySessionFactoryManager.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		return (Menu)session.get(Menu.class, idMenu);
	}
}
