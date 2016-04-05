package com.yl.service.imp;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.yl.domain.Department;
import com.yl.service.interfaces.DepartmentServiceInter;

@Transactional
public class DepartmentService implements DepartmentServiceInter {
	@Resource
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void addDepart(Department department){
		Session s = sessionFactory.getCurrentSession();
		s.save(department);
	}
	
	public Department getDepartById(java.io.Serializable id){
		Session s = sessionFactory.getCurrentSession();
		return (Department) s.load(Department.class, id);
	}
}
