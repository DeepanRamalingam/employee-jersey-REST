package com.stackroute.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.stackroute.dao.EmployeeDAO;
import com.stackroute.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	private Connection con;
	private String jdbcURL;
	private String username;
	private String password;
	
	public EmployeeDAOImpl(String jdbcURL, String username, String password) {
		this.jdbcURL = jdbcURL;
		this.username = username;
		this.password = password;
	}
	
	public void connect() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			
		}
		con = DriverManager.getConnection(jdbcURL,username,password);
	}
	
	public void disconnect() throws SQLException {
		con.close();
	}

	public List<Employee> findAll() throws SQLException {
		
		List<Employee> employees = new ArrayList<Employee>();
		connect();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from employee");
		while(rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String gender = rs.getString(3);
			String designation = rs.getString(4);
			String city = rs.getString(5);
			long salary = rs.getLong(6);
			
			Employee emp = new Employee(id,name,gender,designation,city,salary);
			employees.add(emp);
		}
		rs.close();
		stmt.close();
		disconnect();
	
		return employees;
	}

	public Employee findById(int id) throws SQLException {
		
		Employee emp = null;
		connect();
		PreparedStatement stmt = con.prepareStatement("select * from employee where empid = ?");
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			int eid = rs.getInt(1);
			String name = rs.getString(2);
			String gender = rs.getString(3);
			String designation = rs.getString(4);
			String city = rs.getString(5);
			long salary = rs.getLong(6);
			
			emp = new Employee(eid,name,gender,designation,city,salary);
		}
		
		rs.close();
		stmt.close();
		disconnect();
		return emp;
	}

	public boolean delete(int id) throws SQLException {
		
		connect();
		PreparedStatement stmt = con.prepareStatement("delete from employee where empid = ?");
		stmt.setInt(1, id);
		boolean status = stmt.executeUpdate() > 0;
		stmt.close();
		disconnect();
		return status;
	}

	public Employee update(Employee emp) throws SQLException {
		connect();
		PreparedStatement stmt = con.prepareStatement("update employee"
				+ " set empname = ?, gender = ?, "
				+ "design = ?, city = ?, salary = ? where empid = ?");
		stmt.setString(1, emp.getName());
		stmt.setString(2, emp.getGender());
		stmt.setString(3, emp.getDesignation());
		stmt.setString(4, emp.getCity());
		stmt.setLong(5, emp.getSalary());
		stmt.setInt(6, emp.getId());
		stmt.executeUpdate();
		stmt.close();
		disconnect();
		return emp;
	}

	public Employee addNew(Employee emp) throws SQLException {
		connect();
		PreparedStatement stmt = con.prepareStatement("insert into employee values(?,?,?,?,?,?)");
		stmt.setInt(1, emp.getId());
		stmt.setString(2, emp.getName());
		stmt.setString(3, emp.getGender());
		stmt.setString(4, emp.getDesignation());
		stmt.setString(5, emp.getCity());
		stmt.setLong(6, emp.getSalary());
		stmt.executeUpdate();
		stmt.close();
		disconnect();
		return emp;
	}
	
}
