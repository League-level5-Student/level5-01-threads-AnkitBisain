package _03_Threaded_Reverse_Greeting;

import java.util.Arrays;;

public class ThreadedReverseGreeting {
  //Write a program that creates a thread (Thread 1) that creates another thread (Thread 2); 
  //Thread 2 creates Thread 3; and so on, up to Thread 50. 
  //Each thread should print "Hello from Thread <num>!", 
  //but you should structure your program such that the threads print their greetings in reverse order.
	
	/* HINT: You will most likely need to do this with recursion */
	public static void main(String[] args) {
		Thread[] threads = new Thread[50];
		for(int i = 0; i < 49; i++) {
			int k = i;
			threads[i] = new Thread(() -> {
				try {
					doStuff(k+1,threads[k+1]);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}
		threads[49] = new Thread(() -> System.out.println("Hello from Thread 50!"));
		threads[0].start();
	}

	public static void doStuff(int i, Thread t) throws InterruptedException {
		t.start();
		t.join();
		System.out.println("Hello from Thread " + i + "!");
	}
}
