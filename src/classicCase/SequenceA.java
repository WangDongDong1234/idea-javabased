package classicCase;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-09-08 22:58
 **/
public class SequenceA implements Sequence {
    private static int num=0;
    @Override
    public int getNum() {
        num=num+1;
        return num;
    }

    public static void main(String[] args) {
        Sequence sequence=new SequenceA();
        Thread t1=new ClientThread(sequence);
        Thread t2=new ClientThread(sequence);
        Thread t3=new ClientThread(sequence);
        t1.start();
        t2.start();
        t3.start();
        //结论： 根据结果可以看到，线程变量被共享了。 要想每个线程独立输出1-5， 就需要用到存放线程变量的容器 ---> ThreadLocal
    }
}
