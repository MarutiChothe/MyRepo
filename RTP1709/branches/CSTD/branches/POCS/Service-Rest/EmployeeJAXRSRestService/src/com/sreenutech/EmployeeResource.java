package com.sreenutech;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/employees")
public class EmployeeResource {

	EmployeeDAO dao = new EmployeeDAO();
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Employee> findAll() {
		//return dao.findAll();
		
		List<Employee> employee = new ArrayList<Employee>();
		Employee e = new Employee();
		e.setFirstName("Sreenu");
		e.setLastName("Technologies");
		employee.add(e);
		e = new Employee();
		e.setFirstName("Sreenu22");
		e.setLastName("Technologies22");
		employee.add(e);
		return employee;
		
		
	}

	@GET @Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Employee findById(@PathParam("id") String id) {
		return dao.findById(Integer.parseInt(id));
	}
	
	@GET @Path("{id}/reports")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Employee> findByManager(@PathParam("id") String managerId) {
		return dao.findByManager(Integer.parseInt(managerId));
	}
}
