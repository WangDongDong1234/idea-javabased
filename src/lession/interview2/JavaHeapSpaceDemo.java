package lession.interview2;

import java.util.Random;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-15 14:01
 **/
public class JavaHeapSpaceDemo {
    public static void main(String[] args) {
        byte[] bytes=new byte[80*1024*1024];//java.lang.OutOfMemoryError: Java heap space   撑爆了内存
        //-Xms10m -Xmx10m
        String str="atguigu";
        while (true){
            str+=str+new Random().nextInt(1111111111)+new Random().nextInt(1111111111);
            str.intern();
        }//java.lang.OutOfMemoryError: Java heap space   撑爆了内存

    }
}
