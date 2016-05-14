package com.aspiration.core;

import com.aspiration.enums.MikeCommand;
import com.aspiration.exceptions.ParseException;
import com.aspiration.handlers.DirectoryHandler;

public class MikeCli {
    private String[] args;
    private MikeCommand command;

    public void executeCommand(final String[] commandLineArgs) throws ParseException {
        args = commandLineArgs;

        if (args.length >= 2 && isValidCommand(args[1])) {
            command = MikeCommand.getCommand(args[1]);
            if (isCommandParamsValid()) {
                //executeCommand
                Mike mike = new Mike();
                switch (command) {
                    case INTEGRATE:        mike.integrate();         break;
                    case SAVE:             mike.save();              break;
                    case CREATE_BRANCH:    mike.createBranch();      break;
                    case GET_BRANCH:       mike.getBranch();         break;
                    case REMOVE_BRANCH:    mike.removeBranch();      break;
                    case QUIT:             System.exit(0);           break;
                }
            } else {
                System.out.println("Wrong command parameters");
            }
        } else {
            throw new ParseException("Command could not be found");
        }

    }

    private boolean isValidCommand(String command) {
        return MikeCommand.containsCommand(command);
    }

    private boolean isOption(String token) {
        return token.startsWith("-") && token.length() >= 2; //&& options.hasShortOption(token.substring(1, 2));
    }

    private boolean isCommandParamsValid() {
        if (command == MikeCommand.INTEGRATE
                && args.length >= 3
                && DirectoryHandler.isPathValid(args[2])) {
            return true;
        }

        return false;
    }
}