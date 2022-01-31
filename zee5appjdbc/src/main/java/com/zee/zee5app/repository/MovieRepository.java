package com.zee.zee5app.repository;

import javax.naming.InvalidNameException;

import com.zee.zee5app.dto.Movies;

public class MovieRepository {
	
	private Movies [] movies = new Movies[10];
	private MovieRepository() {
			
		}
	//	delete an user by id
		public String deleteMovie(String id) {
			Movies temp[] = new Movies[movies.length];
			int i = 0;
			int j = 0;
			for (Movies currRegister : movies) {
				if (currRegister!=null) {
					if (currRegister.getId().equals(id)) {
						j++;
					}
					else {
						temp[i] = movies[j];
						i++;
						j++;
					}
				}	
			}
			movies = temp;
			return "success";
		}
		
	//	update an user
		public String updateMovie(String id,Movies movie) throws InvalidNameException {
			for (Movies currMovie : movies) {
				if (currMovie!=null) {
					if (currMovie.getId().equals(id)) {
						currMovie.setCast(movie.getCast());
						currMovie.setLanguage(movie.getLanguage());
						currMovie.setTrailer(movie.getTrailer());
						currMovie.setLength(movie.getLength());
						currMovie.setReleasedate(movie.getReleasedate());
						currMovie.setMovieName(movie.getMovieName());
						currMovie.setGenre(movie.getGenre());
						return "updated";
					}
				}	
			}
			return null;
		}
		
	//	get users
		public Movies[] getMovies() {
			return movies;
		}
		
	//	get user by Id
		public Movies getMovieById(String id) {
			for (Movies register : movies) {
				if(register!=null) {
					
					if(register.getId().equals(id)) {
						return register;
					}
				}
			}
			return null;
		}
		
	//	add user
		private static int count = -1;
		public String addMovie(Movies movie) {
			if(count == movies.length-1) {
				Movies temp[] = new Movies[2*movies.length];
				System.arraycopy(movies, 0, temp,0, movies.length);
				movies = temp;
				movies[++count] = movie;
				return "Successfully added User";
			}
			movies[++count] = movie;
			return "Successfully added User";
		}
		private static MovieRepository movierepository ;
		public static MovieRepository getInstance() {
			if (movierepository == null) movierepository = new MovieRepository();
			return movierepository;
		}
	

}
