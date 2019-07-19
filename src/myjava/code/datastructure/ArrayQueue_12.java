package myjava.code.datastructure;

import java.util.Scanner;

/**
 * @program: javabased
 * @description: ${一次性队列,不能循环}
 * @author: Mr.Wang
 * @create: 2019-07-18 13:40
 **/
public class ArrayQueue_12 {
    public static void main(String[] args) {
        ArrayQueue arrayQueue=new ArrayQueue(5);
        char key;
        Scanner scanner=new Scanner(System.in);
        boolean loop=true;
        int value;
        while (loop){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key=scanner.next().charAt(0);
            switch (key){
                case 's':arrayQueue.showQueue();break;
                case 'a':
                    System.out.println("输入一个数");
                    value=scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'e':loop=false;break;
                case 'g':
                    System.out.println(arrayQueue.getQueue());break;
                case 'h':
                    System.out.println(arrayQueue.headQueue());break;
            }
        }
    }
}
class ArrayQueue{
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//该数据用于存放
    private int maxSize;
    public ArrayQueue(int maxSize){
        this.maxSize=maxSize;
        arr=new int[maxSize];
        front=-1;
        rear=-1;
    }

    public boolean isEmpty(){
        return front==rear;
    }

    public boolean isFull(){
        return rear==maxSize-1;
    }

    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
        }

        for(int i=0;i<arr.length;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }

    }

    public int headQueue(){
        if(isEmpty()){
            System.out.println("对列为空");
            throw new RuntimeException("队列空的，没有数据");
        }
        return arr[front+1];
    }

    public void addQueue(int n){
        if(isFull()){
            System.out.println("对列满了");
            return;
        }
        rear++;
        arr[rear]=n;
    }

    public int getQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
            throw new RuntimeException("对列为空，不能获取数据");
        }
        front++;
        return arr[front];
    }
}
