package com.jesse.ioc.demo3;

import com.jesse.ioc.demo2.Bean1;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean的作用范围的测试
 */
public class SpringDemo3 {
    @Test
    public void demo1() {
        //创建工厂
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过工厂获得类的实例：
        Person person1 = (Person) applicationContext.getBean("person");
        Person person2 = (Person) applicationContext.getBean("person");

        System.out.println(person1);
        System.out.println(person2);
    }

    @Test
    public void demo2() {
        //创建工厂
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过工厂获得类的实例：
        Man man = (Man) applicationContext.getBean("man");

        man.run();

        applicationContext.close();
    }

    @Test
    public void demo3() {
        //创建工厂
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过工厂获得类的实例：
        UseDao useDao = (UseDao) applicationContext.getBean("useDao");

        useDao.findAll();
        useDao.save();
        useDao.update();
        useDao.delete();

    }
}
