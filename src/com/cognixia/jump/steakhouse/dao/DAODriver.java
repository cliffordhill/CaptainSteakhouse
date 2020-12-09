package com.cognixia.jump.steakhouse.dao;


public class DAODriver {

	public static void main(String[] args) {
		LocationDAO locationDAO = new LocationDAO();
//		Location addLoc = new Location("name", "address",  987);
//		locationDAO.add(addLoc);
//		Location updateLoc = new Location("New York City", "New York", "(555)555-5555", 7);
//		locationDAO.update(updateLoc);
//		locationDAO.deleteById(12);
		System.out.println("\nList of all locations");
		locationDAO.getAll().forEach(System.out::println);

		
		
	}

}
