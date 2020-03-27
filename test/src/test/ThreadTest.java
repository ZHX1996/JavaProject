package test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
    private static ReentrantLock lock = new ReentrantLock();
    private static int count = 0;
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        Thread A = new Thread(() -> {
        //加锁 一次只有一个线程输出
            lock.lock();
            try {
                while (true) {
                //因为只循环3次 所以到9的时候就结束循环
                    if (count == 9) {
                        break;
                    }
                    //当余数为0 就输出A
                    if (count % 3 == 0) {
                        count++;
                        System.out.println("A");
                        //唤醒其他等待线程
                        condition.signalAll();
                    } else {
                        try {
                        //等待
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } finally {
                lock.unlock();
            }
        });
        Thread B = new Thread(() -> {
            lock.lock();
            try {
                while (true) {
                    if (count == 9) {
                        break;
                    }
                    if (count % 3 == 1) {
                        count++;
                        System.out.println("B");
                        condition.signalAll();
                    } else {
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } finally {
                lock.unlock();
            }
        });
        Thread C = new Thread(() -> {
            lock.lock();
            try {
                while (true) {
                    if (count == 9) {
                        break;
                    }
                    if (count % 3 == 2) {
                        count++;
                        System.out.println("C");
                        condition.signalAll();
                    } else {
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } finally {
                lock.unlock();
            }
        });

        A.start();
        B.start();
        C.start();

    }
}

/*
class ABC implements Runnable{
    @Override
    public void run(){
        System.out.println("A");
        System.out.println("B");
        System.out.println("C");
    }
}

public class ThreadTest{
    public static void main(String[] args) throws InterruptedException{
    	ABC abc = new ABC();
        Thread t1 = new Thread(abc);
        Thread t2 = new Thread(abc);
		Thread t3 = new Thread(abc);
		Thread.sleep(100);
		t1.start();
		Thread.sleep(100);
		t2.start();
		Thread.sleep(100);
		t3.start();
    }
}
*/