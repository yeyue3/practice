package com.yl.service.interfaces;

import java.io.Serializable;
import java.util.List;

import com.yl.domain.Employee;

public interface EmployServiceInter {
	
	public void addEmployee(Employee e);
	public List<Employee> showEmployee(int pageNow,int pageSize);
	public Employee getEmployeeById(Serializable id);
	public void updateEmployee(Employee e);
	public void delEmployee(java.io.Serializable id);
	public Employee checkEmployee(Employee employee);
	public Integer sumEmployee();
}
