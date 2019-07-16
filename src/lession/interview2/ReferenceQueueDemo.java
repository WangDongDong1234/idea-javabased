package lession.interview2;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-15 12:29
 **/
public class ReferenceQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        Object o1=new Object();
        ReferenceQueue<Object> referenceQueue=new ReferenceQueue<>();//创建一个引用队列
        WeakReference<Object> weakReference=new WeakReference<>(o1,referenceQueue);//将一个对象弱引用并指定一个引用队列
        System.out.println(o1);//java.lang.Object@1540e19d
        System.out.println(weakReference.get());//java.lang.Object@1540e19d
        System.out.println(referenceQueue.poll());//null  引用对列为空，因为gc未回收
        System.out.println("==========");
        o1=null;
        System.gc();
        Thread.sleep(500);
        System.out.println(o1);//null
        System.out.println(weakReference.get());//null
        System.out.println(referenceQueue.poll());//垃圾回收会回收弱引用，将这个对象放入引用对列中java.lang.ref.WeakReference@677327b6
    }
}
