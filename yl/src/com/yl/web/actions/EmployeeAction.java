package com.yl.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.yl.domain.Employee;
import com.yl.service.interfaces.DepartmentServiceInter;
import com.yl.service.interfaces.EmployServiceInter;
import com.yl.web.forms.EmployeeForm;

public class EmployeeAction extends DispatchAction {
	DepartmentServiceInter departmentServiceInter;
	EmployServiceInter employServiceInter;

	public void setDepartmentServiceInter(
			DepartmentServiceInter departmentServiceInter) {
		this.departmentServiceInter = departmentServiceInter;
	}

	public void setEmployServiceInter(EmployServiceInter employServiceInter) {
		this.employServiceInter = employServiceInter;
	}

	public ActionForward gotoMainUi(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (request.getSession().getAttribute("user") != null) {
			return mapping.findForward("gotoMainUi");
		} else {
			return mapping.findForward("err");
		}
	}

	public ActionForward addUi(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return mapping.findForward("gotoAdd");
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		EmployeeForm employeeForm = (EmployeeForm) form;
		Employee employee = new Employee();

		employee.setEmail(employeeForm.getEmail());
		employee.setHeirdate(new java.util.Date());
		employee.setGrade(employeeForm.getGrade());
		employee.setName(employeeForm.getName());
		employee.setPwd(employeeForm.getPwd());
		employee.setSalary(employeeForm.getSalary());

		employee.setDepartment(departmentServiceInter.getDepartById(Integer
				.parseInt(employeeForm.getDepartment())));
		try {
			employServiceInter.addEmployee(employee);
			return mapping.findForward("ok");
		} catch (Exception e) {
			e.printStackTrace();
			return mapping.findForward("err");
		}

	}

	public ActionForward showUi(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String pageNows = request.getParameter("page");
		int pageNow;
		if (pageNows == null) {
			pageNow = 1;
		} else {
			pageNow = Integer.parseInt(pageNows);
		}
		int pageSize = 3;

		List<Employee> list = employServiceInter
				.showEmployee(pageNow, pageSize);
		request.setAttribute("list", list);

		int empSize = employServiceInter.sumEmployee();
		int pageCount = (empSize - 1) / pageSize + 1;

		request.setAttribute("page", pageNow);
		request.setAttribute("pageCount", pageCount);

		return mapping.findForward("show");
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		int id = Integer.parseInt(request.getParameter("id"));
		try {
			employServiceInter.delEmployee(id);
			return mapping.findForward("ok");
		} catch (Exception e) {
			e.printStackTrace();
			return mapping.findForward("err");
		}

	}

	public ActionForward gotoModifyUi(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Employee employee = employServiceInter.getEmployeeById(id);
		request.setAttribute("employee", employee);

		return mapping.findForward("goModifyUi");
	}

	public ActionForward modify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EmployeeForm empForm = (EmployeeForm) form;
		Integer id = empForm.getId();
		Employee emp = employServiceInter.getEmployeeById(id);
		emp.setEmail(empForm.getEmail());
		emp.setName(empForm.getName());
		emp.setSalary(empForm.getSalary());

		try {
			employServiceInter.updateEmployee(emp);
		} catch (Exception e) {
			e.printStackTrace();
			return mapping.findForward("err");
		}
		return mapping.findForward("ok");
	}
	
	public ActionForward gotoSeekUi(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("gotoSeekUi");
	}

	public ActionForward seek(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EmployeeForm empForm = (EmployeeForm) form;
		Employee emp = employServiceInter.getEmployeeById(empForm.getId());
		request.setAttribute("seekEmp", emp);
		
		return mapping.findForward("showAUser");
	}
}
