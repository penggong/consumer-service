package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.util.OOMTest;

@RestController
public class OOMController {
	
	@GetMapping("/oom")
	public String Oom(int count) {
		System.out.println("oom");
		OOMTest.oom(count);
		return "oom";
	}

}
