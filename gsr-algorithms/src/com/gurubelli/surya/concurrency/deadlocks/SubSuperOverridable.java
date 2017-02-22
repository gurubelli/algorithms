package com.gurubelli.surya.concurrency.deadlocks;

public class SubSuperOverridable extends SuperClass {

	@Override
	public void doSomething() { // overridden

		synchronized (sharedLock) {

		}

	}

	public static void main(String[] args) {
		SuperClass ss = new SubSuperOverridable();
		ss.timeConsuming();

	}
}

abstract class SuperClass {
	// Have shared locak
	final Object sharedLock = new Object();

	public void timeConsuming() {
		synchronized (sharedLock) {
			doSomething();
		}
	}

	abstract void doSomething();

}
