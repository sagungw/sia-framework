package com.sia.main.data;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.sia.main.data.sessionfactory.SecuritySessionFactoryManager;
import com.sia.main.domain.*;

public class DataBundleActivator implements BundleActivator {

	private BundleContext context;
	
	@Override
	public void start(final BundleContext context) throws Exception {
		SecuritySessionFactoryManager.addAnnotatedClass(Menu.class);
		SecuritySessionFactoryManager.addAnnotatedClass(MenuPeran.class);
		SecuritySessionFactoryManager.addAnnotatedClass(Modul.class);
		SecuritySessionFactoryManager.addAnnotatedClass(Pengguna.class);
		SecuritySessionFactoryManager.addAnnotatedClass(Peran.class);
		SecuritySessionFactoryManager.addAnnotatedClass(PeranPengguna.class);
		SecuritySessionFactoryManager.addAnnotatedClass(SatuanManajemen.class);
		this.context = context;
        System.out.println("Data bundle activated");
        
        new Thread(){
            @Override
            public void run() {
                SessionFactoryConfLocator sfLocator = new SessionFactoryConfLocator(context);
                try {
                	SecuritySessionFactoryManager.setSessionFactoryConfiguration(sfLocator.getSessionFactoryConfiguration(0));
                    System.out.println("Session factory configuration registered");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                sfLocator.close();
            }
        }.start();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Data bundle stopped");
	}

}
