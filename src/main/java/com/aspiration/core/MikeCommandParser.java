package com.aspiration.core;

import com.aspiration.enums.MikeCommand;
import com.aspiration.handlers.DirectoryHandler;

public class MikeCommandParser {

    public static boolean isMikeCommand(String param) {
        return "m1ke".equals(param);
    }

    public static boolean isValidCommand(String command) {
        return MikeCommand.containsCommand(command);
    }

    public boolean isOption(String token) {
        return token.startsWith("-") && token.length() >= 2;
    }

    public static boolean isCommandParamsValid(String[] args) {
        MikeCommand command = MikeCommand.getCommand(args[1]);
        if (command == MikeCommand.INTEGRATE
                && args.length >= 3
                && DirectoryHandler.isPathValid(args[2])) {
            return true;
        }

        if (command == MikeCommand.REMOVE_BRANCH
                && args.length >= 3
                && DirectoryHandler.isPathValid(args[2])
                && args[2].contains(".m1ke")) {
            return true;
        }

        if (command == MikeCommand.QUIT) return true;
        return false;
    }

}