package com.gurubelli.surya.concurrency;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceEx {

	// Each thread maintains two stack spaces .. One for Thread Stack another
	// for native code
	
  
}

class TaskExecutionWebServer {
	private static final int NTHREADS = 100;
	private static final Executor exec = Executors.newFixedThreadPool(NTHREADS);
	private static final ExecutorService  execSvc = Executors.newCachedThreadPool();
			
	public static void main(String[] args) throws IOException {
		ServerSocket socket = new ServerSocket(80);
		while (true) {
			final Socket connection = socket.accept();
			Runnable task = new Runnable() {
				public void run() {
					//handleRequest(connection);
				}
			};
			exec.execute(task);
		}
	}
}

//

class TaskExecutionPerWebServer {
	private static final int NTHREADS = 100;
	private static final Executor exec = Executors.newFixedThreadPool(NTHREADS);
	private static final ExecutorService  execSvc = Executors.newCachedThreadPool();
			
	public static void main(String[] args) throws IOException {
		ServerSocket socket = new ServerSocket(80);
		while (!execSvc.isShutdown()) {
			final Socket connection = socket.accept();
			Runnable task = new Runnable() {
				public void run() {
					//handleRequest(connection);
				}
			};
			exec.execute(task);
		}
	}
}

//Timer vs ScheduledThreadExecutor
//CompletionService :: Combines
