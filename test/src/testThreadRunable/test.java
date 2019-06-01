package testThreadRunable;

public class test {
	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		Thread t1 = new Thread(ticket, "路人甲");
		Thread t2 = new Thread(ticket, "黄牛乙");
		
		t1.start();
		t2.start();
	}
}

class Ticket implements Runnable{
	int num = 50;
	
	@Override
	public void run() {
		while(true) {
			if(num<1) {
				break;
			}
			System.out.println(Thread.currentThread().getName() + "抢到了" + num--);
		}
	}
}
