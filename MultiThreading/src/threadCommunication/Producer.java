package threadCommunication;

import java.util.Queue;
import java.util.Random;

public class Producer extends Thread{
	
	private Queue sharedQueue;
	private int maxSize;

	public Producer(Queue sharedQueue, int maxSize) {
		super();
		this.sharedQueue = sharedQueue;
		this.maxSize = maxSize;
	}

	@Override
	public void run() {
		while(true) {
			synchronized (sharedQueue) {
				while(sharedQueue.size()==maxSize) {
					try {
						sharedQueue.wait();
						System.out.println("Queue is Full");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				Random r=new Random();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int i=r.nextInt();
				System.out.println("Adding "+i);
				sharedQueue.add(i);
				sharedQueue.notify();
			}
		}
	}
	

}
