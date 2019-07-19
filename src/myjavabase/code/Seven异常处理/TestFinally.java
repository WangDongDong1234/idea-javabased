package myjavabase.code.Seven异常处理;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-19 13:40
 **/
public class TestFinally {
    public static void main(String[] args) {
        System.out.println("结果:"+TestFinally.test());

    }
    static int test(){
        int i=1;
        try {
            System.out.println("try里面的i:"+i);
            return i;
        }finally{
            System.out.println("进入finally...");
            ++i;
            System.out.println("finally里面的:"+i);
        }
    }
}
