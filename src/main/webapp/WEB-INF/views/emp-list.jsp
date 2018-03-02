<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Employee List Page</h4>
	<s:debug></s:debug>
	<s:if test="#request.employees==null||#request.employees.size == 0">
		没有任何员工信息
	</s:if>
	
	<s:else>
		<table cellpadding="10" cellspacing="1" border="1">
			<tr>
				<th>ID</th>
				<th>LASTNAME</th>
				<th>EMAIL</th>
				<th>BIRTH</th>
				<th>CREATETIME</th>
				<th>DEPT</th>
				<th>DELETE</th>
				<th>EDIT</th>
			</tr>
			<s:iterator value="#request.employees" var="emp">
				<tr>
					<td>${emp.id }</td>
					<td>${emp.lastName }</td>
					<td>${emp.email }</td>
					<td><s:date name="birth" format="yyyy-MM-dd" /></td>
					<td><s:date name="createTime" format="yyyy-MM-dd hh:mm:ss" /></td>
					<td>${emp.department.departmentName }</td>
					<td><a href="emp-delete?id=${emp.id }">DELETE</a></td>
					<td><a href="emp-input?id=${emp.id }">EDIT</a></td>
				</tr>
			</s:iterator>
		</table>
	</s:else>

</body>
</html>