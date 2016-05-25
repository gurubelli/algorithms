package com.gurubelli.surya.concurrency;

public class MyVolatile {

	private volatile boolean running = true;
	
	//
	
	public void test() {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int counter = 0;
				while(running) {
					counter++;
				}
				
			}
		}).start();
	
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(running) {
					try {
						Thread.sleep(100);
					}catch(InterruptedException ex) {
						
					}
					System.out.println("Thread 2 finishing");
					running = false;
				}
			}
		}).start();
	}
	
	public static void main(String[] args) {
		new MyVolatile().test();
	}
}
