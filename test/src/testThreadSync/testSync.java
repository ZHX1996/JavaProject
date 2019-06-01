package testThreadSync;

public class testSync{
	public static void main(String[] args) {
		web12306 web = new web12306();
		Thread p1 = new Thread(web, "甲");
		Thread p2 = new Thread(web, "乙");
		Thread p3 = new Thread(web, "丙");
		p1.start();
		p2.start();
		p3.start();
	}
}

class web12306 extends Thread{
	private int ticket = 20;
	private boolean flag = true;
	
	public void run() {
		while(flag)
			test();
	}
	
	public synchronized void test() {
		if(ticket <=0) {
			flag = false;
			return;
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "-->" + ticket--);
	}
}
