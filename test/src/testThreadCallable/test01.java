package testThreadCallable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//https://www.cnblogs.com/frinder6/p/5507082.html

/*
 * 实现callable接口的任务线程能返回执行结果，runnable不能
 *callable接口的call()方法允许抛出异常，runnable接口的run()方法只能自己解决
 * 调用FutureTask.get()得到执行结果，但会阻塞主线程
 */
	
public class test01 implements Callable<String>{
	private String acceptStr;
	
	public test01(String acceptStr) {
		this.acceptStr = acceptStr;
	}

	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		return this.acceptStr + " append some chars and return it";
	}
	
	public static void main(String[] args) throws ExecutionException,InterruptedException{
		Callable<String> callable = new test01("my test");
		FutureTask<String> task = new FutureTask<String>(callable);
		
		long beginTime = System.currentTimeMillis();
		
		new Thread(task).start();
		String result = task.get();
		long endTime = System.currentTimeMillis();
		System.out.println(result);
		System.out.println("cast: " + (endTime-beginTime)/1000 + " second!");
	}
}
