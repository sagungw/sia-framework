package com.sia.main.service.util.impl;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.sia.main.plugin.modul.Menu;
import com.sia.main.plugin.modul.Module;
import com.sia.main.plugin.modul.impl.StandardMenu;
import com.sia.main.plugin.modul.impl.StandardModule;

public class ModuleXmlParseHandler extends DefaultHandler {

	private Module generatedModule;
	
	private List<Menu> generatedMenues;
	
	private String moduleName;
	
	private String moduleVersion;
	
	private String moduleBasePackages;
	
	private String menuName;
	
	private String menuUrl;
	
	private boolean bName = false;
	
	private boolean bVersion = false;
	
	private boolean bBasePackages = false;
	
	private boolean bMenu = false;
	
	private boolean bUrl = false;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equalsIgnoreCase("name")) {
			bName = true;
		}
		if(qName.equalsIgnoreCase("version")) {
			bVersion = true;
		}
		if(qName.equalsIgnoreCase("base-packages")) {
			bBasePackages = true;
		}
		if(qName.equalsIgnoreCase("menues")) {
			this.generatedMenues = new ArrayList<Menu>();
		}
		if(qName.equalsIgnoreCase("menu")) {
			bMenu = true;
		}
		if(qName.equalsIgnoreCase("url")) {
			bUrl = true;
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equalsIgnoreCase("name")) {
			bName = false;
		}
		if(qName.equalsIgnoreCase("version")) {
			bVersion = false;
		}
		if(qName.equalsIgnoreCase("base-packages")) {
			bBasePackages = false;
		}
		if(qName.equalsIgnoreCase("menu")) {
			this.generatedMenues.add(new StandardMenu(this.menuName, this.menuUrl));
			bMenu = false;
		}
		if(qName.equalsIgnoreCase("url")) {
			bUrl = false;
		}
	}
	
	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		if(bName) {
			if(bMenu) {
				this.menuName = new String(ch, start, length);
			} else {
				this.moduleName = new String(ch, start, length);
			}
		}
		if(bVersion) {
			this.moduleVersion = new String(ch, start, length);
		}
		if(bBasePackages) {
			this.moduleBasePackages = new String(ch, start, length);
		}
		if(bUrl) {
			this.menuUrl = new String(ch, start, length);
		}
	}
	
	@Override
	public void endDocument() throws SAXException {
		this.moduleBasePackages.replace(" ", "");
		List<String> basePackages = new ArrayList<String>();
		for(String basePackage : this.moduleBasePackages.split(",")) {
			basePackages.add(basePackage);
		}
		this.generatedModule = new StandardModule("", this.moduleVersion, this.generatedMenues, this.moduleName, "", "", basePackages);
	}
	
	public Module getGeneratedModule() {
		return this.generatedModule;
	}
	
}
