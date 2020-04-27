package deadLock;

public class DeadLockImpl {
	public static void main(String[] args) {
		String s1="abc";
		String s2="dfg";
		
		Runnable r1=()->{
			synchronized (s1) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (s2) {
					for (int i = 0; i < 10; i++) {
						System.out.println("From"+Thread.currentThread().getName());
					}
					
				}			
			}
		};
		
		Runnable r2=()->{
			synchronized (s1) {
				try {
					Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (s2) {
						for (int i = 0; i <10; i++) {
							System.out.println("From"+Thread.currentThread().getName());
						}
						}			
					}
				};
		Thread t1=new Thread(r1);
		Thread t2=new Thread(r2);
		
		t1.start();
		t2.start();
	}

}
