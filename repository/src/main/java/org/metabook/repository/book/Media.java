package org.metabook.repository.book;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import org.metabook.repository.core.AbstractEntity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
@Table(name = "media")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public class Media extends AbstractEntity {
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    @JsonIgnore
	 private Book bookMedia;
	 
	 @Column(name = "medaType")
	 private MediaType mediaType;
	 
	 @Column(name = "uri")
	 private String uri;

	 @Column(name = "fileFormat")
	 private FileFormat fileFormat;
	 
	 @Column(name = "contentType")
	 private ContentType contentType;	 

	public Media(Book bookMedia, MediaType mediaType, String uri) {
		super();
		this.bookMedia = bookMedia;
		this.mediaType = mediaType;
		this.uri = uri;
	}

	public Media(MediaType mediaType, String uri) {
		super();
		this.mediaType = mediaType;
		this.uri = uri;
	}

	public Media() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((contentType == null) ? 0 : contentType.hashCode());
		result = prime * result
				+ ((fileFormat == null) ? 0 : fileFormat.hashCode());
		result = prime * result
				+ ((mediaType == null) ? 0 : mediaType.hashCode());
		result = prime * result + ((uri == null) ? 0 : uri.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Media other = (Media) obj;
		if (contentType != other.contentType)
			return false;
		if (fileFormat != other.fileFormat)
			return false;
		if (mediaType != other.mediaType)
			return false;
		if (uri == null) {
			if (other.uri != null)
				return false;
		} else if (!uri.equals(other.uri))
			return false;
		return true;
	}	
	
}