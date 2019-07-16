package lession.interview2;

import java.util.concurrent.TimeUnit;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-15 15:29
 **/
public class UnableCreateNativeThreadDemo {
    public static void main(String[] args) {
        for(int i=0;;i++){
            new Thread(()->{
                try{
                    TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                }catch(Exception e){
                    e.printStackTrace();
                }finally{

                }
            },String.valueOf(i)).start();
        }
    }
}
