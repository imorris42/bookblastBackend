package org.metabook.repository.service;

import org.metabook.repository.book.Book;
import org.metabook.repository.service.SubmitResponse.SingleBookResponse;
import org.springframework.stereotype.Service;

@Service

public interface BookService {
	

	/**
	 * Takes the book
	 * 
	 * @param book
	 * @return
	 */
	public org.metabook.repository.service.SubmitResponse.SingleBookResponse submitBook(Book book);
	

}
