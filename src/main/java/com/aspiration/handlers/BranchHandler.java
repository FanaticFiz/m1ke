package com.aspiration.handlers;

import java.io.File;
import java.util.List;

public class BranchHandler {
    private List<File> branchDirectories;
    private String workingPath;
    // TODO do we need to map directories to the filelist? or do we save them?

    public BranchHandler(String workingPath) {
        this.workingPath = workingPath;
    }

    public void save() {
        // ?
    }

    public void createBranch(String branchName) {
        DirectoryHandler.createDir(checkDirSeparator(branchName));
        // anything else to do?
    }

    public File getBranch(String branchName) {
        for (File fileItem : branchDirectories) {
            if (fileItem.getName().equals(branchName)) {
                return fileItem;
            }
        }
        // better solutions instead of returning null?
        return null;
    }

    public boolean removeBranch(String branchName) {
        return DirectoryHandler.removeDir(branchName);
    }

    public void findAll(String path) {
        File branchDir = new File(checkDirSeparator(path) + ".m1ke");
        File[] files = null;

        if (branchDir.exists()) {
            files = branchDir.listFiles();
        }

        if (files != null) {
            for (File fileItem : files) {
                if(fileItem.isDirectory()) {
                    branchDirectories.add(fileItem);
                }
            }
        } else {
            // What to do?
            System.out.println("");
        }

    }

    public boolean isValidBranch(String branchName) {
        if (branchDirectories == null) {
            findAll(workingPath);
        }

        return branchDirectories.contains(branchName);
    }

    private String checkDirSeparator(String path) {
        String separator = System.getProperty("path.separator)");
        if (path.endsWith(separator)) {
            return path;
        } else {
            return path + separator;
        }
    }

    public List<File> getBranchDirectories() {
        return branchDirectories;
    }
}
