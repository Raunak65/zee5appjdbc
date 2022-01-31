package com.zee.zee5app;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.exception.LocationNotFoundException;
import com.zee.zee5app.repository.impl.SubscriberRepositoryImpl;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.MovieService2;
import com.zee.zee5app.service.SubscriberService;
import com.zee.zee5app.service.SubscriberService2;
import com.zee.zee5app.service.UserService2;
import com.zee.zee5app.service.impl.LoginServiceImpl;
import com.zee.zee5app.service.impl.MovieServiceImpl;
import com.zee.zee5app.service.impl.SubscriberServiceImpl;
import com.zee.zee5app.service.impl.UserServiceImpl;

public class Main3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Register register;
		try {
			register = new Register("raunak1","Rauank","CHandak","abc.def@mail.com","pass@afes");
			register.setContactnumber(new BigDecimal("7894561230"));
			UserService2 userservice = UserServiceImpl.getInstance();
			userservice.addUser(register);
		} catch (InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IdInvalidLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidEmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			Register  register = new Register("raunak1","Rauank","CHandak","abc.def@mail.com","pass@afes");
//			register.setContactnumber(new BigDecimal("7894561230"));
//			UserService2 userservice = UserServiceImpl.getInstance();
//			userservice.addUser(register);
			
//			LoginService loginservice = LoginServiceImpl.getInstance();
//			loginservice.changeRole("abc.def@mail.com", ROLE.ROLE_ADMIN);
//			
//			Optional optional = userservice.getUserById("raunak1") ;
//			System.out.println(optional);
//			Optional<List<Register>> optional2 = userservice.getAllUsersDetails();
//			if(optional2.isEmpty()) {
//				System.out.println("There are no records");
//			}
//			else {
//				optional2.get().forEach(e -> System.out.println(e));
//			}
			
//			String res = userservice.deleteUserById("raunak1");
//			System.out.println(res);
			
//		} catch (InvalidNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IdInvalidLengthException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidEmailException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidPasswordException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//			try {
//				MovieService2 movieservice = MovieServiceImpl.getInstance();
//				Movies movie = new Movies("movie@46", " Game", "https://www.youtube.com/watch?v=TcMBFSGVi1c&ab_channel=MarvelEntertainment", 10, "2022-09-02", 10, "actdfasdfion", "sfsd", "A,B,C");
//				String res = movieservice.addMovie(movie);
//				System.out.println(res);
//				Optional optional = movieservice.getMovieById("movie@1") ;
//				System.out.println(optional);
//				String res2 = movieservice.deleteMovieById("movie@1");
//				System.out.println(res2);	
//				Optional<List<Movies>> optional2 = movieservice.getAllMoviesDetails();
//				if(optional2.isEmpty()) {
//					System.out.println("There are no records");
//				}
//				else {
//					optional2.get().forEach(e -> System.out.println(e));
//				}
//				
//				String res3 = movieservice.updateMovie("movie@6",movie);
//				System.out.println(res3);
//				
//			} catch (LocationNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InvalidNameException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IdInvalidLengthException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IdNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InvalidPasswordException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} catch (InvalidEmailException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		String regid,String dateOfPurchase,String status,
//		String type,String paymentMode,String id,
//		boolean autoRenewal,String expiryDate,float amount
//		SubscriberService2 subscriberservice;
//		try {
//			Subscription subscriber = new Subscription("reg1004","2022-05-12","ACTIVE",
//					"QUARTERLY","UPI","sub2011",
//					"TRUE","2022-08-12",499);
//			subscriberservice = SubscriberServiceImpl.getInstance();
//			String res = subscriberservice.addSubscriber(subscriber);
//			System.out.println(res);
//			Optional optional = subscriberservice.getSubscriberById("sub2006");
//			System.out.println(optional);
//			Optional<List<Subscription>> optional2 = subscriberservice.getAllSubscriptionssDetails();
//			if(optional2.isEmpty()) {
//				System.out.println("There are no records");
//			}
//			else {
//				optional2.get().forEach(e -> System.out.println(e));
//			}
//			List<Subscription> list = subscriberservice.getAllSubscribers();
//			list.forEach(e -> System.out.println(e));
//			Subscription subscriber2 = new Subscription("raunak1","2022-05-12","ACTIVE",
//					"QUARTERLY","UPI","sub2011",
//					"TRUE","2022-08-12",499);
//			subscriberservice.updateSubscriber("sub2011", subscriber2);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IdInvalidLengthException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidAmountException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidPasswordException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidEmailException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
}
