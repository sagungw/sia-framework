package com.sia.main.plugin.modul;

public interface IPlugin {
	public void setID(String pluginID);

	public String getID();

	public void setName(String pluginName);

	public String getName();

	public void setVersion(String pluginVersion);

	public String getVersion();

	public void setIsActive(Boolean isActive);

	public Boolean getIsActive();
}
