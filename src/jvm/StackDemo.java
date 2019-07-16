package jvm;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-13 19:54
 **/
public class StackDemo {
    public static void main(String[] args) {
        //test1();//StackOverflowError
        System.out.println(args);
        System.out.println("main");
        long maxMemory=Runtime.getRuntime().maxMemory();//返回Java虚拟机试图使用的最大内存量。
        long totalMemory=Runtime.getRuntime().totalMemory();//返回Java虚拟机中的内存总量
        System.out.println("maxMemory="+maxMemory+"(字节)，"+(maxMemory/(double)1024/1024)+"MB");
        System.out.println("totalMemory="+totalMemory+"(字节)，"+(totalMemory/(double)1024/1024)+"MB");
    }

    private static void test1() {
        //test1();
        //System.out.println(Runtime.getRuntime().maxMemory()/1024/1024);

    }
}
