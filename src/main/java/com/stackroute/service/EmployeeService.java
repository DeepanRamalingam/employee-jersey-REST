package com.stackroute.service;

import java.sql.SQLException;
import java.util.List;

import com.stackroute.dao.EmployeeDAO;
import com.stackroute.dao.impl.EmployeeDAOImpl;
import com.stackroute.model.Employee;

public class EmployeeService {
	
	private String jdbcURL;
	private String username;
	private String password;
	EmployeeDAO empDAO;
	
	public EmployeeService(String jdbcURL, String username, String password) {
		this.jdbcURL = jdbcURL;
		this.username = username;
		this.password = password;
		empDAO = new EmployeeDAOImpl(this.jdbcURL, this.username, this.password);
	}

	public List<Employee> getAllEmp() throws SQLException {
		return empDAO.findAll();
	}
	
	public Employee getEmp(int id) throws SQLException {
		return empDAO.findById(id);
	}
	
	public Employee editEmp(Employee emp) throws SQLException {
		return empDAO.update(emp);
				
	}
	
	public Employee addEmp(Employee emp) throws SQLException {
		return empDAO.addNew(emp);
	}
	
	public void deleteEmp(int id) throws SQLException {
		empDAO.delete(id);
	}
}
