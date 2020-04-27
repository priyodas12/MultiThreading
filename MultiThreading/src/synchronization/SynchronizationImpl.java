package synchronization;

import java.util.Date;

/*
 * modifier applicable for blocks and methods
 * variable,class cannot be declared.
 * 
 * If multiple thread trying to access same object and modify state then there will be data inconsistency(Race Condition)
 * problem to avoid at a time one thread can be allowed by using synchronized modifier in method or blocks
 * */
public class SynchronizationImpl {
	
	public static void main(String[] args) {
		//only one object and 4 threads are trying to access the same object
		TimeZone t=new TimeZone();
		Thread t1=new Thread(new TestSync(t,"Bangalore"));
		Thread t2=new Thread(new TestSync(t,"Chennai"));
		Thread t3=new Thread(new TestSync(t,"Dubai"));
		Thread t4=new Thread(new TestSync(t,"NYC"));
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}

class TestSync implements Runnable{
	
	TimeZone t1;
	String place;
	
	
	public TestSync(TimeZone t1, String place) {
		super();
		this.t1 = t1;
		this.place = place;
	}

	@Override
	public void run() {
		System.out.println("modifying by "+Thread.currentThread().getName());
		try {
			t1.getDateTimeInfo(place);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}

class TimeZone {
	
	private String place;
	
	public synchronized void getDateTimeInfo(String place) throws InterruptedException {
		for(int i=0;i<5;i++) {
			System.out.println(i+">> Place: "+place);
			Thread.sleep(2000);
			System.out.println("Time: "+new Date());
		}
	}
}

