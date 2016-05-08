package org.metabook.repository.book;

import java.util.List;

import org.metabook.repository.book.web.ContributorProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.metabook.repository.book.Contributor;

@RepositoryRestResource(excerptProjection = ContributorProjection.class)
@Repository
public interface ContributorRepository extends PagingAndSortingRepository<Contributor, Long>, QueryDslPredicateExecutor<Contributor>{

	@Query("FROM Contributor")
	List<Contributor> findAll();
	
	
	/**
	 * Returns all {@link Contributor}s with the given {@link deNormalisedName}.
	 * 
	 * @return
	 */
	@Query("FROM Contributor c where c.deNormalisedName = :deNormalisedName")
	List<Contributor> findContributorByDenormalisedName(@Param("deNormalisedName") String deNormalisedName);
	
	@Transactional(timeout = 10)
	<S extends Contributor> S save(S entity);
}