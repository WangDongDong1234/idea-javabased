package lession.interview2;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-09 11:16
 **/
public class ContainerNotSafeDemo {

    public static void main(String[] args) {
        //testList();
        //testSet();
        Map<String,String> map= new ConcurrentHashMap<>();
        for(int i=1;i<=30;i++){
            new Thread(()->{
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                System.out.println(Thread.currentThread().getName()+map);
            },String.valueOf(i)).start();
        }
    }

    private  static void testSet() {
        //Set<String> set=Collections.synchronizedSet(new HashSet<>());
        Set<String> set= new CopyOnWriteArraySet<>();
        for(int i=1;i<=30;i++){
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(Thread.currentThread().getName()+set);
            },String.valueOf(i)).start();
        }
    }


    private static void testList() {
        //List<String> list= new ArrayList<String>();
        //List<String> list= Collections.synchronizedList(new ArrayList<String>());
        List<String> list= new CopyOnWriteArrayList<>();
        for(int i=1;i<=30;i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(Thread.currentThread().getName()+list);
            },String.valueOf(i)).start();
        }
    }
    /**
     * 1.故障现象
     *      java.util.ConcurrentModificationException
     * 2.导致原因
     *
     * 3.解决方案
     *        1.用vector加了锁，保证了数据一致性牺牲了并发性
     *        2.用Collections.synchronizedList(new ArrayList<>)来包装一个不安全的集合
     *        3.使用CopyOnWriteArrayList<>()
     * 4.优化建议（同样的错误不犯第2次）
     */
}
