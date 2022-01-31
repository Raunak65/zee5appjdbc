package com.zee.zee5app.dto;

import javax.naming.InvalidNameException;

import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.exception.LocationNotFoundException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
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
public class Movies {
	
	private String genre;
	private String releasedate;
	private String trailer;
	private String language;
	private float length;
	private String cast;
	private int agelimit;
	
	public Movies(String id,String movieName,String trailer,float length,String releasedate,int agelimit,String genre,String language,String cast) 
			throws IdInvalidLengthException, InvalidNameException,LocationNotFoundException {
				super();
				this.setId(id);
				this.setMovieName(movieName);
				this.genre = genre;
				this.releasedate = releasedate;
				this.language = language;
				this.length = length;
				this.trailer = trailer;
				this.cast = cast;
				this.agelimit = agelimit;
				
				
		}
	
	public Movies() {
		
	}
	
	@Setter(value = AccessLevel.NONE)
	private String id;
	
	@Setter(value = AccessLevel.NONE)
	private String movieName;
	
	
	
	
	public void setMovieName(String movieName) throws InvalidNameException {
		if(movieName == null || movieName=="" || movieName.length()<2) {
			throw new InvalidNameException("First Name is not valid");
		}
		this.movieName = movieName;
	}
	
	public void setId(String id) throws IdInvalidLengthException {
		if(id.length()<=6) {
			
			throw new IdInvalidLengthException("Id length is less than or equal to 6");
			
		}
			
		this.id = id;
	}
	
}
