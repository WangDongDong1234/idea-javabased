package lession.interview2;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-15 14:19
 **/

/**
 * JVM参数配置演示
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m（此参数的含义是当Direct ByteBuffer分配的堆外内存到达指定大小后，即触发Full GC。注意该值是有上限的）
 * GC回收时间过长时会抛出OutOfMemoryError.过长的定义时，超过0.98的时间用来做GC并且回收了不到2%的堆内存
 * 连续多次GC都只能回收不到2%的极端情况下才会抛出。加入不抛出GC overhead limit错误会发生什么情况呢？
 * 那就是GC清理的这么点内存很快会再次填满，迫使GC再次执行，这样就形成恶性循环，
 * CPU使用率一直是100%，而GC却没有任何效果
 */
public class GCOverheadDemo {
    public static void main(String[] args) {
        int i=0;
        List<String> list=new ArrayList<>();
       try{
            while (true){
                list.add(String.valueOf(++i).intern());
            }
       }catch(Exception e){
           System.out.println("********i:"+i);
           e.printStackTrace();// Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
           throw e;
       }
    }
}
