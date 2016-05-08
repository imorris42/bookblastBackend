package org.metabook.repository.book;

import java.util.List;

import org.metabook.repository.book.web.BookProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource(excerptProjection = BookProjection.class)
@Repository

public interface BookRepository extends PagingAndSortingRepository<Book, Long>, QueryDslPredicateExecutor<Book> {
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#findAll()
	 */
	@Query("FROM Book")
	public List<Book> findAll();
	
	/**
	 * Returns all {@link Book}s with the given {@link ISBN}.
	 * 
	 * @param isbn must not be {@literal null}.
	 * @return
	 */
	@Query("FROM Book b where b.isbn13 = :isbn13")
public Book findByISBN(@Param("isbn13") String isbn13);

//@Query("FROM Book b  WHERE b.categories IN :catlist")
@Query("SELECT b FROM Book b INNER JOIN b.categories c WHERE c IN (:catlist)")
public List<Book> findByCategories(@Param("catlist") List<Category> catlist);


	

/*
 * (non-Javadoc)
 * @see org.springframework.data.repository.CrudRepository#save(S)
 */
@Transactional(timeout = 10)
<S extends Book> S save(S entity);

}
