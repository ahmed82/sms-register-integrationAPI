package com.shawrmaland.sms_register_integrationAPI.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.shawrmaland.sms_register_integrationAPI.dto.PromoPoint;

@Service
public class SmsServicesImpl implements SmsServices {

	private static final Logger logger = LoggerFactory.getLogger(SmsServices.class);
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${alt.bearer}")
	private String altBearer;

	@Value("${alt.url}")
	private String altUrl;

	@Value("${com.from}")
	private String comFrom;

	@Value("${product.type}")
	private String productType;
	
	

	@Override
	public String sendSMSMessege(PromoPoint promoPoint) {
		
		

		// Create URL
		String url = urlBuilder(altUrl);
		System.out.println("URL: " + url);

		// Create headers
		HttpHeaders headers = createHeaders();
		MultiValueMap<String, String> formData = createFormData(promoPoint);

		// Create HttpEntity containing headers and form data
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(formData, headers);

		// Create RestTemplate instance
		//RestTemplate restTemplate = new RestTemplate();

		// Send POST request
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
		
		if (response.getStatusCode() == HttpStatus.OK) {
			logger.info(" SMS Successfully sent To: " + promoPoint.getPhoneNumber());

			response.getBody();

		} else {
			logger.error("  Faild to Send SMS message"  );
			// TODO: Create proper custom exception class.
			throw new RuntimeException(
					response.getStatusCode() + " Cannot Send SMS message " + response.getBody());
		}

		// Print response
		System.out.println("Response: " + response.getBody());

		return response.getBody();

	}

	/**
	 * @ Create the Url for SMS service
	 * 
	 * @author ALL
	 * @since JDK17
	 * @return String {@alt}
	 **/
	private String urlBuilder(String althryaUrl) {
		/************
		 * Sample URL for TST environment: https:**************************
		 *********************/
		StringBuilder uri = new StringBuilder(250);
		uri.append(altUrl);
		uri.append("/api");
		uri.append("/v1");
		uri.append("/campaign");
		uri.append("/infinite");
		return uri.toString();
	}

	/**
	 * @apiNote ALT Headers
	 * @return HttpHeaders
	 */
	private HttpHeaders createHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED);
		headers.setBearerAuth(altBearer);
		return headers;
	}

	private MultiValueMap<String, String> createFormData(PromoPoint promoPoint) {
		MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
		formData.add("from", comFrom);
		formData.add("phone_number", promoPoint.getPhoneNumber());
		formData.add("product_type", productType);
		formData.add("message_text", promoPoint.getMessage());
		return formData;
	}

}
