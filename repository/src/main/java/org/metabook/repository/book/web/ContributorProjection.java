package org.metabook.repository.book.web;

//import java.time.LocalDateTime;

import org.metabook.repository.book.Contributor;
//import org.metabook.repository.book.Category.SimpleCategory;
import org.springframework.data.rest.core.config.Projection;

/**
 * Projection interface to render {@link Contributor} contributors.
 * 
 * @author Ian Morris
 */
@Projection(name = "summary", types = Contributor.class)
public interface ContributorProjection {

	/**
	 * @see Contributor#getFirstName()
	 * @return
	 */
	String getFirstName();

	/**
	 * @see Contributor#LastName()
	 * @return
	 */
	String getLastName();
}
