package com.gurubelli.surya.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Synchronizers {

	// Latches ...
	// Ensuring that a computation does not proceed until all resources
	// initialized
	// Ensuring that a service does not start until other services on which it
	// depends have started ..
	// Waiting for all parties involved
	//-- Semaphores :: counting semaphore.. connection pools ..bounded collections.. bounded hash set
	//Barriers : All the threads must come together at the barrier point at the same time. 
	// latches are waiting for events.. Barriers are waiting for other threads
	//CyclicBarrier and Exchanger .. two party barrier 
}

class TestHarness {
	public long timeTasks(int nThreads, final Runnable task)
			throws InterruptedException {
		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(nThreads);
		for (int i = 0; i < nThreads; i++) {
			Thread t = new Thread() {
				public void run() {
					try {
						startGate.await();
						try {
							task.run();
						} finally {
							endGate.countDown();
						}
					} catch (InterruptedException ignored) {
					}
				}
			};
			t.start();
		}
		long start = System.nanoTime();
		startGate.countDown();
		endGate.await();
		long end = System.nanoTime();
		return end - start;
	}
}

class Preloader {

	private final FutureTask<String> future = new FutureTask<>(
			new Callable<String>() {

				@Override
				public String call() throws Exception {
					// TODO Auto-generated method stub
					return "asynTask";
				}
			});

	private final Thread thread = new Thread(future);

	public void start() {
		thread.start();
	}

	public String get() {

		try {
			return future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			//Throwable cause = e.getCause();
			//check if the data load exception (or something future runtime 
		}
		return null;

	}
}


