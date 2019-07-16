package lession.interview2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-08 22:12
 * 1.cas是什么？====？compareAndSet
 *      比较并交换：每个线程拿自己工作空间的和主内存进行比较，通过比较交换，如果是期望值返回true就更新，如果不是期望值就返回false，重新到主内存中去拿值
 **/
public class CASDemo {

    public static void main(String[] args) {
        //体现了比较并交换
        AtomicInteger atomicInteger=new AtomicInteger(5);
        //我希望别人没有动过主内存的值，我期望是5(即没人动这个值)就更新为2019
        System.out.println(atomicInteger.compareAndSet(5,2019)+"\t current data:"+atomicInteger.get());
        //如果不是期望值，就不更新
        System.out.println(atomicInteger.compareAndSet(5,2014)+"\t current data:"+atomicInteger.get());
    }
}
