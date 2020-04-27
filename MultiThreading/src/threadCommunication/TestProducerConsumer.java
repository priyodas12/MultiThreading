package threadCommunication;

import java.util.LinkedList;
import java.util.Queue;

public class TestProducerConsumer {
	public static void main(String[] args) {
		Queue sharedQueue=new LinkedList();
		
		Producer p=new Producer(sharedQueue, 2);
		Consumer c=new Consumer(sharedQueue,2);
		
		p.start();
		c.start();
		
	}

}
