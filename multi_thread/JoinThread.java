package multi_thread;

public class JoinThread extends Thread {
	
	public JoinThread(String name) {
		super(name);
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			for (long k = 0; k < 100000000; k++) {
			}
			System.out.println(this.getName() + ": " + i);
		}
	}

	public static void main(String[] args) {
		Thread t1 = new JoinThread("AA AA");
		t1.start();
		try {
			t1.join(1000); // Join在这里~
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("over");
	}
}
