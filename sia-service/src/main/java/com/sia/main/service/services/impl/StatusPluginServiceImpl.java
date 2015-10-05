package com.sia.main.service.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.sia.main.data.dao.StatusPluginDAO;
import com.sia.main.domain.StatusPlugin;
import com.sia.main.service.services.StatusPluginService;

@Service
public class StatusPluginServiceImpl implements StatusPluginService {
	
	private StatusPluginDAO statusPluginDAO;

	public StatusPluginDAO getStatusPluginDAO() {
		return statusPluginDAO;
	}

	public void setStatusPluginDAO(
			StatusPluginDAO statusPluginDAO) {
		this.statusPluginDAO = statusPluginDAO;
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
				this.statusPluginDAO.insert(statusPlugin);
			} else {
				this.update(statusPlugin);
			}
			result = statusPlugin;
		}
		return result;
	}
	
	@Override
	public boolean refreshFrameworkStatusList() {
		try {
			StatusPlugin statusPlugin;
			statusPlugin = new StatusPlugin(null, "ACTIVE", null);
			this.insertInto(statusPlugin);
			statusPlugin = new StatusPlugin(null, "INSTALLED", null);
			this.insertInto(statusPlugin);
			statusPlugin = new StatusPlugin(null, "RESOLVED", null);
			this.insertInto(statusPlugin);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public StatusPlugin update(StatusPlugin statusPlugin) {
		this.statusPluginDAO.update(statusPlugin);
		return statusPlugin;
	}

	@Override
	public StatusPlugin delete(StatusPlugin statusPlugin) {
		this.statusPluginDAO.delete(statusPlugin);
		return statusPlugin;
	}

	@Override
	public StatusPlugin getById(UUID idStatus) {
		return this.statusPluginDAO.getById(idStatus);
	}

	@Override
	public List<StatusPlugin> getByParam(String queryParam) {
		return this.statusPluginDAO.getByParam(queryParam);
	}

	@Override
	public List<StatusPlugin> getAll() {
		return this.statusPluginDAO.getAll();
	}

}
