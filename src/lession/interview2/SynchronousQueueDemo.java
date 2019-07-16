package lession.interview2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-10 22:30
 **/
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue=new SynchronousQueue<>();//初始值false,不公平锁
        new Thread(()->{
            try{
                System.out.println(Thread.currentThread().getName()+"/t put1");
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName()+"/t put2");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName()+"/t put3");
                blockingQueue.put("3");
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        },"aaa").start();

        new Thread(()->{
            try{
                try{ TimeUnit.SECONDS.sleep(5); }catch(Exception e){ e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName()+"/t get1");
                System.out.println(blockingQueue.take());
                try{ TimeUnit.SECONDS.sleep(5); }catch(Exception e){ e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName()+"/t put2");
                System.out.println(blockingQueue.take());
                try{ TimeUnit.SECONDS.sleep(5); }catch(Exception e){ e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName()+"/t put3");
                System.out.println(blockingQueue.take());
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        },"bbb").start();
    }
}
