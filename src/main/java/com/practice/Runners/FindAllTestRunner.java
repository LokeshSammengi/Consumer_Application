//find by id
package com.practice.Runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.project.modelvo.ToursitVO;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

//@Component
public class FindAllTestRunner implements CommandLineRunner {

	@Autowired
	private RestTemplate template;
@Override
public void run(String... args) throws Exception {
	String endpointUrl = "http://localhost:6060/BootRestProj09-MiniProjectTourist/toursitapi/all";
	
	//consume the enduser
	ResponseEntity<String> resp = template.exchange(endpointUrl,HttpMethod.GET, null,String.class);
	//convert the string into the list by using object mapper
	ObjectMapper mapper = new ObjectMapper();
	List<ToursitVO>list=mapper.readValue(resp.getBody(),new TypeReference<List<ToursitVO>>() {});
	list.forEach(System.out::println);
	
	
	
//	
//	System.out.println("Response entity value "+resp.getBody());
//	System.out.println("Response entity status code"+resp.getStatusCode());
//	System.out.println("Response entity headers"+resp.getHeaders());
//	
//	//convert json content to object(deserialization) 
//	ObjectMapper mapper = new ObjectMapper();
//	ToursitVO vo = mapper.readValue(resp.getBody(),ToursitVO.class);
//	System.out.println("Json to vo object"+vo);
//	
	
	System.exit(0);
	
}
}
