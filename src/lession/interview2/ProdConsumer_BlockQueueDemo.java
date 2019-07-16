package lession.interview2;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-11 11:30
 * volatile/CAS/atomicInteger/BlockQueue/线程交互/原子引用
 * 消息中间件
 **/
class MyResource{
    private volatile boolean FLAG=true;//默认开启，进行生产+消费
    private AtomicInteger atomicInteger=new AtomicInteger();
    //传接口，不许传具体的类
    BlockingQueue<String> blockingQueue=null;
    public MyResource(BlockingQueue<String> blockingQueue){
        this.blockingQueue=blockingQueue;
        //因为是接口，所以要看看具体传的是哪个类
        System.out.println(blockingQueue.getClass().getName());
    }
    public void myProd()throws Exception{
        String data=null;
        boolean retValue;
        while (FLAG){
            data=atomicInteger.incrementAndGet()+"";
            retValue=blockingQueue.offer(data,2L, TimeUnit.SECONDS);
            if(retValue){
                System.out.println(Thread.currentThread().getName()+"\t 插入对列"+data+"成功");
            }else{
                System.out.println(Thread.currentThread().getName()+"\t 插入对列"+data+"失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"\t大老板叫停了，生产结束");
    }
    public void myConsumer()throws Exception{
        String result=null;
        while(FLAG){
            result=blockingQueue.poll(2L,TimeUnit.SECONDS);
            if(result==null||result.equalsIgnoreCase("")){
                FLAG=false;
                System.out.println(Thread.currentThread().getName()+"\t 超过5秒钟没有取到蛋糕，消费退出");
                return;//不带这个的话，下面的消费对列成功也会输出
            }
            System.out.println(Thread.currentThread().getName()+"\t       消费对列"+result+"成功");
        }
    }
    public void stop(){
        FLAG=false;
    }
}
public class ProdConsumer_BlockQueueDemo {
    public static void main(String[] args) {
        System.out.println(new Date());
        MyResource myResource=new MyResource(new ArrayBlockingQueue<>(10));
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 生产线程启动");
            try{ myResource.myProd(); }catch(Exception e){ e.printStackTrace(); }
        },"prod").start();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 消费线程启动");
            try{ myResource.myConsumer(); }catch(Exception e){ e.printStackTrace(); }
        },"consume").start();
        try{ TimeUnit.SECONDS.sleep(10); }catch(Exception e){ e.printStackTrace(); }
        System.out.println();
        System.out.println();;
        System.out.println("5s后大老板叫停");
        myResource.stop();
        System.out.println(new Date());
    }
}
