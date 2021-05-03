package com.galere.pictures.services.impl;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

import com.galere.pictures.entities.Image;
import com.galere.pictures.repositories.FileSystemRepository;
import com.galere.pictures.repositories.ImageRepository;
import com.galere.pictures.services.IImageService;

/**
 * <b>
 * 	Implémentation du service IImageService.
 * </b>
 * 
 * @see IImageService
 * @see Image
 * 
 * @author Ilias HATTANE
 * @version 1.0
 *
 */
@Service
public class ImageServiceImpl implements IImageService {

	/**
	 * <b> Instance du repository FileSystemRepository. </b>
	 * 
	 * @see FileSystemRepository
	 */
	@Autowired
    private FileSystemRepository fileRepository;
	
	/**
	 * <b> Instance du repository ImageRepository. </b>
	 * 
	 * @see ImageRepository
	 */
	@Autowired
	private ImageRepository repository;
	
	@Override
	public ImageRepository getRepository() {
		return repository;
	}

	DateFormat mediumDateFormat = DateFormat.getDateTimeInstance(
	        DateFormat.MEDIUM,
	        DateFormat.MEDIUM);
	
	@Override
	public Image saveImage(Image img, byte[] content, String name) {
		try {
			String uniq = "";
			for (String part : new Date().toString().split(" "))
				uniq += part;
			uniq += "-" + name;
			
			uniq = verify(uniq);
			
			img.setUrl(fileRepository.save(content, uniq));
			return getRepository().save(img);
		} catch (Exception e) {e.printStackTrace();}
		
		return null;
	}

	/**
	 * <b> 
	 * 	Vérifier que la la chaine de carractères passée en paramètre ne contient aucun carractère interdit
	 * 	dans un nom de fichier. Si la chaine contient des carractères interdits, ils seront remplacés par des
	 * 	tirets.
	 * </b>
	 * 
	 * @param uniq La chaine de carractères à vérifier.
	 * @return La chaine de carractères avec les carractères interdits remplacés par des tirets.
	 */
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

	@Override
	public FileSystemResource findImage(Long id) {
		if (getRepository().existsById(id))
			return fileRepository.findInFileSystem(getRepository().findById(id).get().getUrl());
		return null;
	}
	
	@Override
	public boolean existsImage(String title) {
		return getRepository().findAll().stream().filter(role -> role.getTitle().equalsIgnoreCase(title)).count() > 0;
	}
	
	@Override
	public List<Image> searchByTags(String tags) {
		List<String> tagList = Arrays.asList(tags.split(" "));
		
		return getRepository().findAll().stream().filter(
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
