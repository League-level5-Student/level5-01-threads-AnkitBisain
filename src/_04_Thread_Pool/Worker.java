package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable {
	ConcurrentLinkedQueue<Task> taskQueue;
	
	Worker(ConcurrentLinkedQueue<Task> taskQueue){
		this.taskQueue = taskQueue;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < taskQueue.size(); i++) {
			Task t = taskQueue.remove();
			t.perform();
		}

		
		
	}


}
