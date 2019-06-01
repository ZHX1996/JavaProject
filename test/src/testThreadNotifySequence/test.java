package testThreadNotifySequence;
//https://www.cnblogs.com/hapjin/p/5492645.html

import java.util.ArrayList;
import java.util.List;

public class test {
	public static void main(String[] args) throws InterruptedException {
		String lock = new String("");
		Add add = new Add(lock);
		Subtract subtract = new Subtract(lock);
		
		ThreadSubtract ts1 = new ThreadSubtract(subtract);
		ts1.setName("ts1");
		ts1.start();
		
		ThreadSubtract ts2 = new ThreadSubtract(subtract);
		ts2.setName("ts2");
		ts2.start();
		
		Thread.sleep(1000);
		
		ThreadAdd ta = new ThreadAdd(add);
		ta.setName("ta");
		ta.start();
	}

}

class ValueObject{
	public static List<String> list = new ArrayList<String>();
}

class Add{
	private String lock;
	
	public Add(String lock) {
		super();
		this.lock = lock;
	}
	
	public void add() {
		synchronized(lock) {
			ValueObject.list.add("anyString");
			lock.notifyAll();
		}
	}
}

class ThreadAdd extends Thread{
	private Add p;
	
	public ThreadAdd(Add p) {
		super();
		this.p = p;
	}
	
	@Override
	public void run() {
		p.add();
	}
}

class Subtract{
	private String lock;
	
	public Subtract(String lock) {
		super();
		this.lock = lock;
	}
	
	public void subtract() {
		try {
			synchronized(lock) {
				while(ValueObject.list.size() == 0) {
					System.out.println("wait begin " + Thread.currentThread().getName());
					lock.wait();
					System.out.println("wait end " + Thread.currentThread().getName());
				}
				ValueObject.list.remove(0);
				System.out.println("list size " + ValueObject.list.size());
			}
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ThreadSubtract extends Thread{
	private Subtract r;
	
	public ThreadSubtract(Subtract r) {
		super();
		this.r = r;
	}
	
	@Override
	public void run() {
		r.subtract();
	}
}