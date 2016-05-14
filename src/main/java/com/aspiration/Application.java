package com.aspiration;

import com.aspiration.handlers.DirectoryHandler;

public class Application {
	public static void main(String[] args) {
        UserInteract cliReader = new UserInteract(args[0].trim());
        cliReader.init();
    }

}