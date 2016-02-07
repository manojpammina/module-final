package com.org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;

import com.org.Exception.AppException;
import com.org.model.SeatingTables;
import com.org.util.ReservationUtil;

public class SeatingDAO {

	public List<SeatingTables> findAllSeatingTables() throws AppException {

		List<SeatingTables> seating = new ArrayList<>();
		Connection con = ReservationUtil.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("select * from seatingTable");
			rs = ps.executeQuery();
			while (rs.next()) {
				SeatingTables st = new SeatingTables();
				st.setTableNo(rs.getInt("tableno"));
				st.setTableSeating(rs.getInt("tableseating"));
				seating.add(st);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
		return seating;
	}

	public SeatingTables findSpecificSeatingTables(int tableno) throws AppException {
		SeatingTables seating = null;
		Connection con = ReservationUtil.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("select * from seatingTable where tableno=?");
			ps.setInt(1, tableno);
			rs = ps.executeQuery();
			if (rs.next()) {
				seating = new SeatingTables();
				seating.setTableNo(rs.getInt("tableno"));
				seating.setTableSeating(rs.getInt("tableseating"));
			} else {
				throw new NotFoundException("Table not not found");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}

		return seating;
	}

	public SeatingTables createSeatingTables(SeatingTables seatingTable) throws AppException {

		Connection con = ReservationUtil.connect();
		PreparedStatement ps = null;

		try {

			ps = con.prepareStatement("insert into seatingTable(tableno,tableseating) values(?,?)");
			ps.setInt(1, seatingTable.getTableNo());
			ps.setInt(2, seatingTable.getTableSeating());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}

		return seatingTable;
	}

	public SeatingTables updateSeatingTables(int tableno, SeatingTables seatingTable) throws AppException {
		SeatingDAO seat = new SeatingDAO();

		try {
			if (seat.findSpecificSeatingTables(tableno) != null) {
				Connection con = ReservationUtil.connect();
				PreparedStatement ps = null;

				ps = con.prepareStatement("update seatingTable set tableseating=? where tableno=?");
				ps.setInt(1, seatingTable.getTableSeating());
				ps.setInt(2, tableno);
				ps.executeUpdate();
			} else {
				throw new NotFoundException("Table not not found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}

		return seatingTable;
	}

	public void deleteSeatingTables(int tableno) throws AppException {
		SeatingDAO dao = new SeatingDAO();
		Connection con = ReservationUtil.connect();
		PreparedStatement ps = null;

		try {
			if (dao.findSpecificSeatingTables(tableno) != null) {
				ps = con.prepareStatement("delete from seatingTable where tableno=?");
				ps.setInt(1, tableno);
				ps.executeUpdate();
			} else {
				throw new NotFoundException("Table not not found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}

	}

}
