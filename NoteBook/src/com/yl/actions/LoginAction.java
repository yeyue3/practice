package com.yl.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.yl.domain.User;
import com.yl.forms.UserForm;
import com.yl.service.imp.UserServiceImp;
import com.yl.service.inter.UserServiceInter;

public class LoginAction extends DispatchAction{
	
	
	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserForm userForm = (UserForm) form;
		UserServiceInter usi = new UserServiceImp();
		User user = new User();
		user.setUserid(userForm.getUserid());
		user.setUserpwd(userForm.getPwd());
		user = usi.check(user);
		if(user!=null){
			request.getSession().setAttribute("userInfo", user);
			return mapping.findForward("loginok");
		}else{
			return mapping.findForward("goLoginUi");
		}
	}
	
	
	public ActionForward loginOut(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.getSession().invalidate();
		return mapping.findForward("goLoginUi");
	}
}
