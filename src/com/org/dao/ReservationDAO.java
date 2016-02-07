package com.org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;

import com.org.Exception.AppException;
import com.org.model.Reservation;
import com.org.util.ReservationUtil;

public class ReservationDAO {

	public List<Reservation> finadAllReservations() throws AppException, NotFoundException {
		List<Reservation> reserve = new ArrayList<Reservation>();
		Connection con = ReservationUtil.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("select * from reserve");
			rs = ps.executeQuery();
			while (rs.next()) {
				Reservation res = new Reservation();
				res.setId(rs.getInt("id"));
				res.setName(rs.getString("name"));
				res.setEmail(rs.getString("email"));
				res.setTelephone(rs.getInt("telephone"));
				res.setMessage(rs.getString("message"));
				res.setNoOfAttendees(rs.getInt("numberOfAttendees"));
				res.setDate(rs.getDate("date"));
				res.setTime(rs.getTime("time"));
				reserve.add(res);
			}

		} catch (SQLException e) {

			e.printStackTrace();
			throw new AppException(e.getMessage());
		}

		return reserve;
	}

	public Reservation findSpecificReservation(int id) throws AppException {
		Reservation res = null;
		Connection con = ReservationUtil.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("select * from reserve where id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				res = new Reservation();
				res.setId(rs.getInt("id"));
				res.setName(rs.getString("name"));
				res.setEmail(rs.getString("email"));
				res.setTelephone(rs.getInt("telephone"));
				res.setMessage(rs.getString("message"));
				res.setNoOfAttendees(rs.getInt("numberOfAttendees"));
				res.setDate(rs.getDate("date"));
				res.setTime(rs.getTime("time"));
			} else {
				throw new NotFoundException("Reservation with this id not found");
			}

		} catch (SQLException e) {

			e.printStackTrace();
			throw new AppException(e.getMessage());
		}

		return res;
	}

	public Reservation createResetvation(Reservation reserve) throws AppException {

		Connection con = ReservationUtil.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(
					"insert into reserve(name,email,telephone,message,numberOfAttendees,date,time) values(?,?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, reserve.getName());
			ps.setString(2, reserve.getEmail());
			ps.setInt(3, reserve.getTelephone());
			ps.setString(4, reserve.getMessage());
			ps.setInt(5, reserve.getNoOfAttendees());
			ps.setDate(6, reserve.getDate());
			ps.setTime(7, reserve.getTime());

			ps.executeUpdate();
			rs = ps.getGeneratedKeys();

			if (rs.next()) {

				reserve.setId(rs.getInt(1));

			} else {
				throw new NotFoundException("Reservation is found");
			}

		} catch (SQLException e) {

			e.printStackTrace();
			throw new AppException(e.getMessage());
		}

		return reserve;
	}

	public Reservation updateResetvation(int id, Reservation reserve) throws AppException {
		ReservationDAO rev = new ReservationDAO();
		try {
			if (rev.findSpecificReservation(id) != null) {
				Connection con = ReservationUtil.connect();
				PreparedStatement ps = null;

				ps = con.prepareStatement(
						"update reserve set name=?,email=?,telephone=?,message=?,numberOfAttendees=?,date=?,time=? where id=?");
				ps.setString(1, reserve.getName());
				ps.setString(2, reserve.getEmail());
				ps.setInt(3, reserve.getTelephone());
				ps.setString(4, reserve.getMessage());
				ps.setInt(5, reserve.getNoOfAttendees());
				ps.setDate(6, reserve.getDate());
				ps.setTime(7, reserve.getTime());
				ps.setInt(8, id);
				ps.executeUpdate();
			} else {
				throw new NotFoundException("Reservation with this id not found");
			}

		} catch (SQLException e) {

			e.printStackTrace();
			throw new AppException(e.getMessage());
		}

		return reserve;
	}

	public void deleteResetvation(int id) throws AppException {

		ReservationDAO dao = new ReservationDAO();
		try {
		if (dao.findSpecificReservation(id) != null) {
			Connection con = ReservationUtil.connect();
			PreparedStatement ps = null;
			
				ps = con.prepareStatement("delete from reserve where id=?");
				ps.setInt(1, id);
				ps.executeUpdate();
			}else {
				throw new NotFoundException("Reservation with this id not found");
			}
		}catch (SQLException e) {

				e.printStackTrace();
				throw new AppException(e.getMessage());
			}
		}

}
