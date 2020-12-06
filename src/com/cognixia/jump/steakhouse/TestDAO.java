package com.cognixia.jump.steakhouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.connection.ConnManager;

public class TestDAO implements DAO<Test>{

	private Connection conn = ConnManager.getConnection();

	@Override
	public List<Test> getAll() {
		try (Statement stmt = conn.createStatement(); 
				ResultSet rs = stmt.executeQuery("select * from testing");) {
			List<Test> testList = new ArrayList<>();
			while (rs.next()) {
				// Getting SQL Attributes for each Tuple
				int id = rs.getInt("id");
				String name = rs.getString("name");

				// Make equivalent Java Bean
				Test dept = new Test(id, name);
				testList.add(dept);
			}
			return testList;
		} catch (SQLException e) {
			System.out.println("Error: Did not find match");
		}
		return null;
	}
	
	@Override
	public Test getById(int id) {
		
		String query = "select * from testing where id = ?";
		
		try(PreparedStatement pstmt = conn.prepareStatement(query);){
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			
			int testId = rs.getInt("id");
			String name = rs.getString("name");
			
			Test test = new Test(testId, name);
			return test;
			
		}catch(SQLException e) {
			System.out.println("Test with id= " + id + " not found.");
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public Test getByAttribute(String attribute, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Test entry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int update(Test entry) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
