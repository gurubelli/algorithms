package com.gurubelli.surya.concurrency;

public class CompletionService {

	//Combines ExecutorService and BlockingQueue
	//Cancellation 
	
	//Abnormal Thread exit
	//JVM Shutdown
	//Shutdown hooks :::
	//Daemon thread : JVM thread exits .. perform inventory ..and see if only daemon threads ..JVM 
	//any remaining threads are abandoned .. finally block wont get executed .. only use it for 
	//house keeping jobs
	//Finalizers :  Executed by JVM thread .. extra care to access the state ..avoid it as much as you can .. only 
	//exception is to manage the objects that hold resources acuired by native code.
	//8.. Thread starvation deadlock .. With Single Executor.. One task is waiting for other task to finisth both submitted
	//to the same executor
	
}

class MyRunnable implements Runnable {
	

	public void run() {
		Throwable thrown = null;
		try {
		while (!isInterrupted())
		//Run
			System.out.println("Hello");
		} catch (Throwable e) {
		thrown = e;
		} finally {
		//threadExited(this, thrown);
		 // throw thrown;
		}
}

	private boolean isInterrupted() {
		// TODO Auto-generated method stub
		return false;
	}
	
}