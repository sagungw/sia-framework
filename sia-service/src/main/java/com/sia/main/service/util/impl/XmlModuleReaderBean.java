package com.sia.main.service.util.impl;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.osgi.framework.Bundle;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.sia.main.plugin.modul.Module;
import com.sia.main.service.util.OsgiModuleReader;

public class XmlModuleReaderBean implements OsgiModuleReader {
	
	private String moduleDetailXmlPath;

	private String prefix;
	
	private ModuleXmlParseHandler parserHandler;
	
	public String getModuleDetailXmlPath() {
		return moduleDetailXmlPath;
	}

	public void setModuleDetailXmlPath(String moduleDetailXmlPath) {
		this.moduleDetailXmlPath = moduleDetailXmlPath;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public DefaultHandler getParserHandler() {
		return parserHandler;
	}

	public void setParserHandler(ModuleXmlParseHandler parserHandler) {
		this.parserHandler = parserHandler;
	}

	@Override
	public Module readModule(Bundle moduleBundle) {
		Module module = null;
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			String moduleDetailLocation = this.moduleDetailXmlPath + this.prefix + moduleBundle.getSymbolicName() + ".xml";
			saxParser.parse(moduleDetailLocation, this.parserHandler);
			module = this.parserHandler.getGeneratedModule();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return module;
	}
	

}