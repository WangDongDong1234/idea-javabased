package myjavabase.code.test尚学堂;

import org.junit.Test;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-25 23:37
 **/
public class TestMain {
    @Test
    public void test(){
        // float f = 0.1f;
        // double d = 1.0/10;
        // System.out.println(f==d);   //false
        // float d1 = 423432423f;
        // float d2 = d1+1;
        // if(d1==d2){
        //     System.out.println("d1==d2");
        // }else{
        //     System.out.println("d1!=d2");
        // }
        //
        // System.out.println(-9%-2);
        // System.out.println(-9%2);
        // System.out.println(9%-2);
        boolean c = 2>(3/0);
        System.out.println(c);
    }
}
