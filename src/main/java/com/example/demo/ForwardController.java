package com.example.demo;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ForwardController {
	
	@Resource
	private RestTemplate restTemplate;
	
	@RequestMapping("/forward")
	public String forward(String targetSvc, String targetApi, String cout, String time) {
		ResponseEntity<String> resEntity = null;
		String url = "http://" + targetSvc + "/" +targetApi;
		System.out.println("url:"+url);
		resEntity = restTemplate.getForEntity(url, String.class);
        //resEntity = restTemplate.postForEntity(url, "", String.class);
        return resEntity.getBody();
	}
	
	
	@GetMapping("/forwardPost")
	public String forwardPost(String targetSvc, String targetApi) {
		ResponseEntity<String> resEntity = null;
		String url = "http://" + targetSvc + "/" +targetApi;
		System.out.println("url:"+url);
		
        resEntity = restTemplate.postForEntity(url, "", String.class);
        return resEntity.getBody();
	}
	
	@GetMapping("/forwardGet")
	public String forwardGet(String targetSvc, String targetApi) {
		ResponseEntity<String> resEntity = null;
		String url = "http://" + targetSvc + "/" +targetApi;
		System.out.println("url:"+url);
		
        resEntity = restTemplate.getForEntity(url, String.class);
        return resEntity.getBody();
	}

}
