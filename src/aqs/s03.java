package aqs;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-11-17 23:53
 **/
public class s03 {
    public static int m=0;
    public static Lock lock=new ReentrantLock();//底层用的是AQS
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads=new Thread[100];
        for(int i=0;i<100;i++){
            threads[i]=new Thread(()->{
               try{
                   lock.lock();
                   for(int j=0;j<100;j++){
                       m++;
                   }
               }finally {
                   lock.unlock();
               }
            });
        }
        for(Thread t:threads){
            t.start();
        }
        for(Thread t:threads){
            t.join();//等待所有线程运行结束
        }
        System.out.println(m);
    }
}
