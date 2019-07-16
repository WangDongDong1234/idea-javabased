package lession.interview2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-12 17:03
 **/
class HoldLockThread implements Runnable{
    private String lockA;
    private String lockB;
    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }
    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"\t自己持有:"+lockA+"\t 尝试获得："+lockB);
            try{ TimeUnit.SECONDS.sleep(2); }catch(Exception e){ e.printStackTrace(); }finally{ }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"\t自己持有:"+lockB+"\t 尝试获得："+lockA);
            }
        }
    }
}

/**
 * 死锁是指两个或两个以上的进程在执行过程中，
 * 因争夺资源而造成的一种互相等待现象
 * 若无外力干涉那他们都将无法推进下去
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA="lockA";
        String lockB="lockB";
        new Thread(new HoldLockThread(lockA,lockB),"ThreadAAA").start();
        new Thread(new HoldLockThread(lockB,lockA),"ThreadAAA").start();
    }
}
