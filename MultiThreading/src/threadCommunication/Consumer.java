package threadCommunication;

import java.util.Queue;
import java.util.Random;

public class Consumer extends Thread {
	
	private Queue sharedQueue;
	private int maxSize;

	public Consumer(Queue sharedQueue, int maxSize) {
		super();
		this.sharedQueue = sharedQueue;
		this.maxSize = maxSize;
	}
	
	@Override
	public void run() {
		while(true) {
			synchronized (sharedQueue) {
				while(sharedQueue.size()==0) {
					try {
						sharedQueue.wait();
						System.out.println("Queue is Empty");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int k=(int) sharedQueue.poll();
				System.out.println("Removing "+k);
				sharedQueue.notify();
				
			}
		}
	}

}
