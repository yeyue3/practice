package com.yl.service.imp;

import java.util.List;

import com.yl.domain.Chat;
import com.yl.domain.User;
import com.yl.service.inter.ChatServiceInter;
import com.yl.util.HibernateUtil;

public class ChatServiceImp extends BaseService implements ChatServiceInter {
	public List getMassageByPage(User user){
		String hql = "from Chat where getter.id=? or getter.id=3";
		String[] parameters={user.getUserid()+""};
		List chatList = HibernateUtil.executeQueryByPage(hql, parameters, 4, 1);
		return chatList;
	}
	
}
