package lession.interview2;

import java.util.Random;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-16 00:07
 **/
public class GCDemo {
    public static void main(String[] args) {
        System.out.println("****GCDemo hello");
        try{
            String str="atguigu";
            while(true){
                str+=str+new Random().nextInt(77777777)+new Random().nextInt(888888888);
                str.intern();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
