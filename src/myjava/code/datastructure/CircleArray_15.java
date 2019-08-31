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
    private int maxSize;//可以存储maxSiza-1个有一个空约定（表示数组的最大容量）
    private int[] arr;
    public CircleArray(int maxSize){
        this.maxSize=maxSize;
        arr=new int[maxSize];
    }

    public boolean isEmpty(){
        return front==rear;
    }

    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }//+1是因为有一个空约定

    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列满了，不能加入数据");
            return;
        }else{
            arr[rear]=n;
            rear=(rear+1)%maxSize;
        }
    }

    public int getQueue(){
        if(isEmpty()){
            System.out.println("对列为空，不能取数据");
            throw new RuntimeException("队列为空，不能取数据");
        }
        int value=arr[front];
        front=(front+1)%maxSize;
        return value;
    }

    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
        }
        for(int i=front;i<front+size();i++){
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }

    public int size(){
        return (rear+maxSize-front)%maxSize;
    }

    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front];
    }
}