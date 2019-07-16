package lession.interview2;

import java.lang.ref.SoftReference;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-15 00:18
 **/
public class SoftReferenceDemo {
    /**
     * 内存够用的时候就保留，不够用就回收！
     */
    public static void softRef_Memory_Enough(){
        Object o1=new Object();
        SoftReference<Object> softReference=new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());//软引用需要用get()得到引用的对象
        o1=null;
        System.gc();
        System.out.println(o1);
        System.out.println(softReference.get());
    }
    /**
     * JVM配置，故意产生大对象并配置小的内存，让它内存不用用导致OOM,看软引用回收情况
     * -Xms5m -Xmx5m -XX:+PrintGCDetails
     */
    public static void softRef_Memory_NotEnough(){
        Object o1=new Object();
        SoftReference<Object> softReference=new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());
        o1=null;
       try{
        byte[] bytes=new byte[30*1024*1024]; }catch(Exception e){ e.printStackTrace(); }finally{
           System.out.println(o1);
           System.out.println(softReference.get()); }
    }
    public static void main(String[] args) {
       // softRef_Memory_Enough();
        softRef_Memory_NotEnough();
    }
}
