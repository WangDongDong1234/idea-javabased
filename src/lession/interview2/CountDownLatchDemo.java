package lession.interview2;

import java.util.concurrent.CountDownLatch;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-09 23:26
 **/
public class CountDownLatchDemo {
    public static void main(String[] args) throws Exception{
        CountDownLatch countDownLatch=new CountDownLatch(6);
        for(int i=1;i<=6;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 国，被灭");
                countDownLatch.countDown();
            },CountryEnum.forEach_countryEnum(i).getRetMessage()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t***秦帝国，一统华夏");
    }
}
