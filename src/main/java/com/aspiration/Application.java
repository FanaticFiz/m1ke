package com.aspiration;

import com.aspiration.core.UserInteract;

public class Application {
	public static void main(String[] args) {

		if (args[0].length() == 0) {
			System.out.println("Please enter command...");
		}

        UserInteract cliReader = new UserInteract(args[0].trim());
        cliReader.init();

	}

}