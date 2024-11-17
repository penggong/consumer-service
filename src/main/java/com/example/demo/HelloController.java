package com.example.demo;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
	
	@GetMapping("/health")
	public String health() {
		System.out.println("hello");
		return "hello";
	}
	
	@GetMapping("/createObject")
	public void createObject() {
		List<HeapOOM> list = new ArrayList<HeapOOM>();
		System.out.println("hello list");
		while(true) {
			list.add(new HeapOOM());
		}
		
	}

	@GetMapping("/createObjectLimitCount")
        public String createObject(int count) {
                List<HeapOOM> list = new ArrayList<HeapOOM>();
                System.out.println("hello list count");
		for(int i=0;i<=count;i++){
                        list.add(new HeapOOM());
                }
		return "count ok";

        }
	
	@GetMapping("/createObjectSleep")
	public void createObjectSleep() {
		List<HeapOOM> list = new ArrayList<HeapOOM>();
		System.out.println("hello list");
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list.add(new HeapOOM());
		}
		
	}
	
	 public static final int _1MB = 1024 * 1024;
	 static List<byte[]> byteList = new ArrayList<>();

	
	@GetMapping("/createByteSleep")
	public void createByteSleep() {
		 for (int i = 0; ; i++) {
           byte[] bytes = new byte[_1MB*10];
           byteList.add(bytes);
           System.out.println(i + "MB");
           memPrint();
           try {
               Thread.sleep(1000);
           } catch (Exception e) {
           }
	    }
		
	}
	
	 static void memPrint() {
	       for (MemoryPoolMXBean memoryPoolMXBean : ManagementFactory.getMemoryPoolMXBeans()) {
	           System.out.println(memoryPoolMXBean.getName() +
	                   "  committed:" + memoryPoolMXBean.getUsage().getCommitted() +
	                   "  used:" + memoryPoolMXBean.getUsage().getUsed());
	       }
	   }
	
	static class HeapOOM{
		
	}
	
	@GetMapping("/cpu/{args}")
	public void cpu(@PathVariable(name="args")String args ) throws InterruptedException {
		testCPU(args);
		
	}
	
	@GetMapping("/cpuN/{args}")
	public void cpuN(@PathVariable(name="args")int args ) {
		fib(args);
		
	}
	
	public void testCPU(String args) throws InterruptedException {
		while(true) {
			System.out.println("hello true");
		}
	}
	
	public long fib(int n) {
		if (n <= 1) {
			return n;
		}else {
			return fib(n-1) + fib(n-2);
		}
	}
	
}
