package org.metabook.repository.book;

//import java.time.LocalDateTime;

import org.joda.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.annotations.Type;


import org.metabook.repository.core.AbstractEntity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
//@ToString(exclude = "books")
@Table(name = "categories")
//@EqualsAndHashCode
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public class Category {//extends AbstractEntity {

	//@JsonIgnore
	//@javax.persistence.Enumerated
	@Column(unique=true)
	public String categoryTitle;

    @Column(unique=true)
	@Id
    private String deNormalisedTitle;
    
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private LocalDateTime createdDate;

    @ManyToMany(cascade=CascadeType.ALL, mappedBy="categories", fetch = FetchType.EAGER)  
	@JsonIgnore
	private Set<Book> books = new HashSet<Book>();

	/**
	 * Creates a new {@link Category} for the given {@link Book}s.
	 * 
	 * @param books must not be {@literal null}.
	 */
	public Category(Collection<Book> books) {

		this.books.addAll(books);
		this.createdDate = LocalDateTime.now();
	}

	/**
	 * Creates a new {@link Book} containing the given {@link Book}s.
	 * 
	 * @param items must not be {@literal null}.
	 */
	public Category(Book... books) {
		this(Arrays.asList(books));
		this.createdDate = LocalDateTime.now();
	}


	public Category() {
		super();
	}
	public Category(String title) {
		super();
		this.categoryTitle=title;

	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((deNormalisedTitle == null) ? 0 : deNormalisedTitle
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (deNormalisedTitle == null) {
			if (other.deNormalisedTitle != null)
				return false;
		} else if (!deNormalisedTitle.equals(other.deNormalisedTitle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return categoryTitle;
	}


	/**
	 * Enumeration for all the statuses an {@link Category} can be in.
	 * 
	 * @author Ian Morris
	 */
	//public static enum SimpleCategory {

		/**
		 * Placed, but not payed yet. Still changeable.
		 */
//		KIDS,

		/**
		 * {@link Order} was payed. No changes allowed to it anymore.
		 */
	//	ART,

		/**
		 * The {@link Order} is currently processed.
		 */
	//	FICTION,

		/**
		 * The {@link Order} is ready to be picked up by the customer.
		 */
		//MUSIC,

		/**
		 * The {@link Order} was completed.
		 */
	//	POLITICS;
//	}
}
