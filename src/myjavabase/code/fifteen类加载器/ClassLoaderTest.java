package myjavabase.code.fifteen类加载器;

import org.junit.Test;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-19 17:36
 **/
public class ClassLoaderTest {
    @Test
    public void test1(){
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader=ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2
        //调用系统类加载器的getParent();获取扩展类加载器
        ClassLoader classLoader1=classLoader.getParent();
        System.out.println(classLoader1);//sun.misc.Launcher$ExtClassLoader@f6f4d33
        //调用扩展类加载器的getParent();无法获取引导类加载器
        //引导类加载器主要负责加载java的核心类库，无法加载自定义类的。
        ClassLoader classLoader2=classLoader1.getParent();
        System.out.println(classLoader2);//null
        ClassLoader classLoader3=String.class.getClassLoader();
        System.out.println(classLoader3);//null说明String是引导类加载器加载的
    }
}
