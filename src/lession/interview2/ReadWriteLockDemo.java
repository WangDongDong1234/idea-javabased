package lession.interview2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-09 17:08
 * 多个线程同时读一个资源类没有任何问题，所以为了满足并发量，读取共享资源应该可以同时进行。但是，如果又一个线程想去读共享资源，
 * 就不应再有其他线程可以对该资源进行读或写
 * 小总结：
 *      读-读能共存
 *      读-写不能共存
 *      写-写不能共存
 *      写操作：原子+独占，整个过程必须是一个完整的过程
 *
 **/
class MyCache{
    //缓存的东西要用volatile修饰，要保证可见性。
    private volatile Map<String,Object> map=new HashMap<>();
    //private Lock lock=new ReentrantLock();//只许一个人读
    private ReentrantReadWriteLock rwlock=new ReentrantReadWriteLock();//读写锁的合体，但用的时候分开用
    //写必须满足原子性和独占
    public void put(String key,Object value){
        rwlock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t 正在写入"+value);
            try{ TimeUnit.SECONDS.sleep(3); }catch (InterruptedException e){ e.printStackTrace(); }
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t 写入完成");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            rwlock.writeLock().unlock();
        }
    }
    public void get(String key){
        rwlock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t 正在读取");
            try{ TimeUnit.SECONDS.sleep(3); }catch (InterruptedException e){ e.printStackTrace(); }
            Object result=map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取完成"+result);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            rwlock.readLock().unlock();
        }

    }
 }
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache=new MyCache();
        for(int i=1;i<=5;i++){
            final int temp=i;
            new Thread(()->{
                myCache.put(temp+"",temp+"");
            },String.valueOf(i)).start();
        }

        for(int i=1;i<=5;i++){
            final int temp=i;
            new Thread(()->{
                myCache.get(temp+"");
            },String.valueOf(i)).start();
        }
    }
}
