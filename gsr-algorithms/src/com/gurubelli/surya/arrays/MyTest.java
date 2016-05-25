package com.gurubelli.surya.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MyTest {

	AtomicInteger myCount = new AtomicInteger(0);
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Integer i = 10;
		 print(i);
		 System.out.println("I value " + i);
		 
		 Map<String,String> map = null;
		 map = printMap(map);
		 System.out.println("Valu of the map " + map);
		 
		 //
		 String str1 = new String("a");
		 String str2  = new String("a");
		
		if (str1 == str2) {
			System.out.println("Strings equal ");
		}
	}

	static int print(Integer j) {
		
		j = j+1;
		System.out.println("value " +j);
		return j;
	}
	
	static Map printMap(Map map) {
		
		map = new HashMap<>();
		return map;
	}
	
	public void atomic() {
		myCount.incrementAndGet();
	}
}
