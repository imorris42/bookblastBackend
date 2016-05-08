package org.metabook.repository.book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.GenericGenerator;
import org.metabook.repository.core.AbstractEntity;
import org.metabook.repository.core.MonetaryAmount;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * A schema object to represent a book
 * 
 * @author Ian Morris
 */
@Entity
@Data
@Getter
@Setter
@Table(name = "books")
@EqualsAndHashCode(callSuper = false)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public class Book extends AbstractEntity{

	public static final String PK_BOOK = "PK_BOOK";

	private String isbn10;
	private String isbn13;
	private String leadingArticle;
	private String mainTitle;
	private String subTitle;
	private String seriesTitle;
	private String seriesVolumeNumber;
	private String productFormatCode;
	private String productFormatText;
	private String paginationNumeric;
	
	private String placeOfPublication;
	private String countryOfPublication;
	
	private String printedIn;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookContributor",fetch = FetchType.EAGER)
    @JsonIgnore
    public List<BookContributor> bookContributors;
 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookMedia",fetch = FetchType.EAGER)
    @JsonIgnore
    public List<Media> media;
    
	private String publisherName;
	private String imprint;
	
	private String languageCode;
	@Lob
	private String briefDescription;
	@Lob
	private String fullDescription;
	
    @ManyToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)  
    @JoinTable(name="category_book", joinColumns=@JoinColumn(name="book_id"), inverseJoinColumns=@JoinColumn(name="category_id",referencedColumnName="denormalisedTitle")) 
	@JsonIgnore
    private List<Category> categories;

	private String authorWebsite;
	private String publisherWebsite;
	private String additionalWebsite;
	
	private String publicationDate;
		
	//private String title;	
	
    //private String email;    

    //private String fullTitle;
	//private int quantity;
	//private MonetaryAmount price;	  
	/*
	 * private String fullTitleInverted;


	private String subtitle;
	private String previousTitleLong;
	private String previousTitleShort;


	private String seriesISSN;
	private String heightMM;
	private String widthMM;
	private String spineWidthMM;
	private String weightGrams;
	private String heightInches;
	private String widthInches;
	private String spineWidthInches;
	private String weightOunces;
	private String fullEditionStatement;
	private String shortEditionStatement;


	private String paginationSupplied;

	private String numberOfItems;
	private String runningTime;
	private String illustrationsOtherContents;
	private String numberOfPieces;
	private String containedItems;
	private String fileSize;


	private String publisherBDCode;
	private String imprintBDCode;

	private String languageText;
	private String languageStatement;
	private String translationStatement;
	private String productClassCode;
	private String productClassText;
	private String dateRangeAsStored;

	private String review;
	private String authorBiography;
	private String promotionalInformation;
	private String tableOfContents;

	private String additionalLink;
	private String replacesISBN10;
	private String replacedByISBN10;
	private String publisherSuggestedAlt10;
	private String replacesISBN13;
	private String replacedByISBN13;
	private String restrictedSalesStatement;

	private String reissueDate;
	private String publisherUpdateOrganisation;
	private String noLongerAvailableDate;
	private String firstPublishedYear;
	private String copyrightYear;

*/


	/**
	 * @param mainTitle
	 * @param isbn13
	 */	
	public Book(String mainTitle, String isbn13) {
		super();
		this.mainTitle = mainTitle;
		this.isbn13 = isbn13;
		
	}


	public Book() {
		super();
	}

	public String getAuthor(){
		try{
		if (null != bookContributors && null != bookContributors.get(0) &&  null != (bookContributors.get(0).contributor.getDisplayName()) )
		return bookContributors.get(0).contributor.getDisplayName();
		else return "none";
		}
		catch (java.lang.IndexOutOfBoundsException jiobe) {
			 return "none";
		}
		
	}

	public String getCategories(){
		if (null == categories || categories.size() == 0) return "[None]";
		else return Arrays.toString(categories.toArray());
	}


	
}

