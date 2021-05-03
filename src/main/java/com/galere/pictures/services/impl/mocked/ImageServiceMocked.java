package com.galere.pictures.services.impl.mocked;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.io.FileSystemResource;

import com.galere.pictures.entities.Image;
import com.galere.pictures.repositories.impl.mocked.FileSystemRepositoryMocked;
import com.galere.pictures.services.IImageService;

/**
 * <b>
 * 	Mock du service IImageService.
 * </b>
 * 
 * @see IImageService
 * @see Image
 * 
 * @author Ilias HATTANE
 * @version 1.0
 *
 */
public class ImageServiceMocked {

    private FileSystemRepositoryMocked fileRepository;
	
	private ArrayList<Image> images = new ArrayList<Image>();
	
	public ArrayList<Image> getRepository() {
		return images;
	}

	DateFormat mediumDateFormat = DateFormat.getDateTimeInstance(
	        DateFormat.MEDIUM,
	        DateFormat.MEDIUM);
	
	public Image saveImage(Image img, byte[] content, String name) {
		try {
			String uniq = "";
			for (String part : new Date().toString().split(" "))
				uniq += part;
			uniq += "-" + name;
			
			uniq = verify(uniq);
			
			img.setUrl(fileRepository.save(content, uniq));
			img.setId(images.stream().count()+1);
			images.add(img);
			return img;
		} catch (Exception e) {e.printStackTrace();}
		
		return null;
	}

	private String verify(String uniq) {
		if (uniq.contains("\\"))
			uniq = uniq.replace("\\", "-");
		if (uniq.contains("/"))
			uniq = uniq.replace("/", "-");
		if (uniq.contains(":"))
			uniq = uniq.replace(":", "-");
		if (uniq.contains("*"))
			uniq = uniq.replace("*", "-");
		if (uniq.contains("?"))
			uniq = uniq.replace("?", "-");
		if (uniq.contains("\""))
			uniq = uniq.replace("\"", "-");
		if (uniq.contains("<"))
			uniq = uniq.replace("<", "-");
		if (uniq.contains(">"))
			uniq = uniq.replace(">", "-");
		if (uniq.contains("|"))
			uniq = uniq.replace("|", "-");
		return uniq;
	}

	public FileSystemResource findImage(Long id) {
		if (existsById(id))
			return fileRepository.findInFileSystem(findById(id).getUrl());
		return null;
	}
	
	private Image findById(Long id) {
		return images.parallelStream().filter(img -> img.getId().equals(id)).collect(Collectors.toList()).get(0);
	}
	
	private boolean existsById(Long id) {
		return images.stream().filter(img -> img.getId().equals(id)).count() > 0;
	}
	
	public boolean existsImage(String title) {
		return images.stream().filter(role -> role.getTitle().equalsIgnoreCase(title)).count() > 0;
	}
	
	public List<Image> searchByTags(String tags) {
		List<String> tagList = Arrays.asList(tags.split(" "));
		
		return images.stream().filter(
					i -> tagList.stream().filter(
									tag -> i.getTitle().contains(tag) ||
										   i.getId().toString().contains(tag) ||
										   i.getDescription().contains(tag) ||
										   i.getTags().contains(tag) ||
										   i.getContent().contains(tag) ||
										   i.getDate().toString().equalsIgnoreCase(tag) ||
										   i.getStringCategories().contains(tag)
										   
						).count() > 0
				).collect(Collectors.toList());
	}
	
}
