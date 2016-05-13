package com.aspiration;

public enum MikeCommand {
    INTEGRATE("integrate"),
    SAVE("save"),
    CREATE_BRANCH("create-branch"),
    GET_BRANCH("get-branch"),
    REMOVE_BRANCH("remove-branch"),
    QUIT("quit");

    private String name;

    MikeCommand(String comand) {
        this.name = comand;
    }

    public static boolean containsCommand(String cmd) {
        for (MikeCommand command : values()) {
            if (cmd.equals(command.name)) return true;
        }
        return false;
    }

    public static MikeCommand getCommand(String cmd) {
        for (MikeCommand command : values()) {
            if (cmd.equals(command.name)) {
                return command;
            }
        }
        return null;
    }
}
