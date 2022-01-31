package com.zee.zee5app.dto;

import javax.naming.InvalidNameException;

import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.LocationNotFoundException;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
//@NoArgsConstructor
//@AllArgsConstructor
public class Series {
	private String genre;
	private String releasedate;
	private String trailer;
	private String language;
	private float length;
	private String cast;
	private int noofepisodes;
	private int agelimit;
	
	public Series() {
		
	}
	
	public Series(String id,String genre, String movieName, String trailer,float length,String location,String language,String cast,String releasedate,int noofepisodes) 
			throws IdInvalidLengthException, InvalidNameException,LocationNotFoundException {
				super();
				this.setId(id);
				this.setSeriesName(movieName);
				this.genre = genre;
				this.releasedate = releasedate;
				this.language = language;
				this.length = length;
				this.trailer = trailer;
				this.cast = cast;
				this.noofepisodes = noofepisodes;
				this.agelimit = agelimit;
				
				
		}
	@Setter(value = AccessLevel.NONE)
	private String id;
	
	@Setter(value = AccessLevel.NONE)
	private String seriesName;
	
	
	public void setSeriesName(String seriesName) throws InvalidNameException {
		if(seriesName == null || seriesName=="" || seriesName.length()<2) {
			throw new InvalidNameException("First Name is not valid");
		}
		this.seriesName = seriesName;
	}
	
	
	public void setId(String id) throws IdInvalidLengthException {
		if(id.length()<=6) {
			throw new IdInvalidLengthException("Id length is less than or equal to 6");
		}
		this.id = id;
	}
	
}
