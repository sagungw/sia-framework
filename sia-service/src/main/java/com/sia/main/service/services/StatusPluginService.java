package com.sia.main.service.services;

import java.util.List;
import java.util.UUID;

import com.sia.main.domain.StatusPlugin;

public interface StatusPluginService {
	
	public StatusPlugin insertInto(StatusPlugin statusPlugin);
	
	public StatusPlugin update(StatusPlugin statusPlugin);
	
	public StatusPlugin delete(StatusPlugin statusPlugin);
	
	public StatusPlugin getById(UUID idStatus);
	
	public List<StatusPlugin> getByParam(String queryParam);

	public List<StatusPlugin> getAll();


}
