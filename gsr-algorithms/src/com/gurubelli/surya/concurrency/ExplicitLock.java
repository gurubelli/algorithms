package com.gurubelli.surya.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExplicitLock {

	//
	
	public void testLock(){
		Lock  lock = new ReentrantLock();
		
		lock.lock();
		lock.tryLock();
		
		try {
			//update object state 
			//catch exceptions and restore invariants if necessary
		} finally {
			lock.unlock();
		}
				
	}
	
	//13.1.1 Timed and Polled lock acquisition : tryLock() ..probabilistic deadlock avoidance
	//Use it if you need advanced features : timed, polled , or interruptible lock acquisition 
	//fair queuing or non-block structured locking 
}
