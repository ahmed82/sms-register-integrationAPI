package com.shawrmaland.sms_register_integrationAPI.util;
import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author Dr. AAL
 * 
 *
 */
@Configuration
public class RestTemplateConfig {
	
	
	  @Bean 
	  public RestTemplate restTemplate (RestTemplateBuilder builder) {
		  return builder
				  .setConnectTimeout(Duration.ofSeconds(30))
		            .setReadTimeout(Duration.ofSeconds(30))
		            .build();
	  }

	
	

}