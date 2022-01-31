package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.naming.InvalidNameException;

import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.MoviesRepository2;
import com.zee.zee5app.repository.UserRepository2;
import com.zee.zee5app.repository.impl.MoviesRepositoryImpl;
import com.zee.zee5app.service.MovieService2;
import com.zee.zee5app.service.UserService2;
@Service
public class MovieServiceImpl implements MovieService2 {
	private MoviesRepository2 repository ;
	private static MovieService2 movieservice;
	
	
	@Override
	public String addMovie(Movies movie) {
		return this.repository.addMovie(movie);
	}

	@Override
	public String updateMovie(String id,Movies movie) throws InvalidNameException, IdInvalidLengthException {
		return this.repository.updateMovie(id,movie);
	}

	@Override
	public Optional<Movies> getMovieById(String id) throws IdNotFoundException, InvalidNameException, IdInvalidLengthException {
		return this.repository.getMovieById(id);
	}

	@Override
	public List<Movies> getAllMovies() throws InvalidNameException, IdInvalidLengthException {
		return this.repository.getAllMovies();
	}
	@Override
	public String deleteMovieById(String id) throws IdNotFoundException, InvalidNameException, IdInvalidLengthException {
		return this.repository.deleteMovieById(id);
	}
	@Override
	public Optional<List<Movies>> getAllMoviesDetails() throws InvalidNameException, IdNotFoundException, InvalidPasswordException, InvalidEmailException, IdInvalidLengthException {
		// TODO Auto-generated method stub
		return this.repository.getAllMoviesDetails();

	}

}
