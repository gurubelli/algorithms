package com.gurubelli.surya.concurrency.deadlocks;

class MainThread {
	Object sharedLock = new Object(); // package-private

	public void timeConsuming() throws InterruptedException {
		Thread child = new Thread() {
			@Override
			public void run() {
				increment();
			}
		};

		child.start();
		child.join(); // Waits for child to die; deadlock
		// Control flow never reaches here
	}

	public void increment() {
		synchronized (sharedLock) { // Deadlock as lock is unavailable; child
									// never dies
			// ...
		}
	}
}

public class SubclassSuperClass extends MainThread implements Runnable {
	@Override
	public void run() {
		synchronized (sharedLock) {
			try {
				super.timeConsuming();
				// ...
			} catch (InterruptedException ie) {
				Thread.currentThread().interrupt(); // Restore interrupted
													// status
			}
		}
	}

	public static void main(String[] args) {
		new Thread(new SubclassSuperClass()).start();
	}
}