package com.yl.service.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yl.domain.Chat;
import com.yl.domain.User;
import com.yl.service.inter.UserServiceInter;
import com.yl.util.HibernateUtil;
import com.yl.util.SqlHelper;

public class UserServiceImp extends BaseService implements UserServiceInter {
	/*
	 * @author yl
	 * 
	 * @function 完成用户验证
	 */
	public User check(User user) {
		String hql = "from User where userid=? and userpwd=?";
		String[] parameters = { user.getUserid() + "", user.getUserpwd() };

		List<User> users = HibernateUtil.executeQuery(hql, parameters);
		if (users.size() == 0) {
			return null;
		} else {
			return users.get(0);
		}
	}

	public static ArrayList<Chat> getInfo(User user) {
		String sql = "select * from chat where receid=?";
		String[] parameters = { user.getUserid() + "" };

		ArrayList<Object[]> al = SqlHelper.executeQuery2(sql, parameters);
		ArrayList<Chat> al2 = new ArrayList<Chat>();
		if (al != null && al.size() != 0) {
			for (int i = 0; i < al.size(); i++) {
				Chat chat = new Chat();
				chat.setId((Integer) al.get(i)[0]);
				// chat.setTransid((Integer) al.get(i)[1]);
				// chat.setReceid((Integer) al.get(i)[2]);
				chat.setContent((String) al.get(i)[3]);
				chat.setTranstime((Date) al.get(i)[4]);
				al2.add(chat);
			}
		}
		return al2;
	}

	public User getUserByName(String name) {
		String hql = "from User where username=?";
		String[] parameters = { name };

		List<User> user = HibernateUtil.executeQuery(hql, parameters);
		if (user != null && user.size() != 0) {
			return user.get(0);
		} else {
			return null;
		}
	}
}
