package org.metabook.repository.book;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.metabook.repository.core.AbstractEntity;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
@Table(name = "contributors")
@EqualsAndHashCode
@ToString
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public class Contributor { //extends AbstractEntity {

	
	
	public Contributor() {
		super();
	}

	//private String contributorCode;
	
/*	@Id
	@Column(name = "contributer_code", unique = true, nullable = false)
	public String getContributorCode() {
	return this.contributorCode;
	}*/
	
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contributor", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<BookContributor> booksHasContributors;
    
    private String firstName;
    
    private String lastName;

    @Column(unique=true)
	@Id
    private String deNormalisedName;
    
	public Contributor(
			Set<BookContributor> booksHasContributors, String firstName,
			String lastName) {
		super();
		this.booksHasContributors = booksHasContributors;
		this.firstName = prepareName(firstName);
		this.lastName = prepareName(lastName);
		this.firstName = prepareName(firstName);
		this.lastName = prepareName(lastName);
		this.deNormalisedName = denormaliseName(firstName, lastName);
	}

	public Contributor(String firstName,
			String lastName) {
		super();
		Set<BookContributor> booksHasContributors = new HashSet<BookContributor>();
		this.firstName = prepareName(firstName);
		this.lastName = prepareName(lastName);
		this.deNormalisedName = denormaliseName(firstName, lastName);
		this.booksHasContributors = booksHasContributors;
	}
    
	public String prepareName(String trimThisName) {
		if (StringUtils.isEmpty(trimThisName)){
		trimThisName = StringUtils.trimLeadingWhitespace(trimThisName);
		trimThisName = StringUtils.trimTrailingWhitespace(trimThisName);	
	}
		return trimThisName;
	}
	public String denormaliseName(String firstName, String lastName) {
		if (StringUtils.isEmpty(firstName)) {
				firstName = "";
		}
		if (!StringUtils.isEmpty(lastName)){
		firstName = StringUtils.trimAllWhitespace(firstName);
		lastName = StringUtils.trimAllWhitespace(lastName);
		deNormalisedName = firstName + lastName;
		deNormalisedName = StringUtils.capitalize(deNormalisedName);
	}
		return deNormalisedName;
	}
	
	public String getDisplayName() {
		if (lastName == null) lastName = "None";
		
		if (null != firstName)  return firstName + " " + lastName;
		else return lastName;
	}
	
}
