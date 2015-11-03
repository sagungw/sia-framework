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
import com.sia.main.service.util.ModuleWriter;

public class XmlModuleReaderBean implements OsgiModuleReader {

	private String moduleDetailXmlPath;

	private String prefix;
	
	private String moduleLocation;
	
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

	public String getModuleLocation() {
		return moduleLocation;
	}

	public void setModuleLocation(String moduleLocation) {
		this.moduleLocation = moduleLocation;
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
			ModuleWriter moduleWriter = new ModuleWriter();
			moduleWriter.writeToDisk(file, this.moduleLocation);
			ModuleXmlParseHandler parseHandler = new ModuleXmlParseHandler();
			System.out.println(this.moduleLocation + File.separator + file.getName());
			saxParser.parse(this.moduleLocation + File.separator + file.getName(), parseHandler);
			module = parseHandler.getGeneratedModule();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return module;
	}

}
