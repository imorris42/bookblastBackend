package org.metabook.server.api.book.engine.web;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.hibernate.Hibernate;
import org.metabook.repository.book.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mysema.query.types.Predicate;


@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class BookController implements ResourceProcessor<RepositoryLinksResource> {

	public static final String ENGINE_REL = "engine";
	public static final String PAGES_REL = "pages";

	@Autowired
	private  @NonNull BookRepository repository;
/*	@Autowired
	public BookController(BookRepository repository, CategoryRepository categoryRepository,EntityLinks entityLinks) {
	this.repository = repository;
	this.categoryRepository =categoryRepository;
	this.entityLinks = entityLinks;
	
	}*/
/*	@Autowired
	private  @NonNull EntityLinks entityLinks;
	*/
	@Autowired
	private  @NonNull CategoryRepository categoryRepository;
	
	@CrossOrigin(maxAge = 3600)
	  @RequestMapping(value = "/api/pagedBooks", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	@Transactional
	  HttpEntity<PagedResources<Resource<Book>>> foo(Pageable pageable, PagedResourcesAssembler<Book> assembler) 
	    {
			Page<Book> allBooks = repository.findAll(pageable);
			
			return new ResponseEntity<>(assembler.toResource(allBooks), HttpStatus.OK);
	   }

	  @RequestMapping(value = "/api/book/{bookID}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	  HttpEntity<Resources<Resource<Book>>> foo(@PathVariable Long bookID, Pageable pageable, PagedResourcesAssembler<Book> assembler) 
	    {
			Book aBook = repository.findOne(bookID);
			List<Book> bookList =  new ArrayList<Book>();
			bookList.add(aBook);
			Resources<Resource<Book>> bookResources = Resources.wrap(bookList);
			
			return new ResponseEntity<>(bookResources, HttpStatus.OK);
	   }
	  
		@CrossOrigin(maxAge = 3600)
	  @RequestMapping(value = "/api/tags", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
		HttpEntity<PagedResources<Resource<Category>>> bar(Pageable pageable, PagedResourcesAssembler<Category> assembler) 
	    {
			Page<Category> allTags = categoryRepository.findAll(pageable);
			return new ResponseEntity<>(assembler.toResource(allTags), HttpStatus.OK);
	   }
	 
		@CrossOrigin(maxAge = 3600)
	  @RequestMapping(value = "/api/booksByCategory/{categoryTitle}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
		HttpEntity<Resources<Resource<Book>>> barCat(@PathVariable String categoryTitle, Pageable pageable, PagedResourcesAssembler<Book> assembler) 
	    {

		  List<Category> searchCategories = new ArrayList<Category>();
		  QCategory qCat = QCategory.category;
			
		  Predicate titleIs = qCat.categoryTitle.eq(categoryTitle);
		  Category category = categoryRepository.findOne(titleIs);
		  List<Book> allTags = null;
		  if (null!= category) {
		  searchCategories.add(category);
		//Page<Book> allTags = repository.findByCategories(searchCategories, pageable);
		 allTags = repository.findByCategories(searchCategories);
		  }
		  else {
			allTags=new ArrayList<Book>();  
		  }
			Resources<Resource<Book>> bookResources = Resources.wrap(allTags);
			return new ResponseEntity<>(bookResources, HttpStatus.OK);
	   }
		@CrossOrigin(maxAge = 3600)
	  @RequestMapping(value = "/api/alltags", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
			HttpEntity<Resources<Resource<Category>>> barall() 
		    {
			    List<Category> allTags = categoryRepository.findAllTags();
			  
				Resources<Resource<Category>> categoryResources = Resources.wrap(allTags);

				//return new ResponseEntity<>(orderResources, HttpStatus.OK);
				
				

			    for (Category category : allTags) {
			    	//Resource<Category> resource = new Resource<Category>(category);
					CategoryResource categoryResource = new CategoryResource(category.categoryTitle);
					//resource.add(entityLinks.linkToSingleResource(order));
					
				//	categoryResources.add(categoryResource);
				}

			    return new ResponseEntity<>(categoryResources, HttpStatus.OK);
		   }
	  
		@CrossOrigin(maxAge = 3600)
	  @RequestMapping(value = "/api/toptags", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
		HttpEntity<Resources<Resource<Category>>> barfive() 
	    {
		    List<Category> allTopTags = categoryRepository.findFiveRandomTags();
		  
			Resources<Resource<Category>> categoryResources = Resources.wrap(allTopTags);

			//return new ResponseEntity<>(orderResources, HttpStatus.OK);
			
			

		    for (Category category : allTopTags) {
		    	//Resource<Category> resource = new Resource<Category>(category);
				CategoryResource categoryResource = new CategoryResource(category.categoryTitle);
				//resource.add(entityLinks.linkToSingleResource(order));
				
			//	categoryResources.add(categoryResource);
			}

		    return new ResponseEntity<>(categoryResources, HttpStatus.OK);
	   }
		@CrossOrigin(maxAge = 3600)
	  @RequestMapping(value = "/api/toptentags", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
		HttpEntity<Resources<Resource<Category>>> barten() 
	    {
		    List<Category> allTopTags = categoryRepository.findTenRandomTags();
		  
			Resources<Resource<Category>> categoryResources = Resources.wrap(allTopTags);

			//return new ResponseEntity<>(orderResources, HttpStatus.OK);
			
			

		    for (Category category : allTopTags) {
		    	//Resource<Category> resource = new Resource<Category>(category);
				CategoryResource categoryResource = new CategoryResource(category.categoryTitle);
				//resource.add(entityLinks.linkToSingleResource(order));
				
			//	categoryResources.add(categoryResource);
			}

		    return new ResponseEntity<>(categoryResources, HttpStatus.OK);
	   }
		/**
		 * Resource implementation for payment results.
		 * 
		 * @author Oliver Gierke
		 */
		@Data
		@EqualsAndHashCode(callSuper = true)
		static class CategoryResource extends ResourceSupport {

			private final String tag;

			public CategoryResource(String tag) {
				super();
				this.tag = tag;
			}

		}
		
	  
	@Override
	public RepositoryLinksResource process(RepositoryLinksResource resource) {
		//resource.add(linkTo(methodOn(EngineController.class).showBooksInProgress()).withRel(ENGINE_REL));
		//resource.add(linkTo(EngineController.class).slash("pages").withRel(PAGES_REL));

		return resource;
	}
	}