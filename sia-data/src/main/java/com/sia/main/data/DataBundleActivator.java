package com.sia.main.data;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.sia.main.data.repositories.*;
import com.sia.main.data.repositories.impl.*;
import com.sia.main.data.sessionfactory.SecuritySessionFactoryManager;

import com.sia.main.domain.*;

public class DataBundleActivator implements BundleActivator {

	public void start(final BundleContext context) throws Exception {
		context.registerService(PenggunaRepository.class.getName(), new PenggunaRepositoryImpl(), null);
		context.registerService(PeranRepository.class.getName(), new PeranRepositoryImpl(), null);
		context.registerService(PeranPenggunaRepository.class.getName(), new PeranPenggunaRepositoryImpl(), null);
		context.registerService(SatuanManajemenRepository.class.getName(), new SatuanManajemenRepositoryImpl(), null);
		context.registerService(ModulRepository.class.getName(), new ModulRepositoryImpl(), null);
		context.registerService(MenuRepository.class.getName(), new MenuRepositoryImpl(), null);
		context.registerService(MenuPeranRepository.class.getName(), new MenuPeranRepositoryImpl(), null);
		SecuritySessionFactoryManager.addAnnotatedClass(Menu.class);
		SecuritySessionFactoryManager.addAnnotatedClass(MenuPeran.class);
		SecuritySessionFactoryManager.addAnnotatedClass(Modul.class);
		SecuritySessionFactoryManager.addAnnotatedClass(Pengguna.class);
		SecuritySessionFactoryManager.addAnnotatedClass(Peran.class);
		SecuritySessionFactoryManager.addAnnotatedClass(PeranPengguna.class);
		SecuritySessionFactoryManager.addAnnotatedClass(SatuanManajemen.class);
		new Thread() {
			
			@Override
			public void run() {
				DBAccessServiceLocator dbaServiceLocator = new DBAccessServiceLocator(context);
				try {
					SecuritySessionFactoryManager.setSessionFactoryConfiguration(dbaServiceLocator.getDBAccessService(0));
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		}.start();
	}

	public void stop(BundleContext context) throws Exception {
	}

}
