package org.metabook.repository.book.web;

//import java.time.LocalDateTime;

import org.metabook.repository.book.Category;
//import org.metabook.repository.book.Category.SimpleCategory;
import org.springframework.data.rest.core.config.Projection;

/**
 * Projection interface to render {@link Category} categories.
 * 
 * @author Ian Morris
 */
@Projection(name = "summary", types = Category.class)
public interface CategoryProjection {

	/**
	 * @see Category#getCreatedDate()
	 * @return
	 */
	//LocalDateTime getCreatedDate();

	/**
	 * @see Category#categoryTitle()
	 * @return
	 */
	String getCategoryTitle();
	
	//String getCategoryIString();
}
