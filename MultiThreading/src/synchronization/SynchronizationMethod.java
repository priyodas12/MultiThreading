package synchronization;

import java.util.Date;

/*
 * Synchronized Method:Class Level lock(static synchronized method).
 * 
 * 
 */
public class SynchronizationMethod {
	
	public static void main(String[] args) {
		//only one object and 4 threads are trying to access the same object
		TimeZone2 tz1=new TimeZone2();
		TimeZone2 tz2=new TimeZone2();
		Thread t1=new Thread(new TestSync2(tz1,"Bangalore"));
		Thread t3=new Thread(new TestSync3(tz1,"Bangalore"));
		Thread t2=new Thread(new TestSync2(tz2,"Chennai"));
		t1.start();
		t2.start();
		t3.start();
		//Regular output i.e. once city followed by another
	}

}

class TestSync2 implements Runnable{
	
	TimeZone2 t2;
	String place;
	
	
	public TestSync2(TimeZone2 t2, String place) {
		super();
		this.t2 = t2;
		this.place = place;
	}

	@Override
	public void run() {
		System.out.println("modifying by "+Thread.currentThread().getName());
		try {
			t2.getDateTimeInfo(place);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
}

class TestSync3 implements Runnable{
	
	TimeZone2 t3;
	String place;
	
	
	public TestSync3(TimeZone2 t3, String place) {
		super();
		this.t3 = t3;
		this.place = place;
	}

	@Override
	public void run() {
		System.out.println("modifying by "+Thread.currentThread().getName());
		t3.getState(place);
	}
}

class TimeZone2 {
	
	private  String place;
	//Class Level lock(Class class object lock)
	public static synchronized void getDateTimeInfo(String place) throws InterruptedException {
		
		for(int i=0;i<5;i++) {
			System.out.println(i+">> Place: "+place+" printed by "+Thread.currentThread().getName());
			Thread.sleep(2000);
			System.out.println("Time: "+new Date());
			
		}
	}
	
	public static void getState(String place) {
		if(place.equals("Bangalore")) {
			System.out.println("Karnataka");
		}
		else if(place.equals("Chennai")) {
			System.out.println("Tamilnadu");
		}
		else {
			System.out.println("Unknown");
		}
	}
}

