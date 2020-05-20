package com.jesse.reflect.test;

import java.lang.reflect.Field;

import org.junit.Test;

public class FiledTest {
	
	private Object object;

	@Test
	//测试共有属性
	public void demo1() throws Exception {
		// 获得Class
		Class c1 = Class.forName("com.jesse.reflect.test.Person");
		// 获得属性
		Field field = c1.getField("name");
		// 操作属性  p.name = "";
		Person p = (Person)c1.newInstance();
		field.set(p, "李四");//p.name = "李四";
		
		Object obj = field.get(p);
		System.out.println(obj);
	}
	
	@Test
	// 测试私有属性
	public void demo2() throws Exception {
		// 获得Class
		Class c1 = Class.forName("com.jesse.reflect.test.Person");
		// 获得私有属性
		Field field = c1.getDeclaredField("sex");
		//操作属性
		Person p = (Person)c1.newInstance();
		field.setAccessible(true);
		field.set(p, "男");
		// 获取值
		Object obj = field.get(p);
		System.out.println(obj);
		System.out.println(p);
	}
}
