package com.sia.main.service.services.impl;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sia.main.data.repositories.StatusPluginRepository;
import com.sia.main.domain.StatusPlugin;
import com.sia.main.service.services.StatusPluginService;

public class StatusPluginServiceImpl implements StatusPluginService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private StatusPluginRepository statusPluginRepository;

	public StatusPluginRepository getStatusPluginRepository() {
		return statusPluginRepository;
	}

	public void setStatusPluginRepository(
			StatusPluginRepository statusPluginRepository) {
		this.statusPluginRepository = statusPluginRepository;
	}

	@Override
	public StatusPlugin insertInto(StatusPlugin statusPlugin) {
		List<StatusPlugin> queryResult = this.getByParam("where namaStatus = '" + statusPlugin.getNamaStatus() + "'");
		StatusPlugin result;
		if(queryResult.size() > 0) {
			result = queryResult.get(0);
			if(!statusPlugin.getIdStatus().toString().equals(result.getIdStatus().toString())) {
				result = null;
			}
		} else {
			StatusPlugin temp = this.getById(statusPlugin.getIdStatus());
			if(temp == null) {
				result = this.statusPluginRepository.insertInto(statusPlugin);
			} else {
				result = this.update(statusPlugin);
			}
		}
		return result;
	}

	@Override
	public StatusPlugin update(StatusPlugin statusPlugin) {
		return this.statusPluginRepository.update(statusPlugin);
	}

	@Override
	public StatusPlugin delete(StatusPlugin statusPlugin) {
		return this.statusPluginRepository.delete(statusPlugin);
	}

	@Override
	public StatusPlugin getById(UUID idStatus) {
		return this.statusPluginRepository.getById(idStatus);
	}

	@Override
	public List<StatusPlugin> getByParam(String queryParam) {
		return this.statusPluginRepository.getByParam(queryParam);
	}

	@Override
	public List<StatusPlugin> getAll() {
		return this.statusPluginRepository.getAll();
	}

}
