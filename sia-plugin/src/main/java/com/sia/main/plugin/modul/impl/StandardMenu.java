package com.sia.main.plugin.modul.impl;

import com.sia.main.plugin.modul.Menu;

public class StandardMenu implements Menu {

	private String menuName;
	
	private String url;
	
	private String urlPattern;
	
	public StandardMenu(String menuName, String url, String urlPattern) {
		super();
		this.menuName = menuName;
		this.url = url;
		this.urlPattern = urlPattern;
	}

	public void setUrl(String homeUrl) {
		this.url = homeUrl;
	}
	
	@Override
	public String getUrl() {
		return this.url;
	}
	
	public void setUrlPattern(String urlPattern) {
		this.urlPattern = urlPattern;
	}

	@Override
	public String getUrlPattern() {
		return this.urlPattern;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	@Override
	public String getMenuName() {
		return this.menuName;
	}

}
