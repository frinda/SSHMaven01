package com.axon.maven;

import java.util.List;

import javax.sql.DataSource;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.axon.maven.entities.Employee;
import com.axon.maven.service.DepartmentService;
import com.axon.maven.service.EmployeeService;

public class DaoTest {

	private EmployeeService employeeService;
	private DepartmentService departmentService;
	
	@Test
	public void testEmployee() throws SQLException{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//		DataSource dateSource = (DataSource)ctx.getBean(DataSource.class);
//		System.out.println(dateSource.getConnection());
		employeeService = ctx.getBean(EmployeeService.class);
		List<Employee> employees = employeeService.getAll();
		System.out.println(employees!=null?employees.size():0);
		for(int i=0;i<employees.size();i++){
			System.out.println(employees.get(i));
		}
	}
}
