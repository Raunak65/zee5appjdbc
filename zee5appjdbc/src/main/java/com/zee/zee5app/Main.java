package com.zee.zee5app;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.Provider.Service;
import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.impl.SubscriberRepositoryImpl;
import com.zee.zee5app.service.MovieService2;
import com.zee.zee5app.service.SeriesService2;
import com.zee.zee5app.service.SubscriberService2;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.UserService2;
import com.zee.zee5app.service.impl.MovieServiceImpl;
import com.zee.zee5app.service.impl.SeriesServiceImpl;
import com.zee.zee5app.service.impl.SubscriberServiceImpl;
import com.zee.zee5app.service.impl.UserServiceImpl;

public class Main {

	public static void main(String[] args) {
// 		Register
//		Register register = new Register();
//		
//		try {
//			register.setId("raunak12345");
//			register.setFirstName("Raunak");
//			register.setLastName("Chandak");
//			register.setEmail("raunakchandak65@gmail.com");
//			register.setPassword("rc@raunak12345");
//		} catch (IdInvalidLengthException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (InvalidNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		catch (InvalidEmailException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (InvalidPasswordException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		System.out.println(register);
		
// 		same as line 16
//		System.out.println(register.toString());
//		
//		accessing email from register class / dto package 
//		System.out.println(register.getEmail());
//		
//		
//		Class Login
//		Login login = new Login();

//		Class UserService	
		UserService2 service = null;
		try {
			service = UserServiceImpl.getInstance();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		SubscriberService2 subscriberservice = SubscriberServiceImpl.getInstance();
//		MovieService2 movieservice = MovieServiceImpl.getInstance();
//		SeriesService2 seriesservice = SeriesServiceImpl.getInstance();
		
		for(int i = 1; i <= 5; i++) {
			Register register2 = new Register();

			try {
				register2.setId("raunak123"+i);
				register2.setFirstName("Raunak");
				register2.setLastName("Chandak");
				register2.setEmail("raunakchandak@gmail.com");
				register2.setPassword("rc@raunak");
				register2.setContactnumber(new BigDecimal(i+"123456789"));
			} catch (IdInvalidLengthException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidNameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (InvalidEmailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidPasswordException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch(Exception e) {
				
			}
			catch(Throwable e) {
				
			}

			
			String result = service.addUser(register2);	
			System.out.println(result);			
		}
		try {
			Optional<Register> register2;
			register2 = service.getUserById("raunak12345");
			System.out.println(register2);
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidEmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IdInvalidLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		delete user by Id
		try {
			System.out.println(service.deleteUserById("raunak12345"));
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//	get all users
		try {
			Optional<List<Register>> optional2 = service.getAllUsersDetails();
			if(optional2.isEmpty()) {
				System.out.println("There are no records");
			}
			else {
				optional2.get().forEach(e -> System.out.println(e));
			}
		} catch (InvalidNameException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IdNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvalidPasswordException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvalidEmailException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IdInvalidLengthException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
//		service.getAllUsersDetails();
		
		MovieService2 movieservice = null;
		try {
			movieservice = MovieServiceImpl.getInstance();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i = 1; i <= 5; i++) {
//			String id,String cat, String movieName, String trailer,float length,String location, String password,String language,String [] cast
			try {
				String[] casts = new String[2];
				Movies movie = new Movies("movie@1", "End Game", "https://www.youtube.com/watch?v=TcMBFSGVi1c&ab_channel=MarvelEntertainment", 120, "2022-09-02", 10, "action", "Hindi", "A,B,C");
				String result = movieservice.addMovie(movie);	
				System.out.println(result);			
//				movie.setId("raunak12345");
//				movie.setFirstName("Raunak");
//				movie.setLastName("Chandak");
//				movie.setEmail("raunakchandak@gmail.com");
//				movie.setPassword("rc@raunak");
			} catch (IdInvalidLengthException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidNameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch(Exception e) {
				
			}
			catch(Throwable e) {
				
			}

		}
		try {
			for (Movies movie : movieservice.getAllMovies()) {
				if(movie!=null) System.out.println(movie);
			}
		} catch (InvalidNameException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IdInvalidLengthException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
		try {
			Optional<Movies> movie2;
			movie2 = movieservice.getMovieById("raunak12345");
			System.out.println(movie2+"checkpoint");
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IdInvalidLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		delete user by Id
		try {
			System.out.println(movieservice.deleteMovieById("raunak12345"));
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IdInvalidLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
