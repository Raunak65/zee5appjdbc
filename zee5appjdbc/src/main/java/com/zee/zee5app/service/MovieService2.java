package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.naming.InvalidNameException;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidPasswordException;

public interface MovieService2 {

	public String addMovie(Movies movie);
	public String updateMovie(String id, Movies movie) throws InvalidNameException, IdInvalidLengthException;
	public Optional<Movies> getMovieById(String id) throws IdNotFoundException, InvalidNameException, IdInvalidLengthException;
	public List<Movies> getAllMovies() throws InvalidNameException, IdInvalidLengthException;
	public String deleteMovieById(String id) throws IdNotFoundException, InvalidNameException, IdInvalidLengthException;
	
	public Optional<List<Movies>> getAllMoviesDetails() throws InvalidNameException, IdNotFoundException,
			InvalidPasswordException, InvalidEmailException, IdInvalidLengthException;
}
