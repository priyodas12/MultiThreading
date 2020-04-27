package threadMethod;

public class ExploreJoin {

	public static void main(String[] args) throws InterruptedException {
		Thread t1=new Thread(new TestJoin());
		Thread t2=new Thread(new TestJoin());
		t1.start();
		t1.join(3000);
		t2.start();
		
	}

}

class TestJoin implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i+" from "+Thread.currentThread().getName());
		}
	}
	
}
