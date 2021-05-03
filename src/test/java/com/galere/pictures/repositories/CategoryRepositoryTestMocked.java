package com.galere.pictures.repositories;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.galere.pictures.entities.Category;
import com.galere.pictures.services.impl.mocked.CategoryServiceMocked;

@SpringBootTest
class CategoryRepositoryTestMocked {
	
	private final static Logger log = LoggerFactory.getLogger(CategoryRepositoryTestMocked.class);
		
	private CategoryServiceMocked service = new CategoryServiceMocked();
	
	@BeforeEach
	void setup() {
		log.trace("Tests : Lancement 'Role'...");
		log.trace("");
		assertNotNull(service, "Le repository n'a pas été initialisé !");
	}
	
	@Test
	@DisplayName("Find All categories")
	void findAllCategories() {
		
		log.trace("  [Lancement Test] -> findAllCategories()");

		List<Category> categories = service.getRepository();
		
		log.trace("  |  Roles trouvés : {}", categories.size());	
		categories.forEach(cat -> log.trace("  |     - {}", cat.toString()));
		
		assertTrue(categories != null);
		assertTrue(categories.size() == 2);
		
		log.trace("  [Fin Test]");
		log.trace("");

	}
	
	@Test
	@DisplayName("Search Categories")
	void searchCategories() {
		
		log.trace("  [Lancement Test] -> searchCategories()");
		
		List<Category> searchLabel = service.searchByTags("Art");
		List<Category> searchId = service.searchByTags("2");
		
		assertTrue(searchLabel != null);
		assertTrue(searchLabel.size() == 1);
		
		assertTrue(searchId != null);
		assertTrue(searchId.size() == 1);
		
		log.trace("  [Fin Test]");
		log.trace("");

	}
	
	@Test
	@DisplayName("Exists Category")
	void existsCategory() {
		
		log.trace("  [Lancement Test] -> existsCategory()");
		
		Category cat = new Category();
		cat.setLabel("hello");
		service.getRepository().add(cat);
		
		assertTrue(service.existsCategory("hello"));
		
		log.trace("  [Fin Test]");
		log.trace("");

	}
	
	@AfterEach
	void end() {
		log.trace("Fin Test");
	}
	
}
