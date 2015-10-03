package com.sia.main.data.dao.impl;

import java.util.List;
import java.util.UUID;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sia.main.data.dao.StatusPluginDAO;
import com.sia.main.domain.StatusPlugin;

@Repository
@Transactional
public class StatusPluginDAOImpl implements StatusPluginDAO {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insert(StatusPlugin object) {
		this.sessionFactory.getCurrentSession().save(object);
	}

	@Override
	public void update(StatusPlugin object) {
		this.sessionFactory.getCurrentSession().update(object);
	}

	@Override
	public void delete(StatusPlugin object) {
		this.sessionFactory.getCurrentSession().delete(object);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StatusPlugin> getAll() {
		return this.sessionFactory.getCurrentSession().createQuery("from StatusPlugin").list();
	}

	@Override
	public StatusPlugin getById(UUID idObject) {
		return (StatusPlugin) this.sessionFactory.getCurrentSession().get(StatusPlugin.class, idObject);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StatusPlugin> getByParam(String queryParam) {
		return this.sessionFactory.getCurrentSession().createQuery("from StatusPlugin " + queryParam).list();
	}
	
}