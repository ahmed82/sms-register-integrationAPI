package com.shawrmaland.sms_register_integrationAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shawrmaland.sms_register_integrationAPI.dto.PromoPoint;
import com.shawrmaland.sms_register_integrationAPI.service.SmsServices;

/**
 * 
 * @author Tro Technology
 * @author Ahmed Al Salih
 * 
 * @version 1.0
 * 
 * @category RESTFUL APIs
 * 
 */

@RestController
@RequestMapping("/api")
public class WebController {
	
	@Autowired
	SmsServices smsServices;
	
	/***
	 * 
	 * @apiNote TEST API to Get the PromoPoint JSON Object. To be used in the POST method
	 * @return @PromoPoint JSO object
	 */

	@PostMapping(path = "/promo")
	public ResponseEntity<?> sendSMSPromo(@RequestBody PromoPoint promoPoint) {
		//TODO add the implementation for the Register Company based on the coming requirement...
		 smsServices.sendSMSMessege(promoPoint);
		return new ResponseEntity<String>( HttpStatus.OK);
	}
	
	
	/***
	 * 
	 * promoPoint.setPhoneNumber("9647503030xxx"); promoPoint.
	 * setMessage("Test SMS API from the Java Restful API ;) Ahmed -Cheers!!!");
	 * @return ResponseEntity;
	 */
	@PostMapping(path = "/sms")
	public ResponseEntity<?> recivePromoPoints(@RequestBody PromoPoint promoPoint ){
		
		String responseBody = smsServices.sendSMSMessege(promoPoint);
		return new ResponseEntity<String>(responseBody, HttpStatus.OK);
		
	}
	
	
	

}//class
