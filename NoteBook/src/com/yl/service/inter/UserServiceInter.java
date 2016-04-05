package com.yl.service.inter;

import com.yl.domain.User;

public interface UserServiceInter extends BaseInterface{
	public User check(User user);
	public User getUserByName(String name);
}
