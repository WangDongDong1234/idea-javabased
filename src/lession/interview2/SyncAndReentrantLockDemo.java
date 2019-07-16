package lession.interview2;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-11 10:10
 **/

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：多线程之间按顺序调用，实现A->B->C三个线程启动，要求如下：(要求你精确唤醒)
 * AA打印5次，BB打印10次，CC打印15次
 * 紧接着
 * AA打印5次，BB打印10次，CC打印15次
 * 来10轮
 */
class ShareResource{
    private int number=1;//A:1 B:2 C:3
    private Lock lock=new ReentrantLock();
    //一把指纹锁的三把钥匙
    private Condition c1=lock.newCondition();
    private Condition c2=lock.newCondition();
    private Condition c3=lock.newCondition();
    //打印5次
    public void print5(){
        lock.lock();
        try{
            //1.判断
            while(number!=1){
                c1.await();
            }
            //2.干活
            for(int i=1;i<=5;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //3.通知
            //修改标志位
            number=2;
            //通知2号线程
            c2.signal();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    //打印10次
    public void print10(){
        lock.lock();
        try{
            //1.判断
            while(number!=2){
                c2.await();
            }
            //2.干活
            for(int i=1;i<=10;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //3.通知
            //修改标志位
            number=3;
            //通知2号线程
            c3.signal();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    //打印15次
    public void print15(){
        lock.lock();
        try{
            //1.判断
            while(number!=3){
                c3.await();
            }
            //2.干活
            for(int i=1;i<=15;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //3.通知
            //修改标志位
            number=1;
            //通知2号线程
            c1.signal();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
}
public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {
        ShareResource shareResource=new ShareResource();
        new Thread(()->{
            for(int i=0;i<3;i++){
                shareResource.print5();
            }
        },"AA").start();
        new Thread(()->{
            for(int i=0;i<3;i++){
                shareResource.print10();
            }
        },"BB").start();
        new Thread(()->{
            for(int i=0;i<3;i++){
                shareResource.print15();
            }
        },"CC").start();
    }
}
