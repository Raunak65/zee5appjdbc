package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.SeriesRepository2;
import com.zee.zee5app.repository.UserRepository2;
import com.zee.zee5app.repository.impl.SeriesRepositoryImpl;
import com.zee.zee5app.service.SeriesService2;
import com.zee.zee5app.service.UserService2;
@Service
public class SeriesServiceImpl implements SeriesService2 {
	private SeriesRepository2 repository ;
	private static SeriesService2 seriesservice;
	
	
	@Override
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException, InvalidNameException, IdInvalidLengthException {
		return this.repository.getSeriesById(id);
	}

	@Override
	public String updateSeries(String id,Series series) throws InvalidNameException, IdInvalidLengthException {
		return this.repository.updateSeries(id,series);
	}

	@Override
	public String deleteSeriesById(String id) throws IdNotFoundException, InvalidNameException, IdInvalidLengthException {
		return this.repository.deleteSeriesById(id);
	}
	
	@Override
	public String addSeries(Series movie) {
		return this.repository.addSeries(movie);
	}
	@Override
	public List<Series> getAllSeries() throws InvalidNameException, IdInvalidLengthException {
		return this.repository.getAllSeries();
	}
	

}
