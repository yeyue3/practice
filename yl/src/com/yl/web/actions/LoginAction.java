package com.yl.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.yl.domain.Employee;
import com.yl.service.interfaces.EmployServiceInter;
import com.yl.web.forms.LoginForm;

public class LoginAction extends DispatchAction {
	EmployServiceInter employServiceInter;

	public void setEmployServiceInter(EmployServiceInter employServiceInter) {
		this.employServiceInter = employServiceInter;
	}


	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(this.getServlet().getServletContext());
		//EmployServiceInter esi = (EmployServiceInter) ctx.getBean("employeeService");
		
		LoginForm loginForm = (LoginForm) form;
		Employee employee = new Employee();
		employee.setId(loginForm.getId());
		employee.setPwd(loginForm.getPwd());
		employee = employServiceInter.checkEmployee(employee);
		
		if(employee!=null){
			request.getSession().setAttribute("user", employee);
			return mapping.findForward("loginok");
		}else{
			return mapping.findForward("err");
		}
		
		
	}
	
	public ActionForward loginOut(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getSession().invalidate();
		return mapping.findForward("goLoginUi");
	}
}
