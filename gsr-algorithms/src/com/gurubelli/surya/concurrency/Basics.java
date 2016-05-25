package com.gurubelli.surya.concurrency;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Basics {

	AtomicInteger count = new AtomicInteger();
	AtomicReference<BigInteger> reference = new AtomicReference<>();

	private static boolean ready;
	private static int number;

	private static class ReaderThread extends Thread {
		public void run() {
			while (!ready) {  //If you do not have any statement .. 
				//System.out.println("In while loop");
				// Thread.yield();
			}

			System.out.println(number);
		}
	}

	public static void main(String[] args) throws InterruptedException {

		
		Thread myThread = new ReaderThread();
		myThread.setName("Reader Thread");
		myThread.start();
		Thread.sleep(100);
		ready = true;
		number = 42;
		
		
	}

	class VolatileExample {
		int x = 0;
		volatile boolean v = false;

		public void writer() {
			x = 42;
			v = true;
		}

		public void reader() {
			if (v == true) {
				// uses x - guaranteed to see 42. If it is in memory then it
				// will be visible to all threads. Local cache will be
				// invalidated.
				// Under new memory model the writes to volatile
				// anything that was visible to thread A when it writes to
				// volatile field f becomes visible to thread B when it reads f.
			}
		}
	}

	// Volatile : Updates to a variable are propagated predictably to other
	// threads.
	// https://www.cs.umd.edu/~pugh/java/memoryModel/jsr-133-faq.html
	// Final fields : Once object is constructed properly .. .memory reordering
	// will not happen .. it m
	// http://www.javamex.com/tutorials/synchronization_final.shtml
	// the pointer to the object data could be stored to main memory and
	// accessed before the fields themselves have been committed

	// Use volatile only when writes to variables do not depend on its current
	// value or you can ensure that only a single thread ever updates the value
	// The variable does not participate in invariants with other state
	// variables
	// Locking is not required for any other reason while the variable is being
	// accessed.

}
