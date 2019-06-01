package testThreadJoinYield;
/*
 * join:阻塞调用方法的线程，直到被调用的线程执行完
 * yield:让出线程执行权，进入可执行状态，不能保证其它线程进入执行状态，可能还是它执行，也看优先级
 */
class othertest extends Thread{

	@Override
	public void run() {
		for(int i=1;i<=50;i++) {
			if(i%10==0) {
				Thread.yield();
			}
			System.out.println("new--->" + i);
		}
	}
}

public class testJoinYield {
	public static void main(String[] args) throws InterruptedException {
		othertest other = new othertest();
		Thread t1 = new Thread(other, "newName");
//		t1.setPriority(10);
		t1.start();
		System.out.println(t1.getName());
		System.out.println(t1.getPriority());
		for(int i=1;i<=50;i++) {
//			if(i==5) {
//				t1.join();
//			}
			System.out.println("old---->" + i);
		}
	}
}
