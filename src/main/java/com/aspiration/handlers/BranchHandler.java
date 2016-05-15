package com.aspiration.handlers;

import lombok.extern.log4j.Log4j;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Log4j
public class BranchHandler {
    private List<File> branchDirectories;
    private String workingPath;
    // TODO do we need to map directories to the filelist? or do we save them?

    public void save() {
        // ?
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

    public boolean removeBranch(String fullPath) {
        return DirectoryHandler.removeDir(fullPath);
    }

    public void findAll(String path) {
        File branchDir = new File(File.separator + ".m1ke");
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

    public List<File> getBranchDirectories() {
        return branchDirectories;
    }

	public void setWorkingPath(String workingPath) {
		this.workingPath = workingPath;
	}

	public void createBranch(String sourcePath, String branchName) {
		String fullPath = DirectoryHandler.checkDirSeparator(workingPath + DirectoryHandler.exceptionDir) + branchName;
		log.debug("Create branch: " + fullPath);
		String destinationDir = DirectoryHandler.createDir(fullPath);

		try {
			DirectoryHandler.copyFolder(
					new File(sourcePath),
					new File(destinationDir));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setBrenchAsCurrent(String branchName) {

	}
}
