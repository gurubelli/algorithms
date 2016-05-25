package com.gurubelli.surya.concurrency;

public class JavaMemoryModel {

	
	//aVariable = 3
	//Compilers may generate instructions in different order than "obvious" one suggested by source code
	//Store variables in registers than memory
	//processors may execute instructions in parallel or out of order
	//caches may vary the order in which writes to variables are committed to main memory
	//values stored in local processor may not be visible to other processors
	//The above factors can prevent 
	
}

class ReOrdering {
	
	String a = null;
}

class FinalFieldExample {
	  final int x;
	  int y;
	  static FinalFieldExample f;
	  public FinalFieldExample() {
	    x = 3;
	    y = 4;
	  }

	  static void writer() {
	    f = new FinalFieldExample();
	  }

	  static void reader() {
	    if (f != null) {
	      int i = f.x;
	      int j = f.y;
	    }
	  }
	}