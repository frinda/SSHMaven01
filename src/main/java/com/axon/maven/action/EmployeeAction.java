package com.axon.maven.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.axon.maven.entities.Employee;
import com.axon.maven.service.DepartmentService;
import com.axon.maven.service.EmployeeService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class EmployeeAction extends ActionSupport implements RequestAware, ModelDriven<Employee>, Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EmployeeService employeeService;
	private DepartmentService departmentService;

	private Integer id;

	public void setId(Integer id) {
		this.id = id;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	private Map<String, Object> request;

	public String list() {
		List<Employee> employees = employeeService.getAll();
		request.put("employees", employees);
		return "emp-list";
	}

	public String input() {
		request.put("departments", departmentService.getAll());
		return "emp-input";
	}

	public String delete() {
		employeeService.delete(id);
		return SUCCESS;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

	public String save() {
		if (id == null) {
			model.setCreateTime(new Date());
		}
		employeeService.saveOrUpdate(model);
		return SUCCESS;
	}

	public void prepareSave() {
		if (id == null) {
			model = new Employee();
		} else {
			model = employeeService.get(id);
		}
	}

	public void prepareInput() {
		if (id != null)
			model = employeeService.get(id);
	}

	@Override
	public void prepare() throws Exception {

	}

	private Employee model;

	@Override
	public Employee getModel() {
		return model;
	}
}
