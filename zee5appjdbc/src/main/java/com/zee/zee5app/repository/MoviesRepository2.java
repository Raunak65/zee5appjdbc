package com.zee.zee5app.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.naming.InvalidNameException;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.IdNotFoundException;

public interface MoviesRepository2 {
	public String addMovie(Movies movie);
	public String updateMovie(String id, Movies movie) throws IdInvalidLengthException, InvalidNameException;
	public Optional<Movies> getMovieById(String id) throws IdNotFoundException, InvalidNameException, IdInvalidLengthException;
	public List<Movies> getAllMovies() throws InvalidNameException, IdInvalidLengthException;
	public String deleteMovieById(String id) throws IdNotFoundException, InvalidNameException, IdInvalidLengthException;
	public Optional<List<Movies>> getAllMoviesDetails() throws IdInvalidLengthException, InvalidNameException;
	


}
