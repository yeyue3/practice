package com.yl.service.inter;

import com.yl.domain.Chat;
import com.yl.domain.User;

public interface BaseInterface {
	Object chekInfoById(Class clazz,java.io.Serializable id);
	public void saveMassage(Object obj);
}
