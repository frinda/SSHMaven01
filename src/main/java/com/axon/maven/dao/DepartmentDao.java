package com.axon.maven.dao;

import java.util.List;

import com.axon.maven.entities.Department;

public class DepartmentDao extends BaseDao {
	
	public List<Department> getAll() {
		return getSession().createQuery("FROM Department").list();
	}
}
