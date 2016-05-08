/*
 * Copyright 2013 the original author or authors.
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

import java.util.Set;

import org.metabook.repository.book.Book;

/**
 * Exposes all books currently in progress.
 * 
 * @author Ian Morris
 */
public interface InProgressAware {

	/**
	 * Returns all {@link Order}s that currently prepared.
	 * 
	 * @return the {@link Order}s currently in preparation.
	 */
	Set<Book> getBooks();
}
