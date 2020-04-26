package threadCreation;

public class ThreadCreationByInterface implements Runnable {

	public int  count =10;
	
	public ThreadCreationByInterface(String name) {
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
	
	public static void main(String[] args) {

		Thread t1=new Thread(new ThreadCreationByInterface("t1"));
		Thread t2=new Thread(new ThreadCreationByInterface("t2"));
		
		t1.start();
		t2.start();

	}

}
