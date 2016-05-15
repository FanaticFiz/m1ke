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
    private String workingDir;

    public void executeCommand(final String[] commandLineArgs) throws MikeParseException {
        log.debug("Mike try execute command: " + commandLineArgs[1]);

        command = MikeCommand.getCommand(commandLineArgs[1]);
        switch (command) {
            case INTEGRATE:        integrate(commandLineArgs[2]);       break;
            case SAVE:             save();                              break;
            case CREATE_BRANCH:    createBranch();                      break;
            case GET_BRANCH:       getBranch();                         break;
            case REMOVE_BRANCH:    removeBranch(commandLineArgs[2]);    break;
            case QUIT:             System.exit(0);                      break;
        }
    }

    private void integrate(String path) {
        workingDir = DirectoryHandler.checkDirSeparator(path);
        String fullPath = DirectoryHandler.checkDirSeparator(workingDir) + ".m1ke";

        if (DirectoryHandler.isPathValid(fullPath)) {

        } else {
            // first time
            String m1keDir = DirectoryHandler.createMikeDir(workingDir);
            branchHandler.setWorkingPath(workingDir);
            branchHandler.createBranch("master");

            System.out.println();
            System.out.println("m1ke found there was no branch here");
            System.out.println("'master' branch created and choose");
            System.out.println();
        }
    }

    private void removeBranch(String branchName) {
        if (workingDir != null) {
            String fullPath = DirectoryHandler.checkDirSeparator(workingDir + DirectoryHandler.exceptionDir) + branchName;
            if (branchHandler.removeBranch(fullPath)) {
                System.out.println("Branch " + branchName + " success removed");
            } else {
                System.out.println("Can't remove branch...");
            }
        } else {
            System.out.println("For begin connect to directory.");
            System.out.println("Use command: " + MikeCommand.INTEGRATE);
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

    public String getWorkingDir() {
        return workingDir;
    }

    public void setWorkingDir(String workingDir) {
        this.workingDir = workingDir;
    }
}