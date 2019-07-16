package lession.interview2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-09 10:46
 **/
public class AtomicStampedReferenceDemo {
    public static void main(String[] args) {
        AtomicStampedReference<Integer> atomicStampedReference=new AtomicStampedReference<>(100,1);
        System.out.println("ABA问题的解决");
        new Thread(()->{
            int stamp=atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t 第一次版本号:"+stamp);
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(100,101,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"\t 第二次版本号:"+atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101,100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"\t 第三次版本号:"+atomicStampedReference.getStamp());
        },"t1").start();

        new Thread(()->{
            int stamp=atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t 第一次版本号:"+stamp);
            try{
                //确保t1线程完成一次aba操作
                TimeUnit.SECONDS.sleep(3);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            boolean result=atomicStampedReference.compareAndSet(100,2019,stamp,atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"\t修改成功否:+"+result+"\t 当前最新版本"+atomicStampedReference.getStamp()+"\t当前实际最新值"+atomicStampedReference.getReference());
        },"t2").start();
    }
}
