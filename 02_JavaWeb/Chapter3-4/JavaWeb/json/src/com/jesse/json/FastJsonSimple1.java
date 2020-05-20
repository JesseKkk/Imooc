package com.jesse.json;

import java.util.Calendar;

import com.alibaba.fastjson.JSON;

public class FastJsonSimple1 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(2019, 0, 30, 0, 0, 0);
		Employee emp = new Employee(1110, "孔金星", "Java工程师", c.getTime(), 20000f, "研发部");
		//FastJSON中提供JSON对象，完成对象与JSON字符串的相互转换
		String json = JSON.toJSONString(emp);
		System.out.println(json);
		Employee em = JSON.parseObject(json, Employee.class);
		System.out.println(em.getEname());
	}
}
