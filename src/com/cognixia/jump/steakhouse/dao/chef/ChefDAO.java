package com.cognixia.jump.steakhouse.dao.chef;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.steakhouse.connection.ConnManager;
import com.cognixia.jump.steakhouse.dao.DAO;

public class ChefDAO implements DAO<Chef> {

	private Connection conn = ConnManager.getConnection();

	@Override
	public List<Chef> getAll() {
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("select * from chef");) {
			List<Chef> chefTable = new ArrayList<>();
			while (rs.next()) {
				// Getting SQL Attributes for each Tuple
				int index = rs.getInt("chef_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				int location = rs.getInt("location_id");

				// Make equivalent Java Bean
				Chef chef = new Chef(index, firstName, lastName, location);
				chefTable.add(chef);
			}
			return chefTable;
		} catch (SQLException e) {
			System.out.println("Error: Did not find match");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Chef getById(int id) {

		String query = "select * from chef where chef_id = ?";

		try (PreparedStatement pstmt = conn.prepareStatement(query);) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int index = rs.getInt("chef_id");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			int location = rs.getInt("location_id");
			Chef chef = new Chef(index, firstName, lastName, location);
			return chef;
		} catch (SQLException e) {
			System.out.println("Chef with id= " + id + " not found.");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Chef getByAttribute(String attribute, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Chef chef) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("insert into chef(first_name, last_name, location_id) values(?, ?, ?)");
			pstmt.setString(1, chef.getFirst_name());
			pstmt.setString(2, chef.getLast_name());
			pstmt.setInt(3, chef.getLocation_id());

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
		try (PreparedStatement pstmt = conn.prepareStatement("delete from chef where chef_id = ?")) {
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
	public boolean update(Chef chef) {
		// update
		try (PreparedStatement pstmt = conn
				.prepareStatement("update chef set first_name = ?, last_name = ?, location_id = ? where chef_id = ?")) {
			pstmt.setString(1, chef.getFirst_name());
			pstmt.setString(2, chef.getLast_name());
			pstmt.setInt(3, chef.getLocation_id());
			pstmt.setInt(4, chef.getChef_id());

			if (pstmt.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
