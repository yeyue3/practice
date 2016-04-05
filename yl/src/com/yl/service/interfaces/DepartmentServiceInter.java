package com.yl.service.interfaces;

import com.yl.domain.Department;

public interface DepartmentServiceInter {
	public void addDepart(Department department);
	public Department getDepartById(java.io.Serializable id);
}
