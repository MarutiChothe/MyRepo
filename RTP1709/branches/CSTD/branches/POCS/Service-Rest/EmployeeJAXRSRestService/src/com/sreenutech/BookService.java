package com.sreenutech;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/books")
public class BookService {

	BookDAO dao = new BookDAO();
	
	@GET
	@Produces("application/json")
	public List<Book> findAll() {
		return dao.findAll();
	}
}
