package lession.interview2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-09 23:40
 **/
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(7,()->{
            System.out.println("召唤神龙");
        });
        for(int i=1;i<=7;i++){
            final int temInt=i;
           new Thread(()->{
               System.out.println(Thread.currentThread().getName()+"\t 收集到第："+temInt+"龙珠");
               try{
                cyclicBarrier.await();//先到的先等
               }catch(InterruptedException e){
                   e.printStackTrace();
               }catch (BrokenBarrierException e){
                    e.printStackTrace();
               }
           },String.valueOf(temInt)).start();
        }
    }
}
