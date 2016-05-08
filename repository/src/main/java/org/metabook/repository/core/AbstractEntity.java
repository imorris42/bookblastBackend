package org.metabook.repository.core;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import org.springframework.hateoas.Identifiable;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Base class to derive entity classes from.  Uses a {@link Long} id.
 * 
 * @author Ian Morris
 */
@MappedSuperclass
@Getter
@ToString
@EqualsAndHashCode

public class AbstractEntity implements Identifiable<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@JsonIgnore
	private final Long id;

	protected AbstractEntity() {
		this.id = null;
	}

	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}
}
