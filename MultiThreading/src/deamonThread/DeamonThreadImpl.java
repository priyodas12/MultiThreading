package deamonThread;

public class DeamonThreadImpl implements Runnable{
	
	
	@Override
	public void run() {
		
		for(int i=0;i<10;i++) {
			try {
				Thread.sleep(Thread.currentThread().isDaemon()?1500:1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println((Thread.currentThread().isDaemon()?"Deamon":"user")+" Thread counts :"+i);
		}
		
	}

	public static void main(String[] args) throws InterruptedException {
		
		Thread t1=new Thread(new DeamonThreadImpl());
		Thread t2=new Thread(new DeamonThreadImpl());
		t1.setDaemon(true);
		
		//both starts at same time but once User Thread finishes daemon thread  also automatically finishes
		t1.start();
		t2.start();

	}

	

}
