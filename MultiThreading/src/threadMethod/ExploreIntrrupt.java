package threadMethod;

public class ExploreIntrrupt {

	public static void main(String[] args) {
		Thread t1=new Thread(new TestIntrrupt());
		Thread t2=new Thread(new TestIntrrupt());
		t1.start();
		t2.start();
		t1.interrupt();

	}

}

class TestIntrrupt implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(i+" from "+Thread.currentThread().getName());
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				System.out.println("am Intrrupted");
				e.printStackTrace();
			}
			
		}
	}
	
}