package com.zee.zee5app.repository;

import javax.naming.InvalidNameException;

import com.zee.zee5app.dto.Series;

public class SeriesRepository {
	private Series [] series = new Series[10];
	private SeriesRepository() {
			
		}
	//	delete an user by id
		public String deleteSeries(String id) {
			Series temp[] = new Series[series.length];
			int i = 0;
			int j = 0;
			for (Series currRegister : series) {
				if (currRegister!=null) {
					if (currRegister.getId().equals(id)) {
						j++;
					}
					else {
						temp[i] = series[j];
						i++;
						j++;
					}
				}	
			}
			series = temp;
			return "success";
		}
		
	//	update an user
		public String updateSeries(String id,Series movie) throws InvalidNameException {
			for (Series currSeries : series) {
				if (currSeries!=null) {
					if (currSeries.getId().equals(id)) {
						currSeries.setCast(movie.getCast());
						currSeries.setLanguage(movie.getLanguage());
						currSeries.setTrailer(movie.getTrailer());
						currSeries.setLength(movie.getLength());
						currSeries.setReleasedate(movie.getReleasedate());
						currSeries.setSeriesName(movie.getSeriesName());
						currSeries.setGenre(movie.getGenre());
						return "updated";
					}
				}	
			}
			return null;
		}
		
	//	get users
		public Series[] getSeries() {
			return series;
		}
		
	//	get user by Id
		public Series getSeriesById(String id) {
			for (Series register : series) {
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
		public String addSeries(Series register) {
			if(count == series.length-1) {
				Series temp[] = new Series[2*series.length];
				System.arraycopy(series, 0, temp,0, series.length);
				series = temp;
				series[++count] = register;
				return "Successfully added User";
			}
			series[++count] = register;
			return "Successfully added User";
		}
		private static SeriesRepository seriesrepository ;
		public static SeriesRepository getInstance() {
			if (seriesrepository == null) seriesrepository = new SeriesRepository();
			return seriesrepository;
		}
	

}