package com.sia.main.service.module.impl;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.sia.main.plugin.modul.Menu;
import com.sia.main.plugin.modul.Module;
import com.sia.main.plugin.modul.impl.PackageBasedModule;
import com.sia.main.plugin.modul.impl.StandardMenu;

public class ModuleXmlParseHandler extends DefaultHandler {

	private Module generatedModule;
	
	private Menu generatedMenu;
	
	private boolean bModule = false;
	
	private boolean bName = false;
	
	private boolean bVersion = false;
	
	private boolean bBasePackages = false;

	private boolean bMenues = false;
	
	private boolean bMenu = false;
	
	private boolean bUrl = false;
	
	public Module getGeneratedModule() {
		return this.generatedModule;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equalsIgnoreCase("module")) {
			this.generatedModule = new PackageBasedModule();
			bModule = true;
		}
		
		if(qName.equalsIgnoreCase("name") && bModule) {
			bName = true;
		} else if(qName.equalsIgnoreCase("name") && !bModule) {
			throw new SAXException("<name> must be inside <module>");
		}
		
		if(qName.equalsIgnoreCase("version") && bModule) {
			bVersion = true;
		} else if(qName.equalsIgnoreCase("version") && !bModule) {
			throw new SAXException("<version> must be inside <module>");
		}
		
		if(qName.equalsIgnoreCase("base-packages") && bModule) {
			bBasePackages = true;
		} else if(qName.equalsIgnoreCase("base-packages") && !bModule) {
			throw new SAXException("<base-packages> must be inside <module>");
		}
		
		if(qName.equalsIgnoreCase("menues")  && bModule) {
			bMenues = true;
		} else if(qName.equalsIgnoreCase("menues") && !bModule) {
			throw new SAXException("<menues> must be inside <module>");
		}
		
		if(qName.equalsIgnoreCase("menu") && bMenues) {
			this.generatedMenu = new StandardMenu();
			bMenu = true;
		} else if(qName.equalsIgnoreCase("menu") && !bMenues) {
			throw new SAXException("<menu> must be inside <menues>");
		}
		
		if(qName.equalsIgnoreCase("url") && bMenu) {
			bUrl = true;
		} else if(qName.equalsIgnoreCase("url") && !bMenu) {
			throw new SAXException("<url> must be inside <menu>");
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equalsIgnoreCase("module")) {
			bModule = false;
		}
		if(qName.equalsIgnoreCase("name")) {
			bName = false;
		}
		if(qName.equalsIgnoreCase("version")) {
			bVersion = false;
		}
		if(qName.equalsIgnoreCase("base-packages")) {
			bBasePackages = false;
		}
		if(qName.equalsIgnoreCase("menues")) {
			bMenues = false;
		}
		if(qName.equalsIgnoreCase("menu")) {
			this.generatedModule.addMenu(this.generatedMenu);
			this.generatedMenu = null;
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
				this.generatedMenu.setMenuName(new String(ch, start, length));
			} else {
				this.generatedModule.setModuleName(new String(ch, start, length));
			}
			System.out.println(new String(ch, start, length));
		}
		if(bVersion) {
			this.generatedModule.setPluginVersion(new String(ch, start, length));
			System.out.println(new String(ch, start, length));
		}
		if(bBasePackages) {
			String basePackages = new String(ch, start, length);
			basePackages = basePackages.replace(" ", "");
			
			PackageBasedModule temp = (PackageBasedModule) this.generatedModule;
			
			for(String basePackage : basePackages.split(",")) {
				temp.addBasePackage(basePackage);
			}
			
			this.generatedModule = temp;
			System.out.println(new String(ch, start, length));
		}
		if(bUrl) {
			this.generatedMenu.setUrl(new String(ch, start, length));
			System.out.println(new String(ch, start, length));
		}
	}
	
}
