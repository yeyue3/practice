package com.yl.actions;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.stat.Statistics;

import com.yl.domain.Chat;
import com.yl.domain.User;
import com.yl.forms.UserForm;
import com.yl.service.imp.ChatServiceImp;
import com.yl.service.inter.ChatServiceInter;
import com.yl.util.HibernateUtil;

public class goMassageUiAction extends DispatchAction{
	
	public ActionForward display(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserForm userForm = (UserForm) request.getAttribute("userForm");
		
		User user = new User();
		user.setUserid(userForm.getUserid());
		ChatServiceInter csi = new ChatServiceImp();
		List<Chat> al = csi.getMassageByPage(user);
		request.setAttribute("chat", al);
		
		Statistics statistics= HibernateUtil.getSessionFactory().getStatistics();
		System.out.println(statistics);
		System.out.println("放入"+statistics.getSecondLevelCachePutCount());
		System.out.println("命中"+statistics.getSecondLevelCacheHitCount());
		System.out.println("错过"+statistics.getSecondLevelCacheMissCount());
		return mapping.findForward("goMassageUi");
	}
}
