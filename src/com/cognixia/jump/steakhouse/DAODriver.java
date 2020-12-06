package com.cognixia.jump.steakhouse;


public class DAODriver {

	public static void main(String[] args) {
		TestDAO testDAO = new TestDAO();
		System.out.println("List of all tests");
		testDAO.getAll().forEach(System.out::println);
		// get by id
		System.out.println("\nFind by Id");
		System.out.println(testDAO.getById(0));
	}

}
