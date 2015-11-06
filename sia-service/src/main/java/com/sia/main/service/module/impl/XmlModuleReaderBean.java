package com.sia.main.service.module.impl;

import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.osgi.framework.Bundle;
import org.xml.sax.SAXException;

import com.sia.main.plugin.modul.Module;
import com.sia.main.plugin.modul.impl.ServletBasedModule;
import com.sia.main.service.module.OsgiModuleReader;

public class XmlModuleReaderBean implements OsgiModuleReader {

	private String moduleDetailXmlPath;

	private String prefix;
	
	public void setModuleDetailXmlPath(String moduleDetailXmlPath) {
		this.moduleDetailXmlPath = moduleDetailXmlPath;
	}
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	@Override
	public Module readModule(Bundle moduleBundle, Bundle hostBundle) throws Exception {
		ServletBasedModule module = null;
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			String moduleDetailLocation = this.moduleDetailXmlPath + this.prefix + moduleBundle.getSymbolicName() + ".xml";
			URL fileUrl = hostBundle.getResource(moduleDetailLocation);
			if(fileUrl == null) {
				throw new NullPointerException("Berkas xml tidak ditemukan");
			}
			ModuleXmlParseHandler parseHandler = new ModuleXmlParseHandler();
			saxParser.parse(fileUrl.openStream(), parseHandler);
			module = (ServletBasedModule) parseHandler.getGeneratedModule();
		} catch (ParserConfigurationException | SAXException | IOException | NullPointerException e) {
			throw e.getClass().getDeclaredConstructor(String.class).newInstance("Pembacaan detail modul pada berkas xml gagal. Pesan Exception: " + e.getMessage());
		}
		return module;
	}

}
