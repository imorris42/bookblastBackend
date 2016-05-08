package org.metabook.repository.book;

import java.util.List;

import javax.persistence.NamedNativeQuery;

import org.metabook.repository.book.web.CategoryProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(excerptProjection = CategoryProjection.class)
@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long>, QueryDslPredicateExecutor<Category>{

	/**
	 * Returns all {@link Category}s with the given {@link isbn}.
	 * 
	 * @param status must not be {@literal null}.
	 * @return
	 */
	@Query("FROM Category")
	public List<Category> findAllTags();
		
	@Query(value="select * from CATEGORIES order by random() limit 5", nativeQuery=true)
	public List<Category> findFiveRandomTags();
	
	@Query(value="select * from CATEGORIES order by random() limit 10", nativeQuery=true)
	public List<Category> findTenRandomTags();
	

}