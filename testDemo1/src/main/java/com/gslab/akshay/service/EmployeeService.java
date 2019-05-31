package com.gslab.akshay.service;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gslab.akshay.dao.EmployeeDao;
import com.gslab.akshay.pojo.Employee;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeDao dao;
	
	public String registerEmployee(Employee emp) throws NamingException {
		return dao.registerEmployee(emp);
	}
	public Employee getEmployee(String fName)throws NamingException{
		return dao.getEmployee(fName);
	}
	public String deleteEmployee(int empNo) throws NamingException {
		return dao.deleteEmployee(empNo);
	}
	public String updateEmployee(Employee emp) throws NamingException {
		return dao.updateEmployee(emp);
	}
}
