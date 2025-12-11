//find by id
package com.practice.Runners;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.project.modelvo.ToursitVO;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

//@Component
public class SaveToursitTestRunners implements CommandLineRunner {

	@Autowired
	private RestTemplate template;
@Override
public void run(String... args) throws Exception {
	String endpointUrl = "http://localhost:6060/BootRestProj09-MiniProjectTourist/toursitapi/save";
	
	String touristJson = "{\n" +
			"  \"tname\": \"Rajesh Kumar\",\n" +
			"  \"taddrs\": \"Hyderabad, Telangana\",\n" +
			"  \"dob\": \"1995-08-12\",\n" +
			"  \"startLocation\": \"Hyderabad\",\n" +
			"  \"endLocation\": \"Goa\",\n" +
			"  \"expenditure\": 15000.75\n" +
			"}";
	
	//request headers
	HttpHeaders headers= new HttpHeaders();
	headers.setContentType(MediaType.APPLICATION_JSON);
	//prepare http entity object having headers ,body
	HttpEntity<String> entity = new HttpEntity<String>(touristJson,headers);
	//consume the endpoint
	ResponseEntity<String> resp = template.exchange(endpointUrl, HttpMethod.POST,entity ,String.class);
	//display the result
	System.out.println("Response body :"+ resp.getBody());
	System.out.println("Response status "+ resp.getStatusCode());
	System.out.println("Response headers :"+resp.getHeaders());
	
	System.exit(0);
	
}
}
