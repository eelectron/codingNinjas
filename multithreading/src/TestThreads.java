package multithreading.src;

public class TestThreads {
	/*public static void main(String[] args) {
		//MyRunnable r = new MyRunnable();
		Runnable r = () -> System.out.println("Important job running in runable");
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		Thread t3 = new Thread(r);
	}
	*/
	
	public static void main(String[] args) {
		Runnable r = () -> {
			int n = 6;
			for(int i = 1; i < n; i++) {
				System.out.println("Runnable running " + i);
			}
		};
		
		Thread t = new Thread(r);
		t.start();
	}
}