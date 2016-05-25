package com.gurubelli.surya.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadLocal {

	private static class Thread1 extends Thread {
		
		private static final AtomicInteger nextId = new AtomicInteger(0);
		private static ThreadLocal<Integer> threadId = new ThreadLocal<Integer>() {

			@Override
			protected Integer initialValue() {
				return nextId.getAndIncrement();
			}

		};

		public void run() {
			System.out.println(threadId.get());
		}
		
		private static InheritableThreadLocal threadLocal = new InheritableThreadLocal<>();
	}

	private static class MyRunnable implements Runnable {
		// Atomic integer containing the next thread ID to be assigned
		private 	 final AtomicInteger nextId = new AtomicInteger(0);
		private  ThreadLocal<Integer> threadId = new ThreadLocal<Integer>();

		public void run() {
			threadId.set( (int) (Math.random() * 100D) );
		    
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
    
            System.out.println(threadId.get());
		}
		
		
	}

	public static void main(String[] args) throws InterruptedException {
		
		MyRunnable sharedRunnable = new MyRunnable();
		
		Thread thread1 = new Thread(sharedRunnable);
		Thread thread2 = new Thread(sharedRunnable);
		
		thread1.start();
		thread2.start();
	
		//wait till thread1 terminates
		thread1.join();
		thread2.join();
		
	}

}
