package test;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class ProviderConsumerTest{
    private static LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

    public static void main(String[] args){
        Thread provider = new Thread(()->{
            Random random = new Random();
            for(int j=0;j<5;j++){
                try{
                    int i = random.nextInt();
                    queue.put(i);
                    System.out.println("生产数据："+i);
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(()->{
            Integer data;
            for(int i=0;i<5;i++){
                try{
                    data = queue.take();
                    System.out.println("消费数据："+data);
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        provider.start();
        consumer.start();
    }
}