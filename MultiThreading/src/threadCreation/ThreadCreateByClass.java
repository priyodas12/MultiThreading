package threadCreation;

public class ThreadCreateByClass {

	public static void main(String[] args) {
		ThreadOne to1=new ThreadOne("Thread1");
		ThreadOne to2=new ThreadOne("Thread2");
		
		to1.start();
		to2.start();
	}

}
