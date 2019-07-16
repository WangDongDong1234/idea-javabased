package lession.interview2;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-15 13:56
 **/
public class StackOverFflowErrorDemo {
    public static void main(String[] args) {
        stackOverflowError();//java.lang.StackOverflowError这个到底是异常还是错误，答案是错误
    }

    private static void stackOverflowError() {
        stackOverflowError();
    }
}
