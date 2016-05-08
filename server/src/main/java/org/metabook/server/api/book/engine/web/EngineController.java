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
package org.metabook.server.api.book.engine.web;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.metabook.repository.book.BookRepository;
import org.metabook.server.api.book.engine.InProgressAware;
import org.metabook.server.api.book.engine.web.EngineController;
import org.metabook.repository.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Custom controller to show how to expose a custom resource into the root resource exposed by Spring Data REST.
 * 
 * @author Ian Morris
 */
@Controller
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
//@RequestMapping("/api/main")

public class EngineController implements ResourceProcessor<RepositoryLinksResource> {

	public static final String ENGINE_REL = "engine";
	public static final String PAGES_REL = "pages";

	@Autowired
	private @NonNull InProgressAware processor;
	@Autowired
	private @NonNull BookRepository repository;

	/**
	 * Exposes all {@link Order}s currently in preparation.
	 * 
	 * @return
	 */
	@RequestMapping("/api/engine")
	HttpEntity<Resources<Resource<Book>>> showBooksInProgress() {

		Resources<Resource<Book>> bookResources = Resources.wrap(processor.getBooks());
		bookResources.add(linkTo(methodOn(EngineController.class).showBooksInProgress()).withSelfRel());

		return new ResponseEntity<>(bookResources, HttpStatus.OK);
	}

	/**
	 * An additional resource exposing paged {@link Order}s to show the usage of both {@link Pageable} and
	 * {@link PagedResourcesAssembler} in controller methods. Both arguments are resolved through infrastructure
	 * components registered through {@link EnableSpringDataWebSupport} on
	 * {@link org.springsource.restbucks.Restbucks.WebConfiguration}.
	 * 
	 * @param pageable the {@link Pageable} derived from the request.
	 * @param assembler the {@link PagedResourcesAssembler} to easily build {@link PagedResources} instances from
	 *          {@link Page}s.
	 * @return
	 */
	@RequestMapping("/api/pages")
	HttpEntity<PagedResources<Resource<Book>>> foo(Pageable pageable, PagedResourcesAssembler<Book> assembler) {

		Page<Book> fullBooks = repository.findAll(pageable);
		return new ResponseEntity<>(assembler.toResource(fullBooks), HttpStatus.OK);
	}

	/**
	 * Exposes the {@link EngineController} to the root resource exposed by Spring Data REST.
	 * 
	 * @see org.springframework.hateoas.ResourceProcessor#process(org.springframework.hateoas.ResourceSupport)
	 */
	@Override
	public RepositoryLinksResource process(RepositoryLinksResource resource) {

		resource.add(linkTo(methodOn(EngineController.class).showBooksInProgress()).withRel(ENGINE_REL));
		resource.add(linkTo(EngineController.class).slash("pages").withRel(PAGES_REL));

		return resource;
	}
}
