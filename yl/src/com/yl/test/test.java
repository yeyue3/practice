package com.yl.test;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.yl.domain.Department;
import com.yl.domain.Employee;
import com.yl.service.interfaces.DepartmentServiceInter;
import com.yl.service.interfaces.EmployServiceInter;

public class test {

	
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployServiceInter sf =  (EmployServiceInter) ac.getBean("employeeService");
		DepartmentServiceInter ds =  (DepartmentServiceInter) ac.getBean("departmentService");
		Employee employee = new Employee("qy@qq.com",1,new java.util.Date(),"ÆßÒ¶","111",12000F);
		//Employee employee2 = new Employee("yl@qq.com",2,new java.util.Date(),"ÔÂÁÁ","111",20000F);
		//Employee employee3 = new Employee("n@qq.com",3,new java.util.Date(),"Äã","111",15000F);
		
		//sf.addEmployee(employee);
		//sf.addEmployee(employee2);
		//sf.addEmployee(employee3);
		Department dep = ds. getDepartById(1);
		employee.setDepartment(dep);
		sf.addEmployee(employee);
		//Set<Employee> sets = new HashSet<Employee>();
		
		//sets.add(employee);
		//sets.add(employee2);
		//sets.add(employee3);
		
		
		//dep.setEmps(sets);
		//ds.addDepart(dep);
		
	}

}
