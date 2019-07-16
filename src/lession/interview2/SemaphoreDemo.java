package lession.interview2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-09 23:53
 **/
public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(3);//模拟3个停车位

        for(int i=1;i<=6;i++){
            new Thread(()->{
                try{
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t 抢到车位");
                    //暂停一会儿线程
                    try{
                        TimeUnit.SECONDS.sleep(3);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"\t 停车3秒离开车位");
                    semaphore.release();
                }catch(Exception e){
                    e.printStackTrace();
                }finally{

                }
            },String.valueOf(i)).start();
        }
    }
}
