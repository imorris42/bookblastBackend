package org.metabook.repository.book;

import java.util.ArrayList;
import java.util.Arrays;

import org.metabook.repository.book.Book;
import org.metabook.repository.book.BookContributor;
import org.metabook.repository.book.BookRepository;
import org.metabook.repository.book.Category;
import org.metabook.repository.book.Contributor;
import org.metabook.repository.core.MonetaryAmount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Initializer to set up two {@link Books}s.
 * 
 * @author Ian Morris
 */
@Service
class BookInitializer {

	/**
	 * Creates two books and persists them using the given {@link BookRepository}.
	 * 
	 * @param books must not be {@literal null}.
	 */
	@Autowired
	public BookInitializer(org.metabook.repository.book.BookRepository books, ContributorRepository contibutorRepository) {

		Assert.notNull(books, "BookRepository must not be null!");

		books.deleteAll();
		contibutorRepository.deleteAll();

		Book chipochino = new Book("Chipochino","1234567890");
		
		Media bookMedia = new Media(chipochino, MediaType.Image, "file:///afile.jpg");
		bookMedia.setFileFormat(FileFormat.JPG);
		bookMedia.setContentType(ContentType.FrontCover);
		java.util.List<Media> allMedia = new ArrayList<Media>();
		allMedia.add(bookMedia);
		chipochino.setMedia(allMedia);
		
		Book chopochino = new Book("Chopouchino","9876543210");
		Contributor alma = new Contributor("Alma", "Morris");
		BookContributor bc = new BookContributor(alma, "AUTHOR");
		//bc.setBook(chipochino);
		Category kids2 = new Category(chipochino);
		kids2.categoryTitle = "KIDART";//Category.SimpleCategory.KIDS;
		kids2.setDeNormalisedTitle("kidart");
		java.util.List<Category> cs = new ArrayList<Category>();
		cs.add(kids2);
		chipochino.setCategories(cs);
		java.util.List<BookContributor> bcs = new ArrayList<BookContributor>();
		bcs.add(bc);
		chipochino.setBookContributors(bcs);
		Category art = new Category(chopochino);
		art.categoryTitle = "ART";//Category.SimpleCategory.ART;
		art.setDeNormalisedTitle("art");
		java.util.List<Category> acs = new ArrayList<Category>();
		acs.add(art);
		Contributor maud = new Contributor("Maud", "Morris");
		BookContributor mbc = new BookContributor(maud, "AUTHOR");
		
		chopochino.setCategories(acs);
		//mbc.setBook(chopochino);
		
		java.util.List<BookContributor> mbcs = new ArrayList<BookContributor>();
		mbcs.add(mbc);
		chopochino.setBookContributors(mbcs);
        


		books.save(Arrays.asList(chipochino, chopochino));
	}
}
