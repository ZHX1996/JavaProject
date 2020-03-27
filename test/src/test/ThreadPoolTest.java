package test;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
	// ͨ��Executors�����ഴ��
	private static ExecutorService executorService = Executors.newFixedThreadPool(5);
	// ֱ�Ӵ����̳߳�
	private static ExecutorService executorService1 = new ThreadPoolExecutor(5,10,0L,TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
	
	public static void main(String[] args) {
		executorService.submit(()->{
			for(int i=0;i<5;i++) {
				System.out.println(i + " ");
			}
		});
		executorService.shutdown();
		
		executorService1.submit(()->{
			for(int i=0;i<5;i++) {
				System.out.println(i + " ");
			}
		});
		executorService1.shutdown();
	}
}
