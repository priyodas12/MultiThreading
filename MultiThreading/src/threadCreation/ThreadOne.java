package threadCreation;

public class ThreadOne extends Thread {
	
	public int count =(int) (Math.random()*100);
	public ThreadOne(String name) {
		System.out.println(name+" Starting....upto "+count);
	}
	
	@Override
	public void run() {
		for(int i=0;i<count;i++) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("counting..."+i);
		}
	}
}
