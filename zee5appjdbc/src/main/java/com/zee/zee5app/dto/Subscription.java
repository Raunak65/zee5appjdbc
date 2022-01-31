package com.zee.zee5app.dto;

import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.InvalidAmountException;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@EqualsAndHashCode
@ToString
//@NoArgsConstructor
//@AllArgsConstructor
public class Subscription {
	private String regid;
	private String dateOfPurchase;
	private String status;
	private String type;
	private String paymentMode;
	private String autoRenewal;
	private String expiryDate;
	
	
	
	@Setter(value = AccessLevel.NONE)
	private String id;
	
	@Setter(value = AccessLevel.NONE)
	private float amount;
	public Subscription() {
		
	}
	public Subscription(String regid,String dateOfPurchase,String status,String type,String paymentMode,String id,String autoRenewal,String expiryDate,float amount) 
			throws IdInvalidLengthException, InvalidAmountException {
		this.regid = regid;
		this.setId(id);
		this.setAmount(amount);
		this.dateOfPurchase = dateOfPurchase;
		this.status = status;
		this.paymentMode = paymentMode;
		this.expiryDate = expiryDate;
		this.type = type;
		this.autoRenewal = autoRenewal;
		
	}
	
	
	public void setId(String id) throws IdInvalidLengthException {
		if(id.length()<=6) {
			
			throw new IdInvalidLengthException("Id length is less than or equal to 6");
			
		}
			
		this.id = id;
	}
	
	public void setAmount(float amount) throws InvalidAmountException {
		// TODO Auto-generated method stub
		if(amount<100) {
			throw new InvalidAmountException("Amount is less");
		}
		this.amount = amount;
		
	}
}
