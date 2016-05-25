package com.gurubelli.surya.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer {

	public static void main(String[] args) {

		BlockingQueue<String> queue = new LinkedBlockingQueue<>();
		new Thread(new Producer(queue)).start();
		new Thread(new Consumer(queue)).start();

	}

}

class Producer implements Runnable {
	private final BlockingQueue<String> queue;

	@Override
	public void run() {

		for(int i =0; i<10; i++) {
			try {
				System.out.println("Produced " + String.valueOf(i));
				queue.put(String.valueOf(i));
			
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				Thread.currentThread().interrupt();
				
			}
		}
	}

	public Producer(BlockingQueue<String> queue) {
		this.queue = queue;
	}
}

class Consumer implements Runnable {
	BlockingQueue<String> queue;

	@Override
	public void run() {

		try {
			while (true) {
				String item = queue.take();
				System.out.println("Consumed " + item);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public Consumer(BlockingQueue<String> queue) {
		this.queue = queue;

	}
}
