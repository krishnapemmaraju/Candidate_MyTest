package com.test.utils;

import java.io.FileInputStream;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import javax.naming.CommunicationException;
import java.io.File;
import java.io.IOException;

public class FileUtilities {
	
	 private static final String CUR_DIR = System.getProperty("user.dir");
	    private static final String FILE_SEPERATOR = System.getProperty("file.separator");
	    String userHome = System.getProperty("user.home");

	    public boolean isFileExist(String filePath) {
	        File f = new File(filePath);
	        if(f.exists()) return true;
	        else return false;

	    }

	    public String getCurrentDir() {
	        String currentDir = System.getProperty("user.dir");
	        return currentDir;
	    }

	    /* Processing the payload
	       Get the Payload from the Path
	       Add the params - by creating a List list [ list.add(\\$\\{emp\\} ]
	       replace with the parameters and add to another list
	       Store the body into another String and replace this with the body to post request
	     */
	    @SuppressWarnings("deprecation")
	    public String modifyFile(String filePath, List<String> oldVal, List<String> newVal) throws IOException, CommunicationException, IOException {
	        String modify;
	        if(oldVal.size()==newVal.size()) {
	            FileInputStream fileInputStream = new FileInputStream(new File(filePath));
	            modify= IOUtils.toString(fileInputStream,"UTF-8");
	            for(int i=0;i<oldVal.size();i++) {
	                modify= StringUtils.replaceAll(modify,oldVal.get(i), newVal.get(i));}
	            return modify;
	        }
	        else throw new CommunicationException("Could not match the old val list size with the new val size. old values list should be same size as new value list.");
	    }

}
