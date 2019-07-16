package lession.interview2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-10 14:58
 * ArrayBlockingQueue:是一个基于数组结构的有界阻塞队列，此队列按FIFO(先进先出)原则对元素进行排序
 * LinkedBlockingQueue:一个基于链表结构的阻塞队列，此队列按FIFO（先进先出）排序元素，吞吐量通常高于ArrayBlockingQueue
 * SynchronousQueue:一个不存储元素的阻塞队列。每个插入操作必须等到另一个线程调用移除操作，否则插入操作一直处于阻塞状态，
 *                  吞吐量通常要高于
 *  1队列
 *  2阻塞队列
 *      2.1 阻塞队列有没有好的一面（海底捞的候客区，让想用餐的人等）
 *
 *      2.2 不得不阻塞，你如何管理（）
 **/
public class BolckingQueueDemo {
    public static void main(String[] args) throws Exception{
        //method1();
        //method2();
        //method3();
        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));//立即插
        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));//等了2秒，不能插走了



    }

    private static void method3() throws InterruptedException {
        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(3);
        blockingQueue.put("a");
        blockingQueue.put("a");
        blockingQueue.put("a");
        System.out.println("======");//装满了就阻塞
        //blockingQueue.put("x");
        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();//一直等到你生产好了
    }

    private static void method2() {
        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        //System.out.println(blockingQueue.offer("d"));//满了返回false
        System.out.println(blockingQueue.peek());
        System.out.println(blockingQueue.poll());//先进先出
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());//没有返回null
    }

    private static void method1() {
        //List list=new ArrayList();这个默认初始值是10
        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        //System.out.println(blockingQueue.add("d"));//java.lang.IllegalStateException: Queue full
        System.out.println(blockingQueue.remove());//先进先出
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());//java.util.NoSuchElementException
    }
}
