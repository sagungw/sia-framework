package com.sia.main.data.dao.impl;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sia.main.data.dao.MenuDAO;
import com.sia.main.data.sessionfactory.SessionFactoryManager;
import com.sia.main.domain.Menu;

@Repository
@Transactional
public class MenuDAOImpl implements MenuDAO {


	private static final Logger logger = LoggerFactory.getLogger(MenuDAOImpl.class);
	
	private SessionFactoryManager sessionFactoryManager;
	
	public SessionFactoryManager getSessionFactoryManager() {
		return sessionFactoryManager;
	}

	public void setSessionFactoryManager(SessionFactoryManager sessionFactoryManager) {
		this.sessionFactoryManager = sessionFactoryManager;
	}
	
	private Session getSession() {
		Session session = sessionFactoryManager.getSecuritySessionFactory().getCurrentSession();
		if(session == null || !session.isOpen()) {
			if(logger.isInfoEnabled()) logger.info("hibernate session is either null or closed. will open a new one instead");
			session = sessionFactoryManager.getSecuritySessionFactory().openSession();
		}
		return session;
	}

	@Override
	public void insert(Menu menu) {
		final Session session = this.getSession();
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				session.save(menu);
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
	public void update(Menu menu) {
		final Session session = this.getSession();
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				session.update(menu);
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
	public void delete(Menu menu) {
		final Session session = this.getSession();
		try{
			final Transaction transaction = session.beginTransaction();
			try {
				session.delete(menu);
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> getAll() {
		final Session session = this.getSession();
		List<Menu> menuList = null;
		try{
			session.beginTransaction();
			try {
				menuList = session.createQuery("from Menu").list();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return menuList;
	}

	@Override
	public Menu getById(UUID idMenu) {
		final Session session = this.getSession();
		Menu menu = null;
		try{
			session.beginTransaction();
			try {
				menu = (Menu)session.get(Menu.class, idMenu);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return menu;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> getByParam(String queryParam) {
		final Session session = this.getSession();
		List<Menu> menuList = null;
		try{
			session.beginTransaction();
			try {
				menuList = session.createQuery("from Menu " + queryParam).list();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} finally {
			if(session.isOpen())
				session.close();
		}
		return menuList;
	}
}
