package com.org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.org.Exception.AppException;
import com.org.model.Contact;
import com.org.util.ReservationUtil;

public class ContactDAO {

	public List<Contact> findAllContacts() throws AppException {
		
		List<Contact> contact=new ArrayList<Contact>();
		Connection con=ReservationUtil.connect();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			ps=con.prepareStatement("select * from contact");
			rs=ps.executeQuery();
			while(rs.next()){
				Contact cont=new Contact();
				cont.setName(rs.getString("name"));
				cont.setEmail(rs.getString("email"));
				cont.setTelephone(rs.getInt("telephone"));
				cont.setMessage(rs.getString("message"));
				contact.add(cont);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
		
		
		return contact;
	}

	public Contact createContact(Contact contact) throws AppException {
		
		Connection con=ReservationUtil.connect();
		PreparedStatement ps=null;
		
		try {
			ps=con.prepareStatement("insert into contact(name,email,telephone,message) values(?,?,?,?)");
			ps.setString(1, contact.getName());
			ps.setString(2, contact.getEmail());
			ps.setInt(3, contact.getTelephone());
			ps.setString(4, contact.getMessage());
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
		
		return contact;
	}

	public void deleteContact(String name) throws AppException {
		Connection con=ReservationUtil.connect();
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement("delete from contact where name=?");
			ps.setString(1, name);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
		
	}

}
