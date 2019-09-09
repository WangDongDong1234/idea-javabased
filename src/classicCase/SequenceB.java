package classicCase;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-09-08 23:04
 **/
public class SequenceB implements Sequence {

    private static final ThreadLocal<Integer> numContainer=new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };
    @Override
    public int getNum() {
        Integer num=numContainer.get();
        num=num+1;
        numContainer.set(num);
        return num;
    }

    public static void main(String[] args) {
        Sequence sequence=new SequenceB();
        Thread s1=new ClientThread(sequence);
        Thread s2=new ClientThread(sequence);
        Thread s3=new ClientThread(sequence);
        s1.start();
        s2.start();
        s3.start();
    }
}
