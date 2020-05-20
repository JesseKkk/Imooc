package com.jesse.reflect.test;

import java.lang.reflect.Constructor;

import org.junit.Test;

public class ConstructorTest {

	@Test
	/**
	 * 获得无参数的构造方法
	 * 
	 */
	public void demo1() throws Exception {
		//获得类的字节码文件对应的对象：
		Class class1 = Class.forName("com.jesse.reflect.test.Person");
		Constructor con = class1.getConstructor();
		Person person = (Person) con.newInstance();// 相当于Person person = new Person();
		person.eat();
	}
	
	@Test
	/**
	 * 获得无参数的构造方法
	 * 
	 */
	public void demo2() throws Exception {
		//获得类的字节码文件对应的对象：
		Class class1 = Class.forName("com.jesse.reflect.test.Person");
		Constructor con = class1.getConstructor(String.class,String.class);
		Person person = (Person) con.newInstance("张三","男");// 相当于Person person = new Person("张三","男");
		System.out.println(person);
	}	
}
