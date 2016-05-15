package com.aspiration.core;

import com.aspiration.enums.MikeCommand;
import com.aspiration.exceptions.MikeParseException;
import com.aspiration.handlers.BranchHandler;
import com.aspiration.handlers.DirectoryHandler;
import lombok.extern.log4j.Log4j;

@Log4j
public class Mike {
    private BranchHandler branchHandler = new BranchHandler();
    private MikeCommand command;

    public void executeCommand(final String[] commandLineArgs) throws MikeParseException {
        log.debug("Mike try exetute command: " + commandLineArgs[1]);

        command = MikeCommand.getCommand(commandLineArgs[1]);
        switch (command) {
            case INTEGRATE:        integrate(commandLineArgs[2]);  break;
            case SAVE:             save();              break;
            case CREATE_BRANCH:    createBranch();      break;
            case GET_BRANCH:       getBranch();         break;
            case REMOVE_BRANCH:    removeBranch();      break;
            case QUIT:             System.exit(0);      break;
        }
    }

    private void integrate(String path) {
        if (DirectoryHandler.isPathValid(path + ".m1ke")) {

        } else {
            // first time
            String m1keDir = DirectoryHandler.createMikeDir(path);
            branchHandler.setWorkingPath(path);
            branchHandler.createBranch("master");
        }

    }

    private void save() {
        System.out.println("m1ke save command executing...");
    }
    private void createBranch() {
        System.out.println("m1ke createBranch command executing...");
    }
    private void getBranch() {
        System.out.println("m1ke getBranch command executing...");
    }
    private void removeBranch() {
        System.out.println("m1ke removeBranch command executing...");
    }

}