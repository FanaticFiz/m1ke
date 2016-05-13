package com.aspiration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInteract {
    private MikeCli cli;
    private String[] args;

    public UserInteract(String params) {
        cli = new MikeCli();
        args = params.split(" ");
    }

    public void init() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = "";

        try {
            line = input.readLine();
            args = line.split(" ");

            if (isMikeCommand(args[0])) {
                System.out.println("IS MIKE COMMAND");
                cli.parse(args);
                init();
            } else {
                System.out.println("command not found");
                init();
            }

        } catch (IOException e) {
            System.out.println("input error");
            init();
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            init();
        }

    }

    public boolean isMikeCommand(String param) {
        return "m1ke".equals(param);
    }


}
