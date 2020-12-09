package com.cognixia.jump.steakhouse.dao.menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.steakhouse.connection.ConnManager;
import com.cognixia.jump.steakhouse.dao.DAO;


public class MenuDAO implements DAO<Menu> {

	private Connection conn = ConnManager.getConnection();

	@Override
	public List<Menu> getAll() {
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("select * from menu");) {
			List<Menu> menuTable = new ArrayList<>();
			while (rs.next()) {
				// Getting SQL Attributes for each Tuple
				int index = rs.getInt("menu_id");
				String category = rs.getString("category_name");
				String item = rs.getString("item_name");
				double price = rs.getDouble("price");

				// Make equivalent Java Bean
				Menu menu = new Menu(index, category, item, price);
				menuTable.add(menu);
			}
			return menuTable;
		} catch (SQLException e) {
			System.out.println("Error: Did not find match");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Menu getById(int id) {

		String query = "select * from menu where menu_id = ?";

		try (PreparedStatement pstmt = conn.prepareStatement(query);) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int index = rs.getInt("menu_id");
			String category = rs.getString("category_name");
			String item = rs.getString("item_name");
			double price = rs.getDouble("price");
			Menu menu = new Menu(index, category, item, price);
			return menu;
		} catch (SQLException e) {
			System.out.println("Menu item with id= " + id + " not found.");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Menu getByAttribute(String attribute, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Menu menu) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("insert into menu(category_name, item_name, price) values(?, ?, ?)");
			pstmt.setString(1, menu.getCategory_name());
			pstmt.setString(2, menu.getItem_name());
			pstmt.setDouble(3, menu.getPrice());

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
		try (PreparedStatement pstmt = conn.prepareStatement("delete from menu where menu_id = ?")) {
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
	public boolean update(Menu menu) {
		// update
		try (PreparedStatement pstmt = conn
				.prepareStatement("update menu set category_name = ?, item_name = ?, price = ? where menu_id = ?")) {
			pstmt.setString(1, menu.getCategory_name());
			pstmt.setString(2, menu.getItem_name());
			pstmt.setDouble(3, menu.getPrice());
			pstmt.setInt(4, menu.getMenu_id());

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
