package com.aspiration;

import com.aspiration.handlers.DirectoryHandler;

public class Application {
	public static void main(String[] args) {

		DirectoryHandler directoryHandler = new DirectoryHandler();
		directoryHandler.findAll("C:\\workspace\\testGit\\")
				.forEach(System.out::println);

	}
}