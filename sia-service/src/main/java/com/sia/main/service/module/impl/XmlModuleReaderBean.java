package com.sia.main.service.module.impl;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.osgi.framework.Bundle;
import org.xml.sax.SAXException;

import com.sia.main.plugin.modul.Module;
import com.sia.main.service.module.OsgiModuleReader;

public class XmlModuleReaderBean implements OsgiModuleReader {

	private String moduleDetailXmlPath;

	private String prefix;
	
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

	@Override
	public Module readModule(Bundle moduleBundle, Bundle hostBundle) {
		Module module = null;
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			String moduleDetailLocation = this.moduleDetailXmlPath + this.prefix + moduleBundle.getSymbolicName() + ".xml";
			URL fileUrl = hostBundle.getResource(moduleDetailLocation);
			File file = new File(fileUrl.getFile().replace("file:/", ""));
			ModuleXmlParseHandler parseHandler = new ModuleXmlParseHandler();
			saxParser.parse(file.getCanonicalPath().replace("\\", "\\\\"), parseHandler);
			module = parseHandler.getGeneratedModule();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return module;
	}

}
