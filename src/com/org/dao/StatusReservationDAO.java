package com.org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;

import com.org.Exception.AppException;
import com.org.model.StatusReservation;
import com.org.util.ReservationUtil;

public class StatusReservationDAO {

	public List<StatusReservation> findAllReservationStatus() throws AppException {

		List<StatusReservation> status = new ArrayList<StatusReservation>();
		Connection con = ReservationUtil.connect();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("select * from statusReservation");
			rs = ps.executeQuery();
			while (rs.next()) {
				StatusReservation statusReservation = new StatusReservation();
				statusReservation.setId(rs.getInt("id"));
				statusReservation.setTableno(rs.getInt("tableno"));
				statusReservation.setStatusType(rs.getString("statusType"));
				status.add(statusReservation);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}

		return status;
	}

	public StatusReservation findSpecificReservationStatus(int id) throws AppException {
		StatusReservation status = null;
		Connection con = ReservationUtil.connect();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("select * from statusReservation where id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				status = new StatusReservation();
				status.setId(rs.getInt("id"));
				status.setTableno(rs.getInt("tableno"));
				status.setStatusType(rs.getString("statusType"));
			} else {
				throw new NotFoundException("Reservation with this id not found");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
		return status;
	}

	public StatusReservation createStatusReservation(StatusReservation status) throws AppException {

		Connection con = ReservationUtil.connect();

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement("INSERT INTO statusReservation (`id`, `tableno`, `statusType`) VALUES (?,?,?)");
			ps.setInt(1, status.getId());
			ps.setInt(2, status.getTableno());
			ps.setString(3, status.getStatusType());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}

		return status;
	}

	public StatusReservation updateStatusReservation(int id, StatusReservation status) throws AppException {

		StatusReservationDAO dao = new StatusReservationDAO();
		try {
			if (dao.findSpecificReservationStatus(id) != null) {
				Connection con = ReservationUtil.connect();
				PreparedStatement ps = null;

				System.out.println("@(!@*#The table no:" + status.getTableno());
				System.out.println("@(!@*#The status is:" + status.getStatusType());
				ps = con.prepareStatement("UPDATE statusReservation SET tableno=? , statusType=? WHERE id=?");
				ps.setInt(1, status.getTableno());
				ps.setString(2, status.getStatusType());
				ps.setInt(3, id);
				ps.executeUpdate();
			} else {
				throw new NotFoundException("Reservation with this id not found");
			}
		} catch (SQLException e) {

			e.printStackTrace();
			throw new AppException(e.getMessage());
		}

		return status;
	}

	public void deleteStatusReservation(int id) throws AppException {
		StatusReservationDAO dao = new StatusReservationDAO();
		Connection con = ReservationUtil.connect();
		PreparedStatement ps = null;
		try {
			if (dao.findSpecificReservationStatus(id) != null) {
				ps = con.prepareStatement("delete from statusReservation where id=?");
				ps.setInt(1, id);
				ps.executeUpdate();
			} else {
				throw new NotFoundException("Reservation with this id not found");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}

	}

}
