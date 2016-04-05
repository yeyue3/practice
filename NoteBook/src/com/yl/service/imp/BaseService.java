package com.yl.service.imp;

import com.yl.service.inter.BaseInterface;
import com.yl.util.HibernateUtil;

public abstract class BaseService implements BaseInterface{
	public Object chekInfoById(Class clazz,java.io.Serializable id){
		return HibernateUtil.findById(clazz, id);
	}

	public void saveMassage(Object obj) {
		HibernateUtil.save(obj);
		
	}
}
