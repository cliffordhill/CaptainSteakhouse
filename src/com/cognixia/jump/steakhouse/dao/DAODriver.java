package com.cognixia.jump.steakhouse.dao;

import com.cognixia.jump.steakhouse.dao.chef.Chef;
import com.cognixia.jump.steakhouse.dao.chef.ChefDAO;
import com.cognixia.jump.steakhouse.dao.location.Location;
import com.cognixia.jump.steakhouse.dao.location.LocationDAO;
import com.cognixia.jump.steakhouse.dao.menu.Menu;
import com.cognixia.jump.steakhouse.dao.menu.MenuDAO;

public class DAODriver {

	public static void main(String[] args) {
//		LocationDAO locationDAO = new LocationDAO();
//		Location addLoc = new Location("name", "address",  987);
//		locationDAO.add(addLoc);
//		Location updateLoc = new Location("New York City", "New York", "(555)555-5555", 7);
//		locationDAO.update(updateLoc);
//		locationDAO.deleteById(12);
//		System.out.println("\nList of all locations");
//		locationDAO.getAll().forEach(System.out::println);
//		
//		
//		ChefDAO chefDAO = new ChefDAO();
//		Chef addChef = new Chef("First", "Last", 6);
//		chefDAO.add(addChef);
//		Chef updateChef = new Chef("FIRST", "LAST", 7, 6);
//		chefDAO.update(updateChef);
//		chefDAO.deleteById(6);
//		System.out.println("\nList of all chefs");
//		chefDAO.getAll().forEach(System.out::println);
		
		
		MenuDAO menuDAO = new MenuDAO();
//		Menu addMenu = new Menu("Condiment", "Ketchup", 99.99);
//		menuDAO.add(addMenu);
//		Menu updateMenu = new Menu("Utensil", "Fork", 999.99, 16);
//		menuDAO.update(updateMenu);
//		menuDAO.deleteById(16);
		System.out.println("\nList of all menu items");
		menuDAO.getAll().forEach(System.out::println);
		
		
	}

}
