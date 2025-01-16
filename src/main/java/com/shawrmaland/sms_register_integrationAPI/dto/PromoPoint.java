package com.shawrmaland.sms_register_integrationAPI.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
/*
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data*/
public class PromoPoint {
	
	//@JsonInclude(Include.NON_NULL)
	@JsonProperty("phone_number")
	public String phoneNumber;
	
	//@JsonInclude(Include.NON_NULL)
	@JsonProperty("message_text")
	public String message;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
