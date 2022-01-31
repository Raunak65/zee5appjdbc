package com.zee.zee5app.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.MoviesRepository2;
import com.zee.zee5app.repository.SeriesRepository2;
import com.zee.zee5app.utils.DBUtils;
@Repository
public class MoviesRepositoryImpl implements MoviesRepository2 {

	private static MoviesRepository2 repository = null;
	private static DBUtils dbUtils = null;
	
	

	@Override
	public String addMovie(Movies movie) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertStatement = "insert into movies"
				+ " (movieId,moviename,trailer,length,releasedate,agelimit,genre,language,cast)"
				+ " values(?,?,?,?,?,?,?,?,?)";
		connection = dbUtils.getConnection();

		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, movie.getId());
			preparedStatement.setString(2, movie.getMovieName());
			preparedStatement.setString(3, movie.getTrailer());
			preparedStatement.setFloat(4, movie.getLength());
			preparedStatement.setString(5, movie.getReleasedate());
			preparedStatement.setInt(6, movie.getAgelimit());
			preparedStatement.setString(7, movie.getGenre());
			preparedStatement.setString(8, movie.getLanguage());
			preparedStatement.setString(9, movie.getCast());

//					returns number of rows affected by DML statement.
			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				connection.commit();
				return "Success";
			} else {
				connection.rollback();
				return "failed";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "Failed";
		} finally {
			dbUtils.closeConnection(connection);
		}
	}

	@Override
	public String updateMovie(String id, Movies movie) throws IdInvalidLengthException, InvalidNameException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertStatement = "update movies set moviename=?,trailer=?,"
				+ "length=?,releasedate=?, agelimit=?,genre=?," + "language=?,cast=? where movieId=?";
		connection = dbUtils.getConnection();

		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, movie.getMovieName());
			preparedStatement.setString(2, movie.getTrailer());
			preparedStatement.setFloat(3, movie.getLength());
			preparedStatement.setString(4, movie.getReleasedate());
			preparedStatement.setInt(5, movie.getAgelimit());
			preparedStatement.setString(6, movie.getGenre());
			preparedStatement.setString(7, movie.getLanguage());
			preparedStatement.setString(8, movie.getCast());
			preparedStatement.setString(9, movie.getId());

//			returns number of rows affected by DML statement.
			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				connection.commit();
				return "Success";
			} else {
				connection.rollback();
				return "failed";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "Failed";
		} finally {
			dbUtils.closeConnection(connection);
		}
	}

	@Override
	public Optional<Movies> getMovieById(String id)
			throws IdNotFoundException, InvalidNameException, IdInvalidLengthException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

//		Result set is java.sql object that stores the result from select statement. 
		ResultSet resultSet = null;

		String selectStatement = "select * from movies where movieId=?";

		connection = dbUtils.getConnection();

		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, id);

//			Returns the result set object.
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
//				next() method is used to traverse the result set.
//				Initially result set will be placed at 1st record.
//				when we will call 1st time it will retrieve the 1st record
//				and refer to the 2nd record
				Movies movie = new Movies();
				movie.setId(resultSet.getString("movieId"));
				movie.setMovieName(resultSet.getString("moviename"));
				movie.setTrailer(resultSet.getString("trailer"));
				movie.setLength(resultSet.getFloat("length"));
				movie.setReleasedate(resultSet.getString("releasedate"));
				movie.setAgelimit(resultSet.getInt("agelimit"));
				movie.setGenre(resultSet.getString("genre"));
				movie.setLanguage(resultSet.getString("language"));
				movie.setCast(resultSet.getString("cast"));
				return Optional.of(movie);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}
		return Optional.empty();
	}

	@Override
	public List<Movies> getAllMovies() throws InvalidNameException, IdInvalidLengthException {
		Optional<List<Movies>> optional = this.getAllMoviesDetails();
		if (optional.isEmpty()) {
			return null;
		} else {
			List<Movies> list = optional.get();
			return list;
		}
	}

	@Override
	public Optional<List<Movies>> getAllMoviesDetails() throws IdInvalidLengthException, InvalidNameException

	{
		List<Movies> movies = new ArrayList<Movies>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;

//		Result set is java.sql object that stores the result from select statement. 
		ResultSet resultSet = null;

		String selectStatement = "select * from movies";

		connection = dbUtils.getConnection();

		try {
			preparedStatement = connection.prepareStatement(selectStatement);

//			Returns the result set object.
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
//				next() method is used to traverse the result set.
//				Initially result set will be placed at 1st record.
//				when we will call 1st time it will retrieve the 1st record
//				and refer to the 2nd record
				Movies movie = new Movies();
				movie.setId(resultSet.getString("movieId"));
				movie.setMovieName(resultSet.getString("moviename"));
				movie.setTrailer(resultSet.getString("trailer"));
				movie.setLength(resultSet.getFloat("length"));
				movie.setReleasedate(resultSet.getString("releasedate"));
				movie.setAgelimit(resultSet.getInt("agelimit"));
				movie.setGenre(resultSet.getString("genre"));
				movie.setLanguage(resultSet.getString("language"));
				movie.setCast(resultSet.getString("cast"));
				movies.add(movie);
			}
			return Optional.ofNullable(movies);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}
		return Optional.empty();
	}

	@Override
	public String deleteMovieById(String id)
			throws IdNotFoundException, InvalidNameException, IdInvalidLengthException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String deleteStatement = "delete from movies where movieId=?";
		connection = dbUtils.getConnection();

		try {
			preparedStatement = connection.prepareStatement(deleteStatement);
			preparedStatement.setString(1, id);
//			returns number of row affected by DML statement.
			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				connection.commit();
				return "Success";
			} else {
				return "failed";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failed";
		} finally {
			dbUtils.closeConnection(connection);
		}
	}

}
