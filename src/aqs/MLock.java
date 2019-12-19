package aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-11-18 00:07
 **/
public class MLock implements Lock {
    private volatile int i=0;
    @Override
    public void lock() {
        //恶心用syn实现的锁
        synchronized (this){
            //如果i!=0表示已经有线程调用了
            while (i!=0){
                try{
                    this.wait();//阻塞CAS
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            i=1;
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        synchronized (this){
            i=0;
            this.notifyAll();
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
