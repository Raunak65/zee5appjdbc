package com.zee.zee5app.service;

import javax.naming.InvalidNameException;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.repository.MovieRepository;

public class MovieService {

	private MovieRepository repository = MovieRepository.getInstance();
	private MovieService() {
		
	}
//	If we want to create a single object then we have to create 
//	it inside the same class
//	and we have to share ref with others
//	to do the same we have to declare a method
	private static MovieService service = null;
//	This should be static 
//	Only one copy
	
	public static MovieService getInstance() {
//		This becomes a object independent
//		static will make it independent of the object
		if (service == null) service = new MovieService();
		return service;
	}
	public String addMovie(Movies movie) {
		return this.repository.addMovie(movie);
	}
	public Movies getMovieById(String id) {
		return this.repository.getMovieById(id);
	}
	public Movies[] getMovies() {
		return this.repository.getMovies();
	}
	public String deleteMovie(String id) {
		return this.repository.deleteMovie(id);
	}
	public String updateMovie(String id,Movies movie) throws InvalidNameException {
		return this.repository.updateMovie(id,movie);
	}
}
