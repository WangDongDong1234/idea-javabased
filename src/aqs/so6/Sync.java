package aqs.so6;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-11-18 00:17
 **/
public class Sync extends AbstractQueuedSynchronizer {
    @Override
    protected boolean tryRelease(int arg) {
        assert arg==1;
        //如果当前线程持有锁采取尝试释放锁
        if(!isHeldExclusively()){
            throw new IllegalMonitorStateException();
        }
        setExclusiveOwnerThread(null);
        setState(0);
        return true;
    }

    @Override
    protected boolean tryAcquire(int arg) {

        //修改state的值，如过将0编程1表示当前线程持有这把锁
        if(compareAndSetState(0,1)){
            //设定当前线程持有这个锁
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }
        return false;

    }

    @Override
    protected boolean isHeldExclusively() {
        //判断当前线程是不是持有锁的线程
        return getExclusiveOwnerThread()==Thread.currentThread();
    }
}
