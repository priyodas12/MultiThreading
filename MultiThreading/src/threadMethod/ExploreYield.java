package threadMethod;

/**
 * A hint to the scheduler that the current thread is willing to yield
 * its current use of a processor. The scheduler is free to ignore this
 * hint.*/
public class ExploreYield {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Thread t1=new Thread(new TestYield());
		Thread t2=new Thread(new TestYield());
		t1.start();
		t1.yield();
		t2.start();
		t2.setPriority(7);
		
	}

}

class TestYield implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i+" from "+Thread.currentThread().getName());
		}
	}
	
}