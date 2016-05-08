package org.metabook.repository.service;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;
import org.metabook.repository.book.Book;
import org.metabook.repository.book.BookRepository;
import org.metabook.repository.service.SubmitResponse.SingleBookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Getter;
import lombok.Setter;
/**
 * Implementation of {@link BookService} delegating persistence operations to {@link BookRepository}
 * 
 * @author Ian Morris
 */


@Service
@Transactional
@Getter
@Setter
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BookServiceImpl implements BookService {
	
	@Autowired
	public BookRepository bookRepository;
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")//
	public LocalDateTime submitDate;

	public SingleBookResponse submitBook(Book book) {
		//book.setStatus
		bookRepository.save(book);

		SingleBookResponse response = new SingleBookResponse();
		//TODO
		/*
		response.date = LocalDateTime.now();
		response.message = "OK";
		response.book = null;
		*/
		return response;
	}

}
