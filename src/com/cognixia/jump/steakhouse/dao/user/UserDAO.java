package com.cognixia.jump.steakhouse.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.steakhouse.connection.ConnManager;
import com.cognixia.jump.steakhouse.dao.DAO;

public class UserDAO implements DAO<User> {

	private Connection conn = ConnManager.getConnection();

	@Override
	public List<User> getAll() {
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("select * from users");) {
			List<User> userTable = new ArrayList<>();
			while (rs.next()) {
				// Getting SQL Attributes for each Tuple
				int index = rs.getInt("user_id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				int admin = rs.getInt("is_admin");

				// Make equivalent Java Bean
				User user = new User(index, username, password, admin);
				userTable.add(user);
			}
			return userTable;
		} catch (SQLException e) {
			System.out.println("Error: Did not find match");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getById(int id) {

		String query = "select * from users where user_id = ?";

		try (PreparedStatement pstmt = conn.prepareStatement(query);) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int index = rs.getInt("user_id");
			String username = rs.getString("username");
			String password = rs.getString("password");
			int admin = rs.getInt("is_admin");
			User user = new User(index, username, password, admin);
			return user;
		} catch (SQLException e) {
			System.out.println("User with id= " + id + " not found.");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getByAttribute(String attribute, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(User user) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("insert into users(username, password, is_admin) values(?, ?, ?)");
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setInt(3, user.getIs_admin());

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
		try (PreparedStatement pstmt = conn.prepareStatement("delete from users where user_id = ?")) {
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
	public boolean update(User user) {
		// update
		try (PreparedStatement pstmt = conn
				.prepareStatement("update users set username = ?, password = ?, is_admin = ? where user_id = ?")) {
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setInt(3, user.getIs_admin());
			pstmt.setInt(4, user.getUser_id());

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
