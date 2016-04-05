package com.yl.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.yl.domain.Chat;
import com.yl.domain.User;
import com.yl.forms.MassageForm;
import com.yl.service.imp.ChatServiceImp;
import com.yl.service.imp.UserServiceImp;
import com.yl.service.inter.ChatServiceInter;
import com.yl.service.inter.UserServiceInter;

public class goMassagePublishAction extends DispatchAction{
	public ActionForward goPublish(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("goPublishMassageUi");
	}
	
	public ActionForward publish(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		MassageForm massageForm = (MassageForm) form;
		System.out.println(massageForm.getContent());
		
		Chat chat = new Chat();
		UserServiceInter usi = new UserServiceImp();
		User getter = usi.getUserByName(massageForm.getGetterName());	
		chat.setGetter(getter);
		chat.setContent(massageForm.getContent());
		chat.setSender((User)(request.getSession().getAttribute("userInfo")));
		chat.setTranstime(new java.util.Date());
		
		ChatServiceInter csi = new ChatServiceImp();
		csi.saveMassage(chat);
		
		return mapping.findForward("publishOk");
	}
}
