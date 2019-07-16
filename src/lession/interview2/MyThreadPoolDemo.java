package lession.interview2;

import java.util.concurrent.*;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-11 15:43
 * 1.Thread
 * 2.Runnable
 * 3.Callable
 * 4.获得使用java多线程的方式，线程池
 **/
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        //JDKthreadPool();
        //1.知道自己的硬件情况
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService threadPool=new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        try{
            //模拟10个用户来办理用户办理业务，每个用户就是一个来自外部的请求线程
            for(int i=1;i<=10;i++){
                //线程池里有5个柜台来处理
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"办理业务");
                });
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            threadPool.shutdown();
        }
    }

    private static void JDKthreadPool() {
        //System.out.println(Runtime.getRuntime().availableProcessors());
        //Array Arrays
        //Collection Collections
        //Executor,Executors
        ExecutorService threadPool= Executors.newFixedThreadPool(5);//一池5个处理线程
        //ExecutorService threadPool= Executors.newSingleThreadExecutor();//一池1个处理线程
        //ExecutorService threadPool=Executors.newCachedThreadPool();//一池多个线程
        try{
            //模拟10个用户来办理用户办理业务，每个用户就是一个来自外部的请求线程
            for(int i=1;i<=10;i++){
                //线程池里有5个柜台来处理
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"办理业务");
                });
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            threadPool.shutdown();
        }
    }
}
