package myjavabase.code.fifteen类加载器;

import org.junit.Test;

import javax.jws.Oneway;
import java.util.Random;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-20 20:25
 **/
public class NewInstance {
    @Test
    public void test(){
        int num;
        String classpath=null;
        for(int i=0;i<10;i++){
            num=new Random().nextInt(2);
            switch (num){
                case 0:
                    classpath="java.util.Date";
                    break;
                case 1:
                    classpath="java.lang.Object";
                    break;
            }
            try{
                Object obj=getInstance(classpath);
                System.out.println(obj);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public Object getInstance(String classpath) throws ClassNotFoundException {
        return Class.forName(classpath);
    }
}
