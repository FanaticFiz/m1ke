package com.aspiration.handlers;

import lombok.extern.log4j.Log4j;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Log4j
public class DirectoryHandler {
	private List<String> foundFiles = new ArrayList<>();
	static String exceptionDir = ".m1ke";

	public List<String> findAllFiles(String path) {
		log.debug("Try find files in: " + path);

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
					foundFiles.add(path + File.separator + file.getName());
				} else {
					log.debug(file.getName() + " is a directory");
					if (!exceptionDir.equals(file.getName())) {
						findAllFiles(path + File.separator + file.getName());
					}
				}
			}
		} else {
			log.info("empty or wrong directory");
		}
		return foundFiles;
	}

	public List<String> difference(List<String> firstFiles, List<String> secondFiles) {
		log.debug("Try find difference");

		List<String> result = new ArrayList<>();
		for (String firstItem: firstFiles) {
			if (!secondFiles.contains(firstItem)) {
				result.add(firstItem);
			}
		}

		for (String secondItem: secondFiles) {
			if (!firstFiles.contains(secondItem)) {
				result.add(secondItem);
			}
		}

		return result;
	}

	public static boolean isPathValid(String path) {
		return new File(path).exists();
	}

	public static String createDir(String path) {
		log.debug("Try create directory by: " + path);
		File file = new File(path);

		try {
			file.mkdir();
		} catch (Exception e) {
			log.warn("Wrong path");
		}
		return file.getPath();
	}

	public static String createMikeDir(String path) {
		log.debug("Try create '.m1ke' directory by: " + path);
		return createDir(path + exceptionDir);
	}

	public static boolean removeDir(String path) {
		return new File(path).delete();
	}
}