package com.aspiration.handlers;

import lombok.Data;
import lombok.extern.log4j.Log4j;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Data
@Log4j
public class DirectoryHandler {
	private String path;

	public List<String> findAll(String path) {
		log.info("Try find files in: " + path);

		List<String> foundFiles = new ArrayList<>();
		File[] files = null;
		try {
			File file = new File(path);
			files = file.listFiles();
		} catch (Exception e) {
			log.warn("Wrong path");
		}

		if (files != null) {
			log.debug("Found " + files.length + " items");
			for (File file : files) {
				if (file.isFile()) {
					log.debug("Found file: " + file.getName());
					foundFiles.add(path + "\\" + file.getName());
				} else {
					log.debug(file.getName() + " is a directory");
					findAll(path + "\\" + file.getName());
				}
			}
		} else {
			log.info("empty or wrong directory");
		}
		return foundFiles;
	}

}