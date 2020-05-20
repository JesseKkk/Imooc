package com.jesse.reflect.test;

import java.lang.reflect.Method;

import org.junit.Test;

public class MethodTest {

	@Test
	// 测试共有的方法
	public void demo1() throws Exception {
		Class c1 = Class.forName("com.jesse.reflect.test.Person");
		// 实例化：
		Person person = (Person)c1.newInstance();
		//获得共有的方法
		Method method = c1.getMethod("eat");
		// 执行该方法
		method.invoke(person); // person.eat();
	}
	
	@Test
	// 测试私有的方法
	public void demo2() throws Exception {
		Class c1 = Class.forName("com.jesse.reflect.test.Person");
		// 实例化：
		Person person = (Person)c1.newInstance();		
		//获得方法：
		Method method = c1.getDeclaredMethod("run");
		//设置私有的属性的访问权限
		method.setAccessible(true);
		//执行该方法：
		method.invoke(person, null);
	}
	
	@Test
	// 测试私有的方法带参数
	public void demo3() throws Exception {
		Class c1 = Class.forName("com.jesse.reflect.test.Person");
		// 实例化：
		Person person = (Person)c1.newInstance();
		//获得共有的方法
		Method method = c1.getMethod("sayHello" , String.class);
		// 执行该方法
		Object obj = method.invoke(person,"Tom"); // person.eat();	
		System.out.println(obj);
	}
}
