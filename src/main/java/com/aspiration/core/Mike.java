package com.aspiration.core;

import com.aspiration.handlers.DirectoryHandler;

public class Mike {

    public void integrate(String path) {
        if (DirectoryHandler.isPathValid(path + ".m1ke")) {

        } else {
            // first time
            String m1keDir = DirectoryHandler.createMikeDir(path);
            DirectoryHandler.createDir(m1keDir + "\\master");
        }

    }

    public void save() {
        System.out.println("m1ke save command executing...");
    }
    public void createBranch() {
        System.out.println("m1ke createBranch command executing...");
    }
    public void getBranch() {
        System.out.println("m1ke getBranch command executing...");
    }
    public void removeBranch() {
        System.out.println("m1ke removeBranch command executing...");
    }


}