package com.yl.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yl.util.HibernateUtil;

public class MyFilter implements Filter{

	public void destroy() {
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		Session s = null;
		Transaction tx=null;
		System.out.println("¹ýÂËÆ÷");
		try{
			s=HibernateUtil.getCurrentSession();		
			tx=s.beginTransaction();
			arg2.doFilter(arg0, arg1);
			tx.commit();
		}catch (Exception e) {
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
			// TODO: handle exception
		}finally{
			
			HibernateUtil.closeCurrentSession();
			
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {	
	}

}
