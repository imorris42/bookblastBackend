package org.metabook.repository.book;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.metabook.repository.core.MonetaryAmount.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hamcrest.Matchers;
import org.hibernate.dialect.FirebirdDialect;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.metabook.server.AbstractIntegrationTest;
import org.metabook.repository.core.MonetaryAmount;

/**
 * Integration tests for Spring Data based {@link CategoryRepository}.
 * 
 * @author Ian Morris
 */
public class BookRepositoryIntegrationTest extends AbstractIntegrationTest {


	@Autowired
	BookRepository bookRepository;

	@Autowired
	ContributorRepository contibutorRepository;
	
	
	@Test
	public void deleteAll() {
		Assert.notNull(bookRepository, "BookRepository must not be null!");

		bookRepository.deleteAll();

		Iterable<Book> result = bookRepository.findAll();
		assertThat(result, is(Matchers.<Book> iterableWithSize(0)));
	}
	
	@Test
	public void findsAllBooks() {
		
		BookInitializer fbi = new BookInitializer(bookRepository,contibutorRepository);
		
		Iterable<Book> books = bookRepository.findAll();
		assertThat(books, is(Matchers.<Book> iterableWithSize(2)));
		
		Book testBook = new Book("English breakfast","123456789012");
		testBook.setFullDescription("abc");
		Category tbc = new Category(testBook);
		tbc.setCategoryTitle("MUSIC");
		List<Category> lc = new ArrayList<Category>();
		lc.add(tbc);
		
		Book book = bookRepository.save(testBook);

		Iterable<Book> result = bookRepository.findAll();
		assertThat(result, is(Matchers.<Book> iterableWithSize(3)));
		assertThat(result, hasItem(book));
		
		Book chip = bookRepository.findByISBN("1234567890");
		//assertThat(chip.getCategories().get(0).categoryTitle, is("ART"));
		assertThat(chip.getBookContributors().get(0).getContributor().getFirstName(), is("Alma"));
	}
	
	@Test
	public void bookMediaTest() {
		
/*		BookInitializer fbi = new BookInitializer(bookRepository,contibutorRepository);
		
		Iterable<Book> books = bookRepository.findAll();
		assertThat(books, is(Matchers.<Book> iterableWithSize(2)));
		*/
		Book testBook = new Book("Eurostar Trains","123456789013");
		testBook.setFullDescription("A book on trains");
		Media bookMediaFront = new Media(testBook, MediaType.Image, "file:///train.jpg");
		bookMediaFront.setFileFormat(FileFormat.JPG);
		bookMediaFront.setContentType(ContentType.FrontCover);
		
		Media bookMediaBack = new Media(testBook, MediaType.Image, "file:///trainBack.jpg");
		bookMediaBack.setFileFormat(FileFormat.JPG);
		bookMediaBack.setContentType(ContentType.BackCover);
		
		java.util.List<Media> allMedia = new ArrayList<Media>();
		allMedia.add(bookMediaFront);
		allMedia.add(bookMediaBack);
		testBook.setMedia(allMedia);
		
		Category tbc = new Category(testBook);
		tbc.setCategoryTitle("TRAIN");
		List<Category> lc = new ArrayList<Category>();
		lc.add(tbc);
		
		Book book = bookRepository.save(testBook);

		Iterable<Book> result = bookRepository.findAll();
		assertThat(result, is(Matchers.<Book> iterableWithSize(3)));
		assertThat(result, hasItem(book));
		
		Book testBookRetrieved = bookRepository.findByISBN("123456789013");
		//assertThat(chip.getCategories().get(0).categoryTitle, is("ART"));
		
		assertThat(testBookRetrieved.getMedia().get(0).getFileFormat(), is(FileFormat.JPG));
		assertThat(testBookRetrieved.getMedia().get(1).getFileFormat(), is(FileFormat.JPG));
	}
	
	@Test
	public void findsABookByISBN() {
	 BookInitializer fbi = new BookInitializer(bookRepository, contibutorRepository);
	
		Iterable<Book> books = bookRepository.findAll();
		assertThat(books, is(Matchers.<Book> iterableWithSize(2)));
		
		Book testBook = new Book("English breakfast", "123456789013");
		testBook.setFullDescription("abc");

		Contributor ian = new Contributor("Ian", "Morris");
		ian.setFirstName("Ian");
		ian.setLastName("Morris");
		//contibutorRepository.save(ian);
        BookContributor bbc = new BookContributor(ian, "AUTHOR");
        bbc.setRole("AUTHOR");
        //bbc.setBook(testBook);
    
        List<BookContributor> setOfBBC = new ArrayList<BookContributor>();
        setOfBBC.add(bbc);
        testBook.setBookContributors(setOfBBC);
        bbc.setContributor(ian);
		Book book = bookRepository.save(testBook);

		Book result = bookRepository.findByISBN("123456789013");
		assertEquals(result.getMainTitle(),"English breakfast");
		assertEquals(result.getBookContributors().iterator().next().getContributor().getFirstName(),"Ian");
		
		
	}
}
