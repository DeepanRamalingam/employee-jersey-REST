package com.stackroute.controller;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.stackroute.dao.EmployeeDAO;
import com.stackroute.dao.impl.EmployeeDAOImpl;
import com.stackroute.model.Employee;
import com.stackroute.service.EmployeeService;

@Path("/employees")
public class EmployeeController {
	
	private String jdbcURL= "jdbc:mysql://localhost:3306/emp_db";
	private String username = "root";
	private String password = "Root@123";
	EmployeeService employeeService = new EmployeeService(jdbcURL, username, password);
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getAllEmp() throws SQLException{
		return employeeService.getAllEmp();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmp(@PathParam("id") int id) throws SQLException {
		return employeeService.getEmp(id);
	}
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Employee update(@PathParam("id") int id,Employee emp) throws SQLException {
		
		emp.setId(id);
		return employeeService.editEmp(emp);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Employee addNewEmp(Employee emp) throws SQLException {
		return employeeService.addEmp(emp);
	}
	
	
	@DELETE
	@Path("/{id}")
	public void deleteEmp(@PathParam("id") int id) throws SQLException {
		employeeService.deleteEmp(id);
	}
}
