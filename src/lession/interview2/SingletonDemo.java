package lession.interview2;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-08 21:58
 **/
public class SingletonDemo {

    private static volatile SingletonDemo instance = null;

    private SingletonDemo(){

    }
    //(DCL)Double Check Lock双端检锁机制
    public static SingletonDemo getInstance(){
        if(instance ==null){
            synchronized (SingletonDemo.class){
                if(instance ==null){
                    instance=new SingletonDemo();
                }
            }
        }
        return instance;
    }
}
