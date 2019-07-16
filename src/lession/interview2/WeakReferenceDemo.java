package lession.interview2;

import java.lang.ref.WeakReference;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-15 00:31
 **/
public class WeakReferenceDemo {
    public static void main(String[] args) {
        Object o1=new Object();
        WeakReference<Object> weakReference=new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());
        o1=null;
        System.gc();
        System.out.println("=====");
        System.out.println(o1);
        System.out.println(weakReference.get());
    }
}
