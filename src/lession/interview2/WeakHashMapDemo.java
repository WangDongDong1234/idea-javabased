package lession.interview2;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-15 00:45
 **/
public class WeakHashMapDemo {

    public static void main(String[] args) {
        myHashMap();
        System.out.println("====");
        myWeakHashMap();
    }

    private static void myWeakHashMap() {
        WeakHashMap<Integer,String> map=new WeakHashMap<>();
        Integer key=new Integer(1);
        String value="HashMap";
        map.put(key,value);
        System.out.println(map);//{1=HashMap}
        key=null;
        System.out.println(map);//{1=HashMap}
        System.gc();
        System.out.println(map+"\t"+map.size());//{}	0
    }

    private static void myHashMap() {
        HashMap<Integer,String> map=new HashMap<>();
        Integer key=new Integer(1);
        String value="HashMap";
        map.put(key,value);
        System.out.println(map);//{1=HashMap}
        key=null;
        System.out.println(map);//{1=HashMap}
        System.gc();
        System.out.println(map+"\t"+map.size());//{1=HashMap}	1

    }
}
