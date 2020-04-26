package threadCreation;

public class ThreadByAnnonymousInterface {
	
	static Runnable r1=()->{
		for(int i=10;i<100;i+=10) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" count "+i);
		}
	};
	
	static Runnable r2=()->{
		for(int i=1;i<10;i+=2) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" count "+i);
		}
	};

	public static void main(String[] args) {
		new Thread(r1).start();
		new Thread(r2).start();
	}

}
