package com.gurubelli.surya.concurrency;

public class AtomicVariablesAndNonBlocking {
	
	/*
	 * 15.1 Disadvantage of locking 
	 * Locking exclusive access ..	suspending and resuming thread has lot of overhead 
	 * Volatile : light weight synchronization , do not involve context switches or thread scheduling 
	 * However, volatile can not be used to construct atomic compound actions
	 * Volatile can not be used if one variable depends on other , when the new value of a variable 
	 * depends on its old value.
	 * 
	 *  15.2 : Hardware support for concurrency
	 *  Optimistic approach :: Compare and Set
	 *  --> A memory location V , old value A and new value B
	 *  --> 
	 *  Disadvantage of CAS : It forces the caller to deal with the contention
	 *  
	 *  15.3 Atomic variables 
	 */

}
 
class SimulatedCas {
	
	private int value;
	
	public synchronized int getValue() {
		return value;
	}
	
	public synchronized int compareAndSwap(int expectedValue, int newValue) {
		
		int oldValue = value;
		if (oldValue == expectedValue) {
			value = newValue;
		}
		
		return oldValue;
		
	}
	
	public synchronized boolean compareAndSet(int expectedValue, int newValue) {
		
		return (expectedValue == compareAndSwap(expectedValue,newValue));
	}
	
}