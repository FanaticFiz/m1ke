package com.aspiration.core;

import com.aspiration.enums.MikeCommand;
import com.aspiration.exceptions.MikeException;
import com.aspiration.exceptions.MikeParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInteract {
    private String[] args;
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public UserInteract(String params) {
        args = params.split(" ");
    }

    public void init() {
        try {
            args = input.readLine().split(" ");

            if ( !MikeCommandParser.isMikeCommand(args[0]) ) {
                System.out.println("Incorrect command.");
                printAvailableCommands();
                init();
            }

	        if ( !(args.length >= 2 && MikeCommandParser.isValidCommand(args[1])) ) {
		        throw new MikeParseException("Command could not be found");
	        }

	        if ( !MikeCommandParser.isCommandParamsValid(args) ) {
		        throw new MikeParseException("Wrong command parameters");
	        }

	        Mike mike = new Mike();
	        mike.executeCommand(args);

	        init();
        } catch (IOException e) {
            System.out.println("input error");
            init();
        } catch (MikeException e) {
            System.out.println(e.getMessage());
            init();
        }
    }

    private void printAvailableCommands() {
	    System.out.print("Please use: m1ke [");
        for (MikeCommand command: MikeCommand.values()) {
            System.out.print(command + ", ");
        }
	    System.out.println("]");
    }

}