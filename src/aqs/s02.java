package aqs;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-11-17 23:43
 **/
public class s02 {
    public static int m=0;
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads=new Thread[100];
        for(int i=0;i<100;i++){
            threads[i]=new Thread(()->{
                synchronized (s02.class){
                    for(int j=0;j<100;j++){
                        m++;
                    }
                }
            });
        }
        for(Thread t:threads){
            t.start();
        }
        for(Thread t:threads){
            t.join();//等待所有线程运行结束
        }
        System.out.println(m);
    }
}
