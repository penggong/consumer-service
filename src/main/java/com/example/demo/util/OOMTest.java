package com.example.demo.util;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

//https://learn.lianglianglee.com/%E4%B8%93%E6%A0%8F
public class OOMTest {
	
	
    public static final int _1MB = 1024 * 1024;
	static List<byte[]> byteList = new ArrayList<>();
	public static void oom(int count) {
		
		
		if("0".equals(String.valueOf(count)) || "null".equals(String.valueOf(count)) || count <= 0) {
			count = 1;
		}
		count = count * _1MB;
	   
	   for (int i = 0; ; i++) {
	       byte[] bytes = new byte[count];
	       byteList.add(bytes);
	       System.out.println(i*count/_1MB + "MB");
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
	

}
