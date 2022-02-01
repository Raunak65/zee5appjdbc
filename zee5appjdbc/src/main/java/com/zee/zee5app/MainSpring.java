
package com.zee.zee5app;

import java.math.BigDecimal;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.zee.zee5app.config.Config;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.MoviesRepository2;
import com.zee.zee5app.repository.UserRepository2;
import com.zee.zee5app.repository.impl.MoviesRepositoryImpl;

public class MainSpring {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		//we need to establish/create spring env.
		//this one will kick start of ur spring appli
		//application context
		//here we have to initialize the app. context container
		//java based config
		AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
		UserRepository2 userRepository = applicationContext.getBean(UserRepository2.class);
		MoviesRepository2 repository = applicationContext.getBean(MoviesRepository2.class);
		MoviesRepositoryImpl movieimpl = applicationContext.getBean(MoviesRepositoryImpl.class);
		
		System.out.println(userRepository);
		UserRepository2 userRepository2 = applicationContext.getBean(UserRepository2.class);
		System.out.println(userRepository2);
		
		System.out.println(userRepository.hashCode());
		System.out.println(userRepository.hashCode());
		System.out.println(repository.hashCode());
		System.out.println(movieimpl.hashCode());
		
		System.out.println(userRepository.equals(userRepository2));
		System.out.println("Current checkpoint=============");
		DataSource dataSource = applicationContext.getBean("ds",DataSource.class);
		System.out.println(dataSource.hashCode());
		DataSource dataSource2 = applicationContext.getBean("ds",DataSource.class);
		System.out.println(dataSource.hashCode());
		
		System.out.println(dataSource.equals(dataSource2));
		
		try {
			Register register = new Register("raunak6","Rauank","CHandak","abc.def@6mail.com","pass@afes");
			register.setContactnumber(new BigDecimal("7867890134"));
			System.out.println(userRepository.addUser(register));
		} catch (IdInvalidLengthException | InvalidEmailException | InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (javax.naming.InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		applicationContext.close();
	}
}
