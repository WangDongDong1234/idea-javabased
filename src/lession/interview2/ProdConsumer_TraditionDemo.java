package lession.interview2;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-11 00:14
 **/

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：一个初始值为零的变量，两个线程对其交替操作，一个加1一个减1，来5轮
 * 多线程的企业模板口诀：高并发，高内聚低耦合的前提下，线程操作资源类，判断干活唤醒通知，严防多进程并发下的虚假唤醒
 * 1.线程   操作（方法）   资源类
 * 2.判断   干活   通知
 * 3.防止虚假唤醒
 */
class ShareData{//资源类
    private int number=0;
    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();
    //生产者
    public void increment(){
      lock.lock();
      try{
          //1.判断(注意不能用if，用if的话一个生产者一个消费者
          // 对的但是多个生产者，多个缴费这就出现负数（number负数没有意义）)
          while (number!=0){
              //2等待，不能生产
              condition.await();
          }
          number++;
          System.out.println(Thread.currentThread().getName()+"\t"+number);
          //3.通知唤醒
          condition.signalAll();
      }catch(Exception e){ e.printStackTrace(); }finally{ lock.unlock(); }
    }
    //消费之
    public void decrement(){
        lock.lock();
        try{
            //1.判断
            while (number==0){
                //2等待，不能生产
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            //3.通知唤醒
            condition.signalAll();
        }catch(Exception e){ e.printStackTrace(); }finally{ lock.unlock(); }
    }
}
public class ProdConsumer_TraditionDemo {
    public static void main(String[] args) {
        ShareData shareData=new ShareData();
        for(int i=1;i<=5;i++){

            new Thread(()->{
                shareData.increment();
            },"生产者"+String.valueOf(i)).start();
        }
       for(int i=1;i<=5;i++){

           new Thread(()->{
               shareData.decrement();
           },"消费者"+String.valueOf(i)).start();
       }
    }
}
