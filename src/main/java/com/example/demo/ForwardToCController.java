package com.example.demo;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ForwardToCController {
	
	@Resource
	private RestTemplate restTemplate;
	
	@RequestMapping("/forwardToC")
	public String forward(String targetType, String targetApi) {
		ResponseEntity<String> resEntity = null;
		String url = "";
		if(targetType.equals("sleep")){
		    url = "http://details3:8080/"+targetType+"?time=" +targetApi;
		}
		if(targetType.equals("createObjectLimitCount")){
                    url = "http://details3:8080/"+targetType+"?time=" +targetApi;
                }
		if(targetType.equals("oom")){
                    url = "http://details3:8080/"+targetType+"?count=" +targetApi;
                }
		System.out.println("url:"+url);
		resEntity = restTemplate.getForEntity(url, String.class);
        //resEntity = restTemplate.postForEntity(url, "", String.class);
        return resEntity.getBody();
	}
	
        @RequestMapping("/forwardTo/{targetType}/{targetApi}")
	public String forwardTo(@PathVariable String targetType, @PathVariable String targetApi) {
		ResponseEntity<String> resEntity = null;
		String url = "";
		if(targetType.equals("sleep")){
		    url = "http://details3:8080/"+targetType+"?time=" +targetApi;
		}
		if(targetType.equals("createObjectLimitCount")){
                    url = "http://details3:8080/"+targetType+"?time=" +targetApi;
                }
		if(targetType.equals("oom")){
                    url = "http://details3:8080/"+targetType+"?count=" +targetApi;
                }
		System.out.println("url:"+url);
		resEntity = restTemplate.getForEntity(url, String.class);
        //resEntity = restTemplate.postForEntity(url, "", String.class);
        return resEntity.getBody();
	}
}
