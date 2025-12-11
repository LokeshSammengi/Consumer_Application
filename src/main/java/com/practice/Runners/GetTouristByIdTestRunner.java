//find by id
package com.practice.Runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class GetTouristByIdTestRunner implements CommandLineRunner {

	@Autowired
	private RestTemplate template;

	//using getForEntity
	/*@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		String endpointUrl = "http://localhost:6060/BootRestProj09-MiniProjectTourist/toursitapi/find/{id}";
		//consume the endpoints
		ResponseEntity<String> response = template.getForEntity(endpointUrl, String.class,111);
		System.out.println("response entity object"+response);
		System.out.println("Responses body :"+response.getBody());
		System.out.println("response status code "+response.getStatusCode());
		System.out.println("Response headers :"+ response.getHeaders());
		//convert the json content to object content
		ObjectMapper mapper = new ObjectMapper();
		ToursitVO vo =mapper.readValue(response.getBody(),ToursitVO.class);
		System.out.println("after deserialization :"+vo.toString());
		
		System.exit(0);
	}*/
	//using getObject
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		String endpointUrl = "http://localhost:6060/BootRestProj09-MiniProjectTourist/toursitapi/find/{id}";
		//consume the endpoints
	String resp = template.getForObject(endpointUrl, String.class,111);
		System.out.println(resp.toString());
	}
	
	//
}
