package org.metabook.repository.service;



import org.metabook.repository.book.Book;

import lombok.Value;


public class SubmitResponse {
	/**
	 * A response for an {@link Book} and a payment date.
	 * 
	 * @author Ian Morris
	 */
	@Value
	public static class SingleBookResponse {

/*		private final LocalDateTime date = null;
		private final String message = null;
		private final Book book = null;*/
		public org.joda.time.LocalDateTime date = null;
		public String message = null;
		public Book book = null;		
		
	}
}
