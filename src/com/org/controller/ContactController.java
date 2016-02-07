package com.org.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.org.Exception.AppException;
import com.org.dao.ContactDAO;
import com.org.dao.ReservationDAO;
import com.org.model.Contact;
import com.org.model.Reservation;

@Path("/contact")
public class ContactController {

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Contact> findAllContacts()  {
		
		List<Contact> contact=null;
		try {
			ContactDAO dao=new ContactDAO();
			contact=dao.findAllContacts();
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return contact;
		
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Contact createContact(Contact contact) throws AppException {

		if (contact.getName() == null || contact.getName().equals("") || contact.getEmail() == null
				|| contact.getEmail().equals("") || Integer.toString(contact.getTelephone()) == null
				|| Integer.toString(contact.getTelephone()).equals("") || contact.getMessage() == null
				|| contact.getMessage().equals("")){
			throw new WebApplicationException(Status.BAD_REQUEST);
		}

			ContactDAO dao = new ContactDAO();
			contact = dao.createContact(contact);

		return contact;
	}
	@DELETE
	@Path("/{name}")
	public Response deleteContact(@PathParam("name") String name) throws AppException{
		ContactDAO dao=new ContactDAO();
		dao.deleteContact(name);
		return Response.ok().build();
		
	}
}
