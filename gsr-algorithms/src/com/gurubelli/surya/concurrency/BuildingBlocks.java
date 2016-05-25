package com.gurubelli.surya.concurrency;

import java.util.Vector;

public class BuildingBlocks<E> {

	/**
	 * 5.1.1 Synchronized Collections : Vector and Hashtable ..by encapsulating
	 * their state and synchronizing every public method so that only one thread
	 * at a time can access the collection state
	 * 
	 * Using
	 */

	// Client side locking on synchronized collections

	public Object getLast(Vector<E> list) {

		synchronized (list) {
			int lastIndex = list.size() - 1;
			return list.get(lastIndex);
		}

	}

	public void deleteLast(Vector<E> list) {
		synchronized (list) {
			int lastIndex = list.size() - 1;
			list.remove(lastIndex);
		}
	}
	//Iterator might throw exception.
	public void iterator(Vector<E> vector) {
		for (int i= 0; i < vector.size() ;i++) {
			System.out.println(vector.get(i));
		}
	}
	//5.1.3 Iterators and Concurrentmodification exception
	//Fail-fast : meaning that if they detect that the collection has changed since iteration began
	//Clone the collection then iterate the copy of the collection 
	//Hidden iterator 
	
	/*
	 * 5.2 Concurrent Collections
	 * ConcurrentHashMap, CopyOnWriteArrayList (replacement for synchronized list) 
	 * Replacing synchronized collections with concurrent collections can offer dramatic scalability improvements
	 * 
	 * Java 5.0 adds Queue and BlockingQueue 
	 * ConcurrentLinkedQueue, PriorityQueue
	 * 5.2.1 ConcurrentHashMap : It uses entire different locking strategy that offers better concurrency and scalability
	 * 
	 * Instead of synchronizing every method on a common lock , restricting access to single thread at time 
	 * Many reading threads can access the map concurrently , readers can access the map concurrently wit the writers , 
	 * and a limited number of writers can modify the map concurrently 
	 * 
	 * ConcurrentHashMap do not throw concurrent modification exception 
	 * size and isEmpty or approximation ..now not the exact count 
	 * 
	 * CopyOnWriteArrayList :: They implement mutability by creating and publishing a new copy of the collection every
	 * time it is modified. Iterators for the copy on write collections retain a reference to the backing array
	 * that was current at the start of iteration.
	 * 
	 * 5.3 Blocking Queues
	 *  
	 *  Blocking put and take methods as well as offer and poll 
	 *  
	 *  LinkedBlocingQueue or ArrayBlockingQueue 
	 *  
	 *  PriorityBlockingQueue  and SynchronousQueue (No storage for queue ..instead maintains list of queued threads...
	 *  
	 *  Deques and Work Stealing
	 *  
	 *  In work stealing design every consumer has it's own dequeue ..if a consumer exhausts the work in its dequeue 
	 *  it can steal work from the tail of someone's queue
	 *  
	 *  5.4  Blocking and Interruptible Methods
	 *  When􀀃your􀀃code􀀃calls􀀃a􀀃method􀀃that􀀃throws􀀃InterruptedException,􀀃then􀀃your􀀃method􀀃is􀀃a􀀃blocking􀀃method􀀃too,􀀃and􀀃
		must􀀃have􀀃a􀀃plan􀀃for􀀃responding􀀃to􀀃interruption.􀀃For􀀃library􀀃code,􀀃there􀀃are􀀃basically􀀃two􀀃choices:􀀃
		
		Propagate the InterruptedException
		
		Restore the interrupt: By calling interrupted method ..sets the interrupted status
		
		5.5 Synchronizers 
		
		Synchronizer is any object that control flow of threads based on its state. Semaphores, barrier and latches
		
	 * 
	 */
	
}
