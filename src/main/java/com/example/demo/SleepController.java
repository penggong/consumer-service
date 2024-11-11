package com.example.demo;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SleepController {
	
	@Resource
	private RestTemplate restTemplate;
	
	@GetMapping("/sleep")
	public String sleep(String time) {
		System.out.println("sleep");
		
		try {
			TimeUnit.MILLISECONDS.sleep(Long.valueOf(time));
		} catch (NumberFormatException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "sleep ok";
	}
	
	
	@GetMapping("/sleepGet")
	public String sleepGet(String time, String targetSvc, String targetApi) {
		System.out.println("sleep");
		
		try {
			TimeUnit.MILLISECONDS.sleep(Long.valueOf(time));
		} catch (NumberFormatException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResponseEntity<String> resEntity = null;
		String url = "Http://" + targetSvc + "/" +targetApi;
		System.out.println("url:"+url);
		
        resEntity = restTemplate.getForEntity(url, String.class);
		
		return "sleep ok:"+resEntity;
	}
	
	

}
