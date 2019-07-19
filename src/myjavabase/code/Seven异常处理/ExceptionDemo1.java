package myjavabase.code.Seven异常处理;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-19 14:05
 **/
public class ExceptionDemo1 {
    public static String output="";
    public static void foo(int i){
        try{
            if(i==1){
                throw new Exception();
            }
            output+="1";
        }catch(Exception e){
            output+="2";
        }finally{
            output+="3";
        }
        output+="4";
    }
    public static void main(String[] args) {
        foo(0);
        System.out.println(output);
        foo(1);
        System.out.println(output);
    }
}
