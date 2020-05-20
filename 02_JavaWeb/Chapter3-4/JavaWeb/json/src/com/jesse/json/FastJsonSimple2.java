package com.jesse.json;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class FastJsonSimple2 {
	public static void main(String[] args) {
		List<Employee> emplist = new ArrayList<Employee>();
		for(int i = 1; i <= 100; i++) {
			Employee emp = new Employee();
			emp.setEmpno(1000 + i);
			emp.setEname("员工" + i);
			emplist.add(emp);
		}
		String json = JSON.toJSONString(emplist);
		System.out.println(json);
		List<Employee> emps = JSON.parseArray(json, Employee.class);
		for(Employee e : emps) {
			System.out.println(e.getEmpno() + e.getEname());
		}
	}
}
