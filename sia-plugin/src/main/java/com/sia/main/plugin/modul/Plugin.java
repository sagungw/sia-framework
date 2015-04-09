package com.sia.main.plugin.modul;

public abstract class Plugin implements IPlugin {
	protected String name;
	protected String ID;
	protected String version;
	protected Boolean isActive;

	public void setID(String pluginID) {
		this.ID = pluginID;
	}

	public String getID() {
		return this.ID;
	}

	public void setName(String pluginName) {
		this.name = pluginName;
	}

	public String getName() {
		return this.name;
	}

	public void setVersion(String pluginVersion) {
		this.version = pluginVersion;
	}

	public String getVersion() {
		return this.version;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

}
