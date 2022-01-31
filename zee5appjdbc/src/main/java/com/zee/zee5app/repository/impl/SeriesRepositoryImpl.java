package com.zee.zee5app.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import javax.naming.InvalidNameException;

import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.SeriesRepository2;
import com.zee.zee5app.repository.UserRepository2;
import com.zee.zee5app.utils.DBUtils;
@Repository
public class SeriesRepositoryImpl implements SeriesRepository2 {

	private static SeriesRepository2 repository = null;
	private static DBUtils dbUtils = null;
	
	
	
	@Override
	public String addSeries(Series series) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertStatement = "insert into series"
				+ " (seriesId,seriesname,trailer,length,"
				+ "releasedate,agelimit,genre,language,"
				+ "cast,noofepisodes)"
				+ " values(?,?,?,?,?,?,?,?,?,?)";
		connection = dbUtils.getConnection();

		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, series.getId());
			preparedStatement.setString(2, series.getSeriesName());
			preparedStatement.setString(3, series.getTrailer());
			preparedStatement.setFloat(4, series.getLength());
			preparedStatement.setString(5, series.getReleasedate());
			preparedStatement.setInt(6, series.getAgelimit());
			preparedStatement.setString(7, series.getGenre());
			preparedStatement.setString(8, series.getLanguage());
			preparedStatement.setString(9,series.getCast());
			preparedStatement.setInt(9,series.getNoofepisodes());

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
	public String updateSeries(String id,Series series) throws InvalidNameException, IdInvalidLengthException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String updateStatement = "update series set seriesname=?,trailer=?,"
				+ "length=?,releasedate=?, agelimit=?,genre=?," 
				+ "language=?,cast=?,noofepisodes=? where seriesId=?";
		connection = dbUtils.getConnection();

		try {
			preparedStatement = connection.prepareStatement(updateStatement);
			preparedStatement.setString(1, series.getSeriesName());
			preparedStatement.setString(2, series.getTrailer());
			preparedStatement.setFloat(3, series.getLength());
			preparedStatement.setString(4, series.getReleasedate());
			preparedStatement.setInt(5, series.getAgelimit());
			preparedStatement.setString(6, series.getGenre());
			preparedStatement.setString(7, series.getLanguage());
			preparedStatement.setString(8, series.getCast());
			preparedStatement.setInt(9, series.getNoofepisodes());
			preparedStatement.setString(10, id);

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
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException, IdInvalidLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;

//		Result set is java.sql object that stores the result from select statement. 
		ResultSet resultSet = null;

		String selectStatement = "select * from series where seriesId=?";

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
				Series series = new Series();
				series.setId(resultSet.getString("seriesId"));
				series.setSeriesName(resultSet.getString("seriesname"));
				series.setTrailer(resultSet.getString("trailer"));
				series.setLength(resultSet.getFloat("length"));
				series.setReleasedate(resultSet.getString("releasedate"));
				series.setAgelimit(resultSet.getInt("agelimit"));
				series.setGenre(resultSet.getString("genre"));
				series.setLanguage(resultSet.getString("language"));
				series.setCast(resultSet.getString("cast"));
				series.setNoofepisodes(resultSet.getInt("noofepisodes"));
				return Optional.of(series);
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
	public List<Series> getAllSeries() throws InvalidNameException, IdInvalidLengthException {
		Optional<List<Series>> optional = this.getAllSeriesDetails();
		if (optional.isEmpty()) {
			return null;
		} else {
			List<Series> list = optional.get();
			return list;
		}
	}
	@Override
	public String deleteSeriesById(String id) throws IdNotFoundException, InvalidNameException, IdInvalidLengthException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String deleteStatement = "delete from series where seriesId=?";
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
	@Override
	public Optional<List<Series>> getAllSeriesDetails() throws IdInvalidLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		List<Series> seriesArrayList = new ArrayList<Series>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;

//		Result set is java.sql object that stores the result from select statement. 
		ResultSet resultSet = null;

		String selectStatement = "select * from series";

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
				Series series = new Series();
				series.setId(resultSet.getString("seriesId"));
				series.setSeriesName(resultSet.getString("seriesname"));
				series.setTrailer(resultSet.getString("trailer"));
				series.setLength(resultSet.getFloat("length"));
				series.setReleasedate(resultSet.getString("releasedate"));
				series.setAgelimit(resultSet.getInt("agelimit"));
				series.setGenre(resultSet.getString("genre"));
				series.setLanguage(resultSet.getString("language"));
				series.setCast(resultSet.getString("cast"));
				series.setNoofepisodes(resultSet.getInt("noofepisodes"));
				seriesArrayList.add(series);
			}
			return Optional.ofNullable(seriesArrayList);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}
		return Optional.empty();
	}
	

}
