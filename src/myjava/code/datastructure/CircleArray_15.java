package myjava.code.datastructure;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-18 17:30
 **/
public class CircleArray_15 {
}


class CircleArray{
    private int front;
    private int rear;
    private int maxSize;//可以存储maxSiza-1个有一个空约定
    private int[] arr;
    public CircleArray(int maxSize){
        this.maxSize=maxSize;
        arr=new int[maxSize];
    }

    public boolean isEmpty(){
        return front==rear;
    }

    public boolean isFull(){
        return false;
    }

}