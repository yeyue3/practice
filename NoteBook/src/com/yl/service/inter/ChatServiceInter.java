package com.yl.service.inter;

import java.util.List;

import com.yl.domain.Chat;
import com.yl.domain.User;

public interface ChatServiceInter extends BaseInterface{
	public List getMassageByPage(User user);
}
