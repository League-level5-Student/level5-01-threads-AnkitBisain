package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool {

	Thread[] threads;
	ConcurrentLinkedQueue<Task> taskQueue;
	
	public ThreadPool(int totalThreads) {
		// TODO Auto-generated constructor stub
		threads = new Thread[totalThreads];
		taskQueue = new ConcurrentLinkedQueue<Task>();
		for (int i = 0; i < threads.length; i++) {
			Worker w = new Worker(taskQueue);
			threads[i] = new Thread(w);
		}
	}

	public void addTask(Task t) {
		// TODO Auto-generated method stub
		taskQueue.add(t);
		
	}

	public void start() {
		// TODO Auto-generated method stub
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

		// TODO Auto-generated method stub
		

}
