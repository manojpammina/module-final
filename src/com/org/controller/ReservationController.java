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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.org.Exception.AppException;
import com.org.dao.ReservationDAO;
import com.org.model.Reservation;

@Path("/reservations")
public class ReservationController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Reservation> findAllReservations() throws AppException {

		List<Reservation> reserve = null;
		try {
			ReservationDAO dao = new ReservationDAO();
			reserve = dao.finadAllReservations();
			
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return reserve;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Reservation findSpecificReservation(@PathParam("id") int id) {
		Reservation reserve = null;
		try {
			ReservationDAO dao = new ReservationDAO();
			reserve = dao.findSpecificReservation(id);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}

		return reserve;

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Reservation createResetvation(Reservation reserve) {

		if (reserve.getName() == null || reserve.getName().equals("") || reserve.getEmail() == null
				|| reserve.getEmail().equals("") || Integer.toString(reserve.getTelephone()) == null
				|| Integer.toString(reserve.getTelephone()).equals("") || reserve.getMessage() == null
				|| reserve.getMessage().equals("") || Integer.toString(reserve.getNoOfAttendees()) == null
				|| Integer.toString(reserve.getNoOfAttendees()).equals("") || reserve.getDate() == null
				|| reserve.getDate().equals("") || reserve.getTime() == null || reserve.getTime().equals("")){
			throw new WebApplicationException(Status.BAD_REQUEST);
		}

			try {
				ReservationDAO dao = new ReservationDAO();
				reserve = dao.createResetvation(reserve);
			} catch (AppException e) {
				e.printStackTrace();
				throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
			}

		return reserve;
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Reservation updateResetvation(@PathParam("id") int id,Reservation reserve) {
		try {
			ReservationDAO dao = new ReservationDAO();
			reserve = dao.updateResetvation(id,reserve);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		
		return reserve;
	}

	@DELETE
	@Path("/{id}")
	public Response deleteResetvation(@PathParam("id") int id) {
		try {
			ReservationDAO dao = new ReservationDAO();
			dao.deleteResetvation(id );
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return Response.ok().build();
	}
}
