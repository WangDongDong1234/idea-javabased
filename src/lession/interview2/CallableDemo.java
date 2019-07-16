package lession.interview2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-11 13:47
 **/
class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("come in");
        try { TimeUnit.SECONDS.sleep(10); }catch (InterruptedException e){e.printStackTrace();}
        return 1024;
    }
}
public class CallableDemo  {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //使用
        FutureTask<Integer> futureTask=new FutureTask<>(new MyThread());
        Thread t1=new Thread(futureTask,"aa");
        t1.start();
        int result01=100;
        //获得Callable接口的返回值
        int result02=futureTask.get();//要求获得callable线程的计算结果，如果没有计算完就要去强求，会导致阻塞，直到计算完。希望把从子线程中取值的操作放到最后

        System.out.println(Thread.currentThread().getName());
        System.out.println(futureTask.get());
    }
}
