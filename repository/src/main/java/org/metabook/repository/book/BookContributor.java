package org.metabook.repository.book;

import java.util.Set;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.metabook.repository.core.AbstractEntity;
import org.metabook.repository.core.MonetaryAmount;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@Getter
@Setter
@Table(name = "book_contributor")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public class BookContributor extends AbstractEntity {
    
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    @JsonIgnore
	 private Book bookContributor;
	 
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "contributor_id")
	 public Contributor contributor;

	 @Column(name = "role")
	 private String role;

	public BookContributor(Book bookContributor, Contributor contributor, String role) {
		super();
		this.bookContributor = bookContributor;
		this.contributor = contributor;
		this.role = role;
	}

	public BookContributor(Contributor contributor, String role) {
		super();
		this.contributor = contributor;
		this.role = role;
	}

	public BookContributor() {
		super();
	}	
	
	@Override
	public String toString() {
		return Long.toString(bookContributor.getId()) + contributor.getDeNormalisedName();
	}
}
