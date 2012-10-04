package multi_thread;

/**
 * @author Administrator ThreadA 中 有个 ThreadB 调用ThreadB.join()
 *         后ThreadB线执行，然后才是ThreadA
 * 
 *         //==========================测试结果=======================
 *         ---------------> inner_thread j=1 ---------------> inner_thread j=2
 *         ---------------> inner_thread j=3 ---------------> inner_thread j=4
 *         ---------------> inner_thread j=5 ---------------> inner_thread j=6
 *         ---------------> inner_thread j=7 ---------------> inner_thread j=8
 *         ---------------> inner_thread j=9 ---------------> inner_thread j=10
 *         Tom ====>> i=1 Tom ====>> i=2
 * 
 *         我感觉 join() 理解成 强行抢占资源 比较好 我觉得发生机制 在栈空间里 就像楼主画的图那样 谁调用join()谁抢占资源 先运行
 *         要么运行完 要么设置占用资源时间
 *         就是把此Thread的线程不单开了，加入到main这个线程里了，所以只有当t1执行完了才会运行System
 *         .out.println("over");
 *         否则没有这句的话，main线程不会管t1执行完不完成，会直接执行System.out.println("over");
 */
public class ThreadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadTest test = new ThreadTest();

		test.startThread("Tom");
		// test.startThread("Jim");
	}

	private void startThread(String name) {
		Thread t = new Thread() {
			public void run() {
				// ===
				Thread in_thread = new Thread() {
					int j = 0;

					public void run() {
						while (j < 10) {
							j++;
							System.out
									.println("---------------> inner_thread j="
											+ j);
						}
					}
				};
				in_thread.start();
				try {
					// --这个地方调用了join--
					in_thread.join();
				} catch (InterruptedException e) {
					System.out
							.println("---------------> inner_thread interrupted exception");

					e.printStackTrace();
				}

				// ===

				int i = 0;
				while (i < 100) {
					i++;
					if (i == 3) {
						break;
					}
					System.out.println(this.getName() + " ====>> i=" + i);
				}
			}
		};
		t.setName(name);
		t.start();
	}

}