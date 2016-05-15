package com.aspiration.core;

import com.aspiration.enums.MikeCommand;
import com.aspiration.exceptions.MikeException;
import com.aspiration.exceptions.MikeParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInteract {
    private MikeCli cli;
    private String[] args;
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public UserInteract(String params) {
        cli = new MikeCli();
        args = params.split(" ");
    }

    public void init() {
        try {
            args = input.readLine().split(" ");

            if (isMikeCommand(args[0])) {
                cli.executeCommand(args);
                init();
            } else {
                System.out.println("Incorrect command.");
                System.out.print("Please use: m1ke [");
                printAvailableCommands();
                System.out.println("]");
                init();
            }
        } catch (IOException e) {
            System.out.println("input error");
            init();
        } catch (MikeException e) {
            System.out.println(e.getMessage());
            init();
        }

    }

    private void printAvailableCommands() {
        for (MikeCommand command: MikeCommand.values()) {
            System.out.print(command + ", ");
        }
    }

    private boolean isMikeCommand(String param) {
        return "m1ke".equals(param);
    }



}