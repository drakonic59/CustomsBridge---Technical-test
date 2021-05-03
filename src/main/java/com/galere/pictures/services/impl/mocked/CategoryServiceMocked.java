package com.galere.pictures.services.impl.mocked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.galere.pictures.entities.mocked.Category;
import com.galere.pictures.services.ICategoryService;

/**
 * <b>
 * 	Mock du service ICategoryService.
 * </b>
 * 
 * @see ICategoryService
 * @see Category
 * 
 * @author Ilias HATTANE
 * @version 1.0
 *
 */
public class CategoryServiceMocked {

	private ArrayList<Category> categories;
	
	public CategoryServiceMocked() {
		categories = new ArrayList<Category>();
		
		Category c = new Category();
		c.setId(1L);
		c.setLabel("Art");
		categories.add(c);
		
        c = new Category();
        c.setId(2L);
        c.setLabel("Contemporain");
        categories.add(c);
	}
	
	public ArrayList<Category> getRepository() {
		return categories;
	}

	public boolean existsCategory(String label) {
		return categories.stream().filter(cat -> cat.getLabel().equalsIgnoreCase(label)).count() > 0;
	}

	public List<Category> searchByTags(String tags) {
		List<String> tagList = Arrays.asList(tags.split(" "));
		
		return categories.stream().filter(
					c -> tagList.stream().filter(
									tag -> c.getLabel().contains(tag) ||
										   c.getId().toString().contains(tag)
						).count() > 0
				).collect(Collectors.toList());
	}
	
}
