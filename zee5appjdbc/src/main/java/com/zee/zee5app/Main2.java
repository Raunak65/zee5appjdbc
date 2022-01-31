package com.zee.zee5app;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Register register = new Register("raunak12345", "Raunak", "Chandak", "raunakchandak65@gmail.com", "rc@raunak12345");
			System.out.println(register);
			System.out.println(register.toString());
			System.out.println(register.hashCode());
			Register register2 = new Register("raunak12345", "Raunak", "Chandak", "raunakchandak65@gmail.com", "rc@raunak12345");
			System.out.println(register2);
			System.out.println(register2.toString());
			System.out.println(register2.hashCode());
			System.out.println(register);
			System.out.println(register.toString());
			System.out.println(register.hashCode());
			System.out.println("equals method call"+register.equals(register2));
			
		} catch (IdInvalidLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (InvalidEmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			
		}
		catch(Throwable e) {
			
		}
		
	}

}