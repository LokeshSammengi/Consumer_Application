//find by id
package com.practice.Runners;

import java.net.http.HttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.project.modelvo.ToursitVO;

import tools.jackson.databind.ObjectMapper;

//@Component
public class FindByIdTestRunners implements CommandLineRunner {

	@Autowired
	private RestTemplate template;
@Override
public void run(String... args) throws Exception {
	String endpointUrl = "http://localhost:6060/BootRestProj09-MiniProjectTourist/toursitapi/find/{id}";
	
	//consume the enduser
	ResponseEntity<String> resp = template.exchange(endpointUrl,HttpMethod.GET, null,String.class,111);
	System.out.println("Response entity value "+resp.getBody());
	System.out.println("Response entity status code"+resp.getStatusCode());
	System.out.println("Response entity headers"+resp.getHeaders());
	
	//convert json content to object(deserialization) 
	ObjectMapper mapper = new ObjectMapper();
	ToursitVO vo = mapper.readValue(resp.getBody(),ToursitVO.class);
	System.out.println("Json to vo object"+vo);
	
	
	System.exit(0);
	
}
}
