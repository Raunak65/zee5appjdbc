package com.zee.zee5app.service;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.repository.SeriesRepository;

public class SeriesService {
	private SeriesRepository repository = SeriesRepository.getInstance();
	private SeriesService() {
		
	}
//	If we want to create a single object then we have to create 
//	it inside the same class
//	and we have to share ref with others
//	to do the same we have to declare a method
	private static SeriesService service = null;
//	This should be static 
//	Only one copy
	
	public static SeriesService getInstance() {
//		This becomes a object independent
//		static will make it independent of the object
		if (service == null) service = new SeriesService();
		return service;
	}
	public String addSeries(Series movie) {
		return this.repository.addSeries(movie);
	}
	public Series getSeriesById(String id) {
		return this.repository.getSeriesById(id);
	}
	public Series[] getSeries() {
		return this.repository.getSeries();
	}
	public String deleteSeries(String id) {
		return this.repository.deleteSeries(id);
	}

}
