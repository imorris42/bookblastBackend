package org.metabook.repository.book;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.metabook.repository.core.MonetaryAmount.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.metabook.server.AbstractIntegrationTest;
import org.metabook.repository.core.MonetaryAmount;

/**
 * Integration tests for Spring Data based {@link CategoryRepository}.
 * 
 * @author Ian Morris
 */
public class CategoryRepositoryIntegrationTest extends AbstractIntegrationTest {

	@Autowired
	CategoryRepository repository;

	@Autowired
	BookRepository bookRepository;	

	@Autowired
	ContributorRepository contibutorRepository;
	
	@Test
	public void findsAllCategories() {
		BookInitializer fbi = new BookInitializer(bookRepository, contibutorRepository);
	
		Iterable<Category> categories = repository.findAll();
		assertThat(categories, is(Matchers.<Category> iterableWithSize(2)));
	}

	@Test
	public void createsNewCategory() {
		BookInitializer fbi = new BookInitializer(bookRepository, contibutorRepository);
		
		Book testBook = new Book("English breakfast", "123456789012");
		testBook.setFullDescription("abc");
		Category food = new Category(testBook);
		food.categoryTitle = "FOOD";//Category.SimpleCategory.KIDS;
		food.setDeNormalisedTitle("food");
		java.util.List<Category> cs = new ArrayList<Category>();
		cs.add(food);
		testBook.setCategories(cs);	
		bookRepository.save(testBook);
		Iterable<Category> result = repository.findAll();
		assertThat(result, is(Matchers.<Category> iterableWithSize(3)));
		assertThat(result, hasItem(food));
	}


}
