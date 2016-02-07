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
import com.org.dao.StatusReservationDAO;
import com.org.model.StatusReservation;

@Path("/status")
public class StatusReservationController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<StatusReservation> findAllReservationStatus(){
		List<StatusReservation> status=null;
		
		
		try {
			StatusReservationDAO dao=new StatusReservationDAO();
			status= dao.findAllReservationStatus();
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return status;
	}
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public StatusReservation findSpecificReservationStatus(@PathParam("id") int id){
		
		StatusReservation statusReservation =null;
		
		
		try {
			StatusReservationDAO dao= new StatusReservationDAO();
			statusReservation=dao.findSpecificReservationStatus(id);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		
		return statusReservation;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	
	public StatusReservation createStatusReservation(StatusReservation status){
		
		if (Integer.toString(status.getId()) == null
				|| Integer.toString(status.getId()).equals("")
				|| Integer.toString(status.getTableno()) == null
				|| Integer.toString(status.getTableno()).equals("")||status.getStatusType() == null || status.getStatusType().equals("")) {
			throw new WebApplicationException(Status.BAD_REQUEST);
		}
		
		
		try {
			StatusReservationDAO dao=new StatusReservationDAO();
			status=dao.createStatusReservation(status);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	
	public StatusReservation updateStatusReservation(@PathParam("id") int id, StatusReservation status){
		
		
		if (Integer.toString(status.getId()) == null
				|| Integer.toString(status.getId()).equals("")
				|| Integer.toString(status.getTableno()) == null
				|| Integer.toString(status.getTableno()).equals("")||status.getStatusType() == null || status.getStatusType().equals("")) {
			throw new WebApplicationException(Status.BAD_REQUEST);
		}
		
		try {
			StatusReservationDAO dao=new StatusReservationDAO();
			status=dao.updateStatusReservation(id,status);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	@DELETE
	@Path("/{id}")
	
	public void deleteStatusReservation(@PathParam("id") int id){
		
		
		try {
			StatusReservationDAO dao=new StatusReservationDAO();
			dao.deleteStatusReservation(id);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
