package com.aspiration;

import java.io.IOException;

public class Application {
	public static void main(String[] args) {
        UserInteract cliReader = new UserInteract(args[0].trim());
        cliReader.init();
    }

}