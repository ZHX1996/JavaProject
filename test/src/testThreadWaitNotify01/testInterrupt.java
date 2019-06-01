package testThreadWaitNotify01;

public class testInterrupt {
	public static void main(String[] args) throws InterruptedException {
		Object lock = new Object();
		ThreadA a = new ThreadA(lock);
		a.start();
		// 处于wait中的线程5秒后被唤醒，并抛出异常
		Thread.sleep(5000);
		a.interrupt();
	}
}
