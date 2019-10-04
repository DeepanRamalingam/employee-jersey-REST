package com.stackroute.dao;

import java.sql.SQLException;
import java.util.List;

import com.stackroute.model.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll() throws SQLException;
	public Employee findById(int id) throws SQLException;
	public Employee addNew(Employee emp) throws SQLException;
	public boolean delete(int id) throws SQLException;
	public Employee update(Employee emp) throws SQLException;

}
