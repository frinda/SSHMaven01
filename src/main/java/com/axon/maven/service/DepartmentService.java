package com.axon.maven.service;

import java.util.List;

import com.axon.maven.dao.DepartmentDao;
import com.axon.maven.entities.Department;

public class DepartmentService {
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	public List<Department> getAll(){
		return departmentDao.getAll();
	}
}
