package lession.interview2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-09 15:27
 **/
class Phone implements Runnable{
    //这是synchronized的可重入锁的演示
    public synchronized void sendSMS(){
        System.out.println(Thread.currentThread().getName()+"\t invoked sendSms()");
        sendEmail();
    }
    public synchronized void sendEmail(){
        System.out.println(Thread.currentThread().getName()+"\t ###invoked sendEmail()");
    }
    //这是lock的可重入锁的演示
    Lock lock=new ReentrantLock();

    @Override
    public void run() {
        get();
    }
    public void get(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t invoked get(）");
            set();
        }finally {
            lock.unlock();
        }
    }

    public void set(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t invoked set(）");
        }finally {
            lock.unlock();
        }
    }
}
public class ReenterLockDemo {
    public static void main(String[] args) {
        //这是synchronized的可重入锁的演示
        Phone phone=new Phone();
        new Thread(()->{
            phone.sendSMS();
        },"t1").start();

        new Thread(()->{
            phone.sendSMS();
        },"t2").start();
        System.out.println("-------------");
        try{
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        //这是lock的可重入锁的演示
        Thread t3=new Thread(phone);
        Thread t4=new Thread(phone);
        t3.start();
        t4.start();
    }
}
