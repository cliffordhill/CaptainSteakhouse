package com.cognixia.jump.steakhouse.dao.location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.steakhouse.connection.ConnManager;
import com.cognixia.jump.steakhouse.dao.DAO;

public class LocationDAO implements DAO<Location> {

	private Connection conn = ConnManager.getConnection();

	@Override
	public List<Location> getAll() {
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("select * from location");) {
			List<Location> locationTable = new ArrayList<>();
			while (rs.next()) {
				// Getting SQL Attributes for each Tuple
				int index = rs.getInt("location_id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String city = rs.getString("city");
				String state = rs.getString("state");
				int zip = rs.getInt("zip");
				String phone = rs.getString("phone");

				// Make equivalent Java Bean
				Location location = new Location(index, name, address, city, state, zip, phone);
				locationTable.add(location);
			}
			return locationTable;
		} catch (SQLException e) {
			System.out.println("Error: Did not find match");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Location getById(int id) {

		String query = "select * from location where location_id = ?";

		try (PreparedStatement pstmt = conn.prepareStatement(query);) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int index = rs.getInt("location_id");
			String name = rs.getString("name");
			String address = rs.getString("address");
			String city = rs.getString("city");
			String state = rs.getString("state");
			int zip = rs.getInt("zip");
			String phone = rs.getString("phone");
			Location location = new Location(index, name, address, city, state, zip, phone);
			return location;
		} catch (SQLException e) {
			System.out.println("Location with id= " + id + " not found.");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Location getByAttribute(String attribute, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Location location) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("insert into location(name, address, city, state, zip, phone) values(?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, location.getName());
			pstmt.setString(2, location.getAddress());
			pstmt.setString(3, location.getCity());
			pstmt.setString(4, location.getState());
			pstmt.setInt(5, location.getZip());
			pstmt.setString(6, location.getPhone());

			int i = pstmt.executeUpdate();

			if (i > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		// delete
		try (PreparedStatement pstmt = conn.prepareStatement("delete from location where location_id = ?")) {
			pstmt.setInt(1, id);
			// at least one row deleted
			if (pstmt.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Location location) {
		// update
		try (PreparedStatement pstmt = conn
				.prepareStatement("update location set name = ?, address = ?, city = ?, state = ?, zip = ?, phone = ? where location_id = ?")) {
			pstmt.setString(1, location.getName());
			pstmt.setString(2, location.getAddress());
			pstmt.setString(3, location.getCity());
			pstmt.setString(4, location.getState());
			pstmt.setInt(5, location.getZip());
			pstmt.setString(6, location.getPhone());
			pstmt.setInt(7, location.getId());

			if (pstmt.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public String getCityState(int id) {
		
		String query = "select * from location where location_id = ?";
		
		try (PreparedStatement pstmt = conn.prepareStatement(query);) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();

			String city = rs.getString("city");
			String state = rs.getString("state");

			return city + ", " + state;
			
		} catch (SQLException e) {
			System.out.println("Location with id= " + id + " not found.");
			e.printStackTrace();
		}
		return null;
	}
}
