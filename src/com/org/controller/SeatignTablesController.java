package com.org.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;
import com.org.Exception.AppException;
import com.org.dao.SeatingDAO;
import com.org.model.SeatingTables;;

@Path("/seating")
public class SeatignTablesController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<SeatingTables> findAllSeatingTables() {
		List<SeatingTables> seating = null;
		try {
			SeatingDAO dao = new SeatingDAO();
			seating = dao.findAllSeatingTables();
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return seating;
	}

	@GET
	@Path("/{tableno}")
	@Produces(MediaType.APPLICATION_JSON)
	public SeatingTables findSpecificSeatingTables(@PathParam("tableno") int tableno) {
		SeatingTables seating = null;

		
		try {
			SeatingDAO dao = new SeatingDAO();
			seating = dao.findSpecificSeatingTables(tableno);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}

		return seating;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public SeatingTables createSeatingTables(SeatingTables seatingTable) {

		if (Integer.toString(seatingTable.getTableNo()) == null
				|| Integer.toString(seatingTable.getTableNo()).equals("")
				|| Integer.toString(seatingTable.getTableSeating()) == null
				|| Integer.toString(seatingTable.getTableSeating()).equals("")) {
			throw new WebApplicationException(Status.BAD_REQUEST);
		}
		
		try {
			SeatingDAO dao=new SeatingDAO();
			seatingTable=dao.createSeatingTables(seatingTable);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return seatingTable;
	}

	@PUT
	@Path("/{tableno}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public SeatingTables updateSeatingTables(@PathParam("tableno") int tableno,SeatingTables seatingTable) {
		if (Integer.toString(seatingTable.getTableNo()) == null
				|| Integer.toString(seatingTable.getTableNo()).equals("")
				|| Integer.toString(seatingTable.getTableSeating()) == null
				|| Integer.toString(seatingTable.getTableSeating()).equals("")) {
			throw new WebApplicationException(Status.BAD_REQUEST);
		}
		
		try {
			System.out.println("&@*(&(*#123");
			SeatingDAO dao=new SeatingDAO();
			seatingTable=dao.updateSeatingTables(tableno,seatingTable);
			System.out.println("&@*(&(*#1234");
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return seatingTable;

	}

	@DELETE
	@Path("/{tableno}")
	public void deleteSeatingTables(@PathParam("tableno") int tableno) {
		try {
			SeatingDAO dao=new SeatingDAO();
			dao.deleteSeatingTables(tableno);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}