package com.gurubelli.surya.concurrency;

public class SharingObjects {

	// No visibility
	private static boolean ready;
	private static int number;

	private static class ReaderThread extends Thread {
		public void run() {
			while(!ready) {
				Thread.yield(); //If you do not have yield or sys out .. then this is running in definetly 
				//There is no guarantee that the reading thread will see a value written by another thread on a timely basis or 
			}
			System.out.println(number);
		}
	}
	public static void main(String[] args) throws InterruptedException {

		new ReaderThread().start();
		number = 42;
		ready = true;
		
		//For example in the absence of synchronization, the Java Memory Model permits the compiler to reorder the operations and cache values in the registers and permits 
		//CPUs to reorder operations and cache values in processor-specific caches.
	}
/**
	<b>Out-of-thin-air safety 64 bit numeric values double and long 
	   3.1.4 :  Volatile variables.. Writing volatile variable is like exiting a synchronized block and
	   reading a volatile variable is like entering synchronized block 
	   The most common use of volatile is completion, interruption, or status flag
	   volatile are not strong enough to make the increment operation (count++) atomic, unless you can guarantee that the variable is 
	   written only from a single thread.
	   Jvm option -server
	   Locking can guarantee both the visibility and atomicity. Volatile variables can only guarantee visibility.
	   Writes to the variable does not depend on the current value or you can ensure that only a single thread ever updates the value
	   The variable does not participate in invariants with other state variables 
	   Locking is not required for any other reason while variable is being accessed</b>
*/	
	/**
	 * Invariant is condition or a relation that is always true. 
	 * 
	 * An invariant is a condition that is true when the associated lock is being set. Once the lock is set, the invariant can be false. However, the code holding the 
	 * the lock must reestablish the invariant before releasing the lock.
	 */
	
	/*** PUBLICATION AND ESCAPE 
	 * 
	 * 
	 */
}
