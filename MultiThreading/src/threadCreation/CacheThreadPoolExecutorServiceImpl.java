package threadCreation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CacheThreadPoolExecutorServiceImpl {

	public static void main(String[] args) {
		ExecutorService executor=Executors.newCachedThreadPool();
		//ExecutorService executor2=Executors.newWorkStealingPool();
		
		Runnable r1=()->{
			for(int i=10;i<100;i+=10) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+" count "+i);
			}
		};
		
		executor.submit(r1);
		executor.submit(r1);
		//executor2.shutdown();
		
		executor.shutdown();

	}

}
