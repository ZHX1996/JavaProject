package testThreadWaitNotify01;

public class test {
	public static void main(String[] args) {
		Object lock = new Object();
		ThreadA a = new ThreadA(lock);
		a.start();
		
		SyncNotifyMethod b = new SyncNotifyMethod(lock);
		b.start();
	}

}

class ThreadA extends Thread{
	private Object lock;
	
	public ThreadA(Object lock) {
		super();
		this.lock = lock;
	}
	
	@Override
	public void run() {
		Service service = new Service();
		service.testMethod(lock);
	}
}

class SyncNotifyMethod extends Thread{
	private Object lock;
	public SyncNotifyMethod(Object lock) {
		super();
		this.lock = lock;
	}
	
	@Override
	public void run() {
		Service service = new Service();
		service.syncNotifyMethod(lock);
	}
}

class Service{
	public void testMethod(Object lock) {
		try {
			synchronized(lock) {
				System.out.println("begin wait " + Thread.currentThread().getName());
				lock.wait();
				System.out.println("end wait " + Thread.currentThread().getName());
			}
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void syncNotifyMethod(Object lock) {
		try {
			synchronized(lock) {
				System.out.println("begin notify " + Thread.currentThread().getName() + System.currentTimeMillis());
				lock.notify();
				Thread.sleep(5000);
				System.out.println("end notify " + Thread.currentThread().getName() + System.currentTimeMillis());
			}
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}