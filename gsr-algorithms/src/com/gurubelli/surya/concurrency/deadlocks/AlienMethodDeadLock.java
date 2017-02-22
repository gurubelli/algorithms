package com.gurubelli.surya.concurrency.deadlocks;

// The lock is defined in class Base and is accessible to classes Deadlock and
// SimpleThread
class Base {
	static final Object sharedLock = new Object();
}

public final class AlienMethodDeadLock implements Runnable {
	private SimpleThread st = new SimpleThread();

	public final static Object internalLock = new Object();

	@Override
	public void run() {
		synchronized (Base.sharedLock) {
			try {
				st.doSomething(); // Call to alien method
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt(); // Restore interrupted
													// status
			}
		}
	}

	public static void main(String[] args) {
		new Thread(new AlienMethodDeadLock()).start();
	}
}

final class SimpleThread {
	public void doSomething() throws InterruptedException {
		Thread child = new Thread() {
			@Override
			public void run() {
				synchronized (Base.sharedLock) {
					// ...
				}
			}
		};

		child.start();
		child.join(); // Waits for child to die; deadlock occurs as alien method
						// is requesting the same lock.. to avoid the dead lock
						// use internal lock
	}

}
