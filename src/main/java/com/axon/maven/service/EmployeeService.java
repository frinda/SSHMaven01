package com.axon.maven.service;

import java.util.List;

import com.axon.maven.dao.EmployeeDao;
import com.axon.maven.entities.Employee;

public class EmployeeService {
	
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	public List<Employee> getAll(){
		return employeeDao.getAll();
	}
	
	public void delete(int id){
		employeeDao.delete(id);
	}
	
	public Employee get(int id){
		return employeeDao.get(id);
	}
	
	public void saveOrUpdate(Employee employee){
		employeeDao.saveOrUpdate(employee);
	}
}
