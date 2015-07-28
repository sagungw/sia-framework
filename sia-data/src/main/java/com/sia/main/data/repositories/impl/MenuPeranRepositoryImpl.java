package com.sia.main.data.repositories.impl;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.sia.main.data.repositories.MenuPeranRepository;
import com.sia.main.data.sessionfactory.SessionFactoryManager;
import com.sia.main.domain.MenuPeran;

@Repository
public class MenuPeranRepositoryImpl implements MenuPeranRepository {

	private SessionFactoryManager sessionFactoryManager;

	public SessionFactoryManager getSessionFactoryManager() {
		return sessionFactoryManager;
	}

	public void setSessionFactoryManager(SessionFactoryManager sessionFactoryManager) {
		this.sessionFactoryManager = sessionFactoryManager;
	}
	
	private Session getSession() {
		Session session = sessionFactoryManager.getSecuritySessionFactory().getCurrentSession();
		System.out.println("retrieving current hibernate session");
		if(session == null || !session.isOpen()) {
			System.out.println("hibernate session is either null or closed. will open a new one instead");
			session = sessionFactoryManager.getSecuritySessionFactory().openSession();
		}
		return session;
	}
	
	@Override
	public void insertInto(MenuPeran menuPeran) {
		final Session session = this.getSession();
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				session.save(menuPeran);
				transaction.commit();
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
	}

	@Override
	public void update(MenuPeran menuPeran) {
		final Session session = this.getSession();
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				session.update(menuPeran);
				transaction.commit();
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
	}

	@Override
	public void delete(MenuPeran menuPeran) {
		final Session session = this.getSession();
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				session.delete(menuPeran);
				transaction.commit();
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
	}

	@Override
	public List<MenuPeran> getAll() {
		final Session session = this.getSession();
		List<MenuPeran> menuPeranList = null;
		try{
			session.beginTransaction();
			try {
				menuPeranList = session.createQuery("from MenuPeran").list();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return menuPeranList;
	}

	@Override
	public MenuPeran getById(UUID idMenuPeran) {
		final Session session = this.getSession();
		MenuPeran menuPeran = null;
		try{
			session.beginTransaction();
			try {
				menuPeran = (MenuPeran)session.get(MenuPeran.class, idMenuPeran);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return menuPeran;
	}

	@Override
	public List<MenuPeran> getByParam(String queryParam) {
		final Session session = this.getSession();
		List<MenuPeran> menuPeranList = null;
		try{
			session.beginTransaction();
			try {
				menuPeranList = session.createQuery("from MenuPeran " + queryParam).list();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return menuPeranList;
	}

}
