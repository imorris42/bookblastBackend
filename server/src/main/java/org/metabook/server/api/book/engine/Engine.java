/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.metabook.server.api.book.engine;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import org.metabook.repository.book.BookRepository;
import org.metabook.server.api.book.BookCommentEvent;
import org.metabook.server.api.book.engine.InProgressAware;
import org.metabook.repository.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


/**
 * Simple {@link ApplicationListener} implementation that listens to {@link OrderPaidEvent}s marking the according
 * {@link Order} as in process, sleeping for 10 seconds and marking the order as processed right after that.
 * 
 * @author Ian Morris
 */
@Slf4j
@Service
@Component
//@AllArgsConstructor(onConstructor = @__(@Autowired))
class Engine implements ApplicationListener<BookCommentEvent>, InProgressAware {

	@Autowired
	private @NonNull BookRepository repository;
	
	@Autowired
	public Engine(BookRepository repository) {
	this.repository = repository;	
	}
	
	private final Set<Book> allBooks = Collections.newSetFromMap(new ConcurrentHashMap<Book, Boolean>());

	/*
	 * (non-Javadoc)
	 * @see org.springsource.restbucks.engine.InProgressAware#getOrders()
	 */
	@Override
	public Set<Book> getBooks() {
		return allBooks;
	}

	/* 
	 * (non-Javadoc)
	 * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
	 */
	@Async
	@Override
	public void onApplicationEvent(BookCommentEvent event) {

		Book fullBook = repository.findOne(event.getBookId());
		//fullBook.markInPreparation();
		//order = repository.save(order);

		allBooks.add(fullBook);

		log.info("Starting to process book {}.", fullBook);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		//fullBook.markPrepared();
		repository.save(fullBook);

		allBooks.remove(fullBook);

		log.info("Finished processing book {}.", fullBook);
	}
}
