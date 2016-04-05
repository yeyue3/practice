package com.yl.service.imp;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.yl.domain.Employee;
import com.yl.service.interfaces.EmployServiceInter;

//这里配置注解，让Spring的事务管理器接管该service的所有事务,当然也可以配置到方法上
@Transactional
public class EmployeeService implements EmployServiceInter{
	@Resource
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addEmployee(Employee e) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(e);
	}

	public void delEmployee(Serializable id) {
		Session session = sessionFactory.getCurrentSession();
		Employee employee = (Employee) session.get(Employee.class, id);
		session.delete(employee);
	}

	public List<Employee> showEmployee(int pageNow,int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		List<Employee> list = null;
		
		String hql="from Employee";
		Query query = session.createQuery(hql);
		query.setFirstResult((pageNow-1)*pageSize).setMaxResults(pageSize);
		list = query.list();
		
		return list;
	}

	public void updateEmployee(Employee e) {
		sessionFactory.getCurrentSession().update(e);
	}

	public Employee checkEmployee(Employee employee) {
		String hql = "from Employee where id=? and pwd=?";

		List<Employee> emp = sessionFactory.getCurrentSession().createQuery(hql).setString(0,employee.getId() + "").setString(1,employee.getPwd() ).list();
		if (emp.size() == 0) {
			return null;
		} else {
			return emp.get(0);
		}
	}
	public Integer sumEmployee(){
		String hql = "select count(*) from Employee";
		
		Integer count = Integer.parseInt(sessionFactory.getCurrentSession().createQuery(hql).uniqueResult().toString());
		return count;
	}

	public Employee getEmployeeById(Serializable id) {
		String hql = "from Employee where id='"+id+"'";
		Employee employee = (Employee) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
		
		return employee;
	}
	
	
	
}
