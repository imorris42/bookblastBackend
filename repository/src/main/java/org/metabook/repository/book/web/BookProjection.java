package org.metabook.repository.book.web;

//import java.time.LocalDateTime;

import org.metabook.repository.book.Book;
import org.springframework.data.rest.core.config.Projection;

/**
 * Projection interface to render {@link Book} summaries.
 * 
 * @author Ian Morris
 */
@Projection(name = "book", types = Book.class)
public interface BookProjection {

	/**
	 * @see Book#getIsbn13()
	 * @return
	 */
	String getIsbn13();
	
	String getMainTitle();
	
	String getSubTitle();
	
	String getPublisherName();
	
	String getAuthor();
	
	String getCategories();
	
	String getBriefDescription();
	
	String getCountryOfPublication();
	
	String getPublicationDate();
	
	String getPrintedIn();	
}
