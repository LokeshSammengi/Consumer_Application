package com.practice.Runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PatchOperationTestRunner implements CommandLineRunner{

	@Autowired
	private RestTemplate template;
	
	
	@Override
   public void run(String... args) throws Exception {
	// TODO Auto-generated method stub
	//endpoint url
	String endpointURL = "http://localhost:6060/BootRestProj09-MiniProjectTourist/toursitapi/update/{l1}/{l2}/{l3}/{hikePercentage}";
	 //registry the factory
	template.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
	//consume the endpoint
	ResponseEntity<String> resp = template.exchange(endpointURL, HttpMethod.PATCH, null, String.class,"Goa","Delhi","ooty",30.5);
	System.out.println("Response body ::"+resp.getBody());
	System.out.println("Response status ::"+resp.getStatusCode());
	
	System.exit(0);
}
	
	
}
