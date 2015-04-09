package com.sia.main.data.repositories.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import com.sia.main.data.repositories.PeranPenggunaRepository;
import com.sia.main.data.sessionfactory.SecuritySessionFactoryManager;
import com.sia.main.domain.PeranPengguna;

public class PeranPenggunaRepositoryImpl implements PeranPenggunaRepository {
	
	private Session session;
	
	@Transactional
	@Override
	public void insertInto(PeranPengguna peranPengguna) {
		session = SecuritySessionFactoryManager.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(peranPengguna);
		transaction.commit();
	}

	@Transactional
	@Override
	public void update(PeranPengguna peranPengguna) {
		session = SecuritySessionFactoryManager.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.update(peranPengguna);
		transaction.commit();
	}

	@Transactional
	@Override
	public void delete(PeranPengguna peranPengguna) {
		session = SecuritySessionFactoryManager.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.delete(peranPengguna);
		transaction.commit();
	}

	@Transactional
	@Override
	public List<PeranPengguna> getAll() {
		session = SecuritySessionFactoryManager.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		return session.createQuery("from PeranPengguna").list();
	}

	@Transactional
	@Override
	public PeranPengguna getById(String idPeranPengguna) {
		session = SecuritySessionFactoryManager.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		return (PeranPengguna) session.get(PeranPengguna.class, idPeranPengguna);
	}

}
