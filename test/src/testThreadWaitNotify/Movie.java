package testThreadWaitNotify;

public class Movie {
	private String pic;
	//flag--> true 生产
	//flag--> false 消费
	private boolean flag = true;
	
	public synchronized void play(String pic) {
		//消费，生产者等待
		if(!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		this.pic = pic;
		this.notify();
		flag = false;
	}
	
	public synchronized void watch() {
		if(flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(pic);
		this.notify();
		flag = true;
	}
}
