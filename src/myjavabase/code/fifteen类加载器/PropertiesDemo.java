package myjavabase.code.fifteen类加载器;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-07-19 17:57
 **/
public class PropertiesDemo {
    @Test
    public void method1() throws Exception {
        //这种方式读取的路径在当前模块下
        Properties properties=new Properties();
        FileInputStream fil=new FileInputStream("jdbc1.properties");
        properties.load(fil);
        System.out.println(properties.getProperty("user"));
        System.out.println(properties.getProperty("passwd"));
    }

    @Test
    public void method2() throws Exception {
        //这种方式读取的路径在当前src下
        Properties properties=new Properties();
        ClassLoader classLoader=PropertiesDemo.class.getClassLoader();
        InputStream is=classLoader.getResourceAsStream("jdbc2.properties");
        properties.load(is);
        System.out.println(properties.getProperty("user"));
        System.out.println(properties.getProperty("passwd"));
    }
}
