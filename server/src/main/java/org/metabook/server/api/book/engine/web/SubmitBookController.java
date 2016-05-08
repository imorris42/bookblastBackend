package org.metabook.server.api.book.engine.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.metabook.repository.book.Book;
import org.metabook.repository.service.BookService;
import org.metabook.repository.service.SubmitResponse.SingleBookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.DomainClassConverter;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Spring MVC controller to handle submit for a {@link Book}.
 * 
 * @author Ian Morris
 */
@Controller

@ExposesResourceFor(Book.class)
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SubmitBookController {
//	@Autowired
//		private @NonNull BookService bookService;
//	@Autowired
//		private @NonNull EntityLinks entityLinks;

		/**
		 * Accepts a book 
		 * @param <id>
		 * 
		 * @param order the {@link Book} to process the payment for. Retrieved from the path variable and converted into an
		 *          {@link Book} instance by Spring Data's {@link DomainClassConverter}. Will be {@literal null} in case no
		 *          {@link Book} with the given id could be found.
		 * 
		 * @return
		 */
		@RequestMapping(value = "/api/submit", method = PUT)
		ResponseEntity<BookResource> submitBook(@PathVariable("id") Book tittle, @RequestBody Book book) {

			if (book == null || book.getIsbn13() == null) {
				return new ResponseEntity<BookResource>(HttpStatus.NOT_FOUND);
			}

			//SingleBookResponse newBook = bookService.submitBook(book);

			BookResource resource = new BookResource("Thanks", null);
			//resource.add(entityLinks.linkToSingleResource(order));

			return new ResponseEntity<BookResource>(resource, HttpStatus.CREATED);
		}


		/**
		 * Resource implementation for book results.
		 * 
		 * @author Ian Morris
		 */
		@Data
		@EqualsAndHashCode(callSuper = true)
		static class BookResource extends ResourceSupport {

			private final String message;
			private final Book book;
		}
	}

