package com.galere.pictures.repositories.impl.mocked;


import java.io.File;
import java.io.FileOutputStream;

import org.springframework.core.io.FileSystemResource;

/**
 * <b>
 * 	Class représentant le repository chargé de stoquer et retrouver les images sur la machine Mocké.
 * </b>
 * 
 * @see FileSystemResource
 * @see File
 * 
 * @author Ilias HATTANE
 * @version 1.0
 *
 */
public class FileSystemRepositoryMocked {
	
	String RESOURCES_DIR = FileSystemRepositoryMocked.class.getResource("/").getPath();
	
    public String save(byte[] content, String imageName) throws Exception {
    	        
        File f = new File(RESOURCES_DIR);
        
        if (!f.exists())
        	f.mkdirs();
        
        f = new File(RESOURCES_DIR + imageName);
        System.out.println(f.getPath());
        f.createNewFile();
        
        FileOutputStream fo = new FileOutputStream(f);
        fo.write(content);
        fo.flush();
        fo.close();

        return f.getAbsolutePath().toString();
        
    }
    
    public FileSystemResource findInFileSystem(String location) {
        try {
            return new FileSystemResource(new File(location));
        } catch (Exception e) {throw new RuntimeException();}
    }
	
}
