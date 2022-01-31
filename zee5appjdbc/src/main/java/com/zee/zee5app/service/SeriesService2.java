package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.naming.InvalidNameException;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.IdNotFoundException;

public interface SeriesService2 {

	public String addSeries(Series series);
	public String updateSeries(String id, Series series) throws InvalidNameException, IdInvalidLengthException;
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException, InvalidNameException, IdInvalidLengthException;
	public List<Series> getAllSeries() throws InvalidNameException, IdInvalidLengthException;
	public String deleteSeriesById(String id) throws IdNotFoundException, InvalidNameException, IdInvalidLengthException;
}
