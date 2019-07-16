package lession.interview2;

import java.nio.ByteBuffer;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-15 14:55
 **/
public class DirectBufferMemoryDemo {
    public static void main(String[] args) throws InterruptedException {
        //-XX:MaxDirectMemorySize=5m
        System.out.println("配置的马修Direct Memory："+(sun.misc.VM.maxDirectMemory()/(double)1024/1024)+"mb");
        Thread.sleep(3000);
        ByteBuffer bb=ByteBuffer.allocateDirect(6*1024*1024);//java.lang.OutOfMemoryError: Direct buffer memory直接撑爆了堆外内存
    }
}
