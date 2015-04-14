package com.sia.main.service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.sia.main.service.services.*;
import com.sia.main.service.services.impl.*;

public class ServiceBundleActivator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		context.registerService(PenggunaService.class.getName(), new PenggunaServiceImpl(), null);
		context.registerService(PeranService.class.getName(), new PeranServiceImpl(), null);
		context.registerService(PeranPenggunaService.class.getName(), new PeranPenggunaServiceImpl(), null);
		context.registerService(SatuanManajemenService.class.getName(), new SatuanManajemenServiceImpl(), null);
		context.registerService(ModulService.class.getName(), new ModulServiceImpl(), null);
		context.registerService(MenuService.class.getName(), new MenuServiceImpl(), null);
		context.registerService(MenuPeranService.class.getName(), new MenuPeranServiceImpl(), null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		
	}

}
