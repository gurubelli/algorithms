package com.gurubelli.surya.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class PerformanceAndScalability {

	
	//Performance :: The goal is usually do the same work with less effort O(n2) to o(nlogn)
	//Scalability : Trying to find a ways to parallelize the problem so you can take advantage of 
	//additional processing resources to do more work with more resources.
	//How fast and How Much (aspects are scalability , trhoughput and capacity)
	
	//Speedup <=  1/F + 1-F/N ( N is number of processors.. F is the fraction that executed sequentially
	
	
}

class WorkerThread extends Thread {

	private final BlockingQueue<Runnable> queue;

	public WorkerThread(BlockingQueue<Runnable> queue) {
		// TODO Auto-generated constructor stub
		this.queue = queue;
	}

	public void run() {

		while (true) {
			try {
				Runnable task = queue.take();
				task.run();
			} catch (InterruptedException ex) {
				break;
			}
		}
	}
}

//Synchronized List guards entire queue with the single lock that is held for duration of offer and remove call
//ConcurrentLinkedQueue uses sophisticated non blocking queue algorithm that uses atomic references to update
//individual pointers. In one, the entire insertion or removal is serialized..in the other only updates to individual pointers
//are seralized

//Lock Splitting :  Splitting one lock to two
//Lock Striping  :  Splitting one lock to many
//11.3  Costs Introduced by threads 
//11.3.1 : Context Switching : Saving the execution context of the currently running thread and restoring 
// the execution context of newly  scheduled thread (vmstat ...)
//11.3.2 Memory Synchronization ::  Contended or Uncontend (...
//  A locking that can be proven that never contended 
// Most JVMs use escape analysis to identify certain locks can be eliminated that is called Lock Elision : 
//Lock coarsening might combine locks into single lock acquisition and release 
//Synchronization creates traffic on the shared memory bus. This bus has limited bandwidth and is shared across all processors
//11.3.3 Blocking : Uncontended synchronization can be handled entirely within the JVM 
//Contend synchronization may reuires OS activity ..The JVM can implement blocking either via spin-waiting  (repeatedly trying to acquire the lock until it 
// succeeds. 
//11.4  Reducing Lock Contention : Serialization hurts scalability and that context switch hurts performance. 
//How often that lock is requested and how long it is held once acquired.
//There are 3 ways to reduce the lock contention 
// Reduce the duration of which locks are held
//Reduce the frequency with which locks are reuested 
//Replace exlcusive locks with coordination mechanism that permit greater concurrency.
//11.4.1 : Narrowing Lock Scope --
//11.4.2 : Reducing lock granularity -- Lock splitting and lock striping ..
//if a lock guards more than one state variable ..it is better to spilt lock into multiple locks 
//Lock splitting can be sometimes extended to partition locking on a variablesized set of independent objects 
//Implementation of concurrent hash map uses 16 locks each of which gurads 1/16 of hash buckets  16 .. writers ..
//Hot fields .. for e.g size of hash map .. you can keep the counter to keep track of 
//Concurrent Hashmap avoids this problem by having size enumerate the stripes and up the number of elements in each strips
//by caching the collection size in volatile 
//11.4.5 ..Alternatives to Exclusive locks 
//ReadWriteLock -- Multiple reader and single writer .. read mostly data structures .. read only you can make as immutable
//Atomic variables ..compare and swap
//Monitoring CPU utilization ::: vmstat , isostat (perfmmon
//11.6 : Reducing Context Switch Overhead 
//