package com.aspiration;

import java.util.*;

public class MikeCli {
    private String[] args;

    public void parse(final String[] commandLineArgs) throws ParseException {
        args = commandLineArgs;

        if (isValidCommand(args[1])) {
            executeCommand();
        } else {
            throw new ParseException("command could not be found");
        }
    }

    private void executeCommand() {
        MikeCommand command = MikeCommand.getCommand(args[1]);
        Mike mike = new Mike();

        switch (command) {
            case INTEGRATE:        mike.integrate();         ; break;
            case SAVE:             mike.save();              ; break;
            case CREATE_BRANCH:    mike.createBranch();      ; break;
            case GET_BRANCH:       mike.getBranch();         ; break;
            case REMOVE_BRANCH:    mike.removeBranch();      ; break;
            case QUIT:                                       ; break;
        }
    }

    private boolean isValidCommand(String command) {
        return MikeCommand.containsCommand(command);
    }

    private boolean isOption(String token) {
        return token.startsWith("-") && token.length() >= 2; //&& options.hasShortOption(token.substring(1, 2));
    }
}
