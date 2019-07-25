package lession.interview2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyData{
    public int number=0;
    //public volatile int number=0;
    public  void addTo60(){
        this.number=60;
    }

    //请注意，此时number前面时加了volatile关键字修饰的，volatile不保证原子性
    public  synchronized void addPlusPlus(){
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        number++;
    }

     public AtomicInteger automicInteger=new AtomicInteger();
     public void addAtomic(){
        automicInteger.getAndIncrement();
     }
}
/**
 * 1验证volatile的可见性
 *  1.1假如 int number=0;number 变量之前根本没有添加volatile关键字修饰，没有可见性
 *  1.2添加了volatile，可以解决可见性问题
 *
 * 2验证volatile不保证原子性
 *  2.1 原子性指的是什么意思
 *      不可分割，完整性，也即某个线程正在做某个具体业务时，中间不可以被加塞或者被分割。需要整体完整，要么同时成功，要么同时失败。
 *  2.2是否可以保证原子性
 *     不保证原子性
 *  2.3为什么不保证原子性  数据丢失
 *  2.4如何解决
 *        *加synchronized
 *        *使用AtomicInteger注意不要写错
 */
public class VolatileDemo {

    public static void main(String[] args) {
        //seeOkByValatile();
        MyData myData=new MyData();
        for(int i=0;i<10;i++){
            new Thread(()->{
                for(int j=1;j<=10;j++){
                    myData.addPlusPlus();
                    myData.addAtomic();
                }
            },String.valueOf(i)).start();
        }
        //需要等待上面20个线程都全部计算完成后，再用main线程取得最终的结果值看时多少
        //暂停一下
        while (Thread.activeCount()>2){
            Thread.yield();//等待上面线程全部算完
        }
        System.out.println(Thread.currentThread().getName()+"\t int type,finally number value"+myData.number);
        System.out.println(Thread.currentThread().getName()+"\t AtomicInteger type,finally number value"+myData.automicInteger);
}

    //volatile保证可见性
    private static void seeOkByValatile() {
        MyData myData=new MyData();
        //第一个线程
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\t come in"+myData.number);
            try{
                TimeUnit.SECONDS.sleep(3);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName()+"\t updated number value:"+myData.number);
        },"aaa").start();

        //第二个线程是主线程
        while (myData.number==0){
            //main 线程就一直在这里等待循环，直到number值不再等于零
        }
        //我们想要的结果是，第一个线程改完后，第二个线程得到响应，但是结果不是我们想要的（在number前加一个vilatile就ok）
        System.out.println(Thread.currentThread().getName()+"\t over"+myData.number);
    }
}
