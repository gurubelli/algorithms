package com.gurubelli.surya.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommaArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		  String str = "Paul ,John ,George ,Ringo";
	      System.out.println("String: " + str);
	 
	      List<String> list = null;
	 
	      list = Arrays.asList(str.split("\\s*,\\s*"));
	 
	      System.out.println("ArrayList: " + list);
	      
	      //Split only with ,
	      list = Arrays.asList(str.split(","));
	      
	      System.out.println("ArrayList splitting with only comma: " + list);
	}

}
