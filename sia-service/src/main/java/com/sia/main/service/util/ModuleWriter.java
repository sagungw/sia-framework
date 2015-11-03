package com.sia.main.service.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.web.multipart.MultipartFile;

public class ModuleWriter {

	public void writeToDisk(MultipartFile file, String location) {
		try {
			File toBeWrittenFile = this.getFile(location, file.getOriginalFilename());
			byte[] bytes = file.getBytes();
			BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(toBeWrittenFile));
			outputStream.write(bytes);
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeToDisk(File file, String location) {
		try {
			File toBeWrittenFile = this.getFile(location, file.getName());
			byte[] bytes = Files.readAllBytes(file.toPath());
			BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(toBeWrittenFile));
			outputStream.write(bytes);
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public File getFile(String path, String fileName) {
		File directory = new File(path + File.separator);
		if (!directory.exists())
			directory.mkdirs();
		File file = new File(directory.getAbsoluteFile() + File.separator + fileName);
		return file;
	}
	
	public void deleteFromDisk(Path filePath) {
		try {
			Files.deleteIfExists(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
