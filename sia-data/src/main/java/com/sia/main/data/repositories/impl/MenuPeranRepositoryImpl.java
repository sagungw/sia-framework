package com.sia.main.data.repositories.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import com.sia.main.data.repositories.MenuPeranRepository;
import com.sia.main.data.sessionfactory.SecuritySessionFactoryManager;
import com.sia.main.domain.MenuPeran;

public class MenuPeranRepositoryImpl implements MenuPeranRepository {

	private Session session;
	
	@Transactional
	@Override
	public void insertInto(MenuPeran menuPeran) {
		session = SecuritySessionFactoryManager.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(menuPeran);
		transaction.commit();
	}

	@Transactional
	@Override
	public void update(MenuPeran menuPeran) {
		session = SecuritySessionFactoryManager.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.update(menuPeran);
		transaction.commit();
	}

	@Transactional
	@Override
	public void delete(MenuPeran menuPeran) {
		session = SecuritySessionFactoryManager.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.delete(menuPeran);
		transaction.commit();
	}

	@Transactional
	@Override
	public List<MenuPeran> getAll() {
		session = SecuritySessionFactoryManager.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		return session.createQuery("from MenuPeran").list();
	}

	@Transactional
	@Override
	public MenuPeran getById(String idMenuPeran) {
		session = SecuritySessionFactoryManager.getSessionFactory()
				.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		return(MenuPeran)session.get(MenuPeran.class, idMenuPeran);
	}

}
