//find by id
package com.practice.Runners;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class DeleteTouristTestRunner implements CommandLineRunner {

	@Autowired
	private RestTemplate template;
@Override
public void run(String... args) throws Exception {
	String endpointUrl = "http://localhost:6060/BootRestProj09-MiniProjectTourist/toursitapi/remove/{id}";

	ResponseEntity<String>response = 
					template.exchange(endpointUrl,HttpMethod.DELETE,null,String.class,111);
	System.out.println("Response message :"+response.getBody());
					
	System.exit(0);
	
}
}
