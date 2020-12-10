package com.cognixia.jump.steakhouse.dao;

import com.cognixia.jump.steakhouse.dao.chef.Chef;
import com.cognixia.jump.steakhouse.dao.chef.ChefDAO;
import com.cognixia.jump.steakhouse.dao.location.Location;
import com.cognixia.jump.steakhouse.dao.location.LocationDAO;
import com.cognixia.jump.steakhouse.dao.menu.Menu;
import com.cognixia.jump.steakhouse.dao.menu.MenuDAO;
import com.cognixia.jump.steakhouse.dao.user.User;
import com.cognixia.jump.steakhouse.dao.user.UserDAO;

public class DAODriver {

	public static void main(String[] args) {
		LocationDAO locationDAO = new LocationDAO();
//		Location addLoc = new Location("name", "address",  987);
//		locationDAO.add(addLoc);
//		Location updateLoc = new Location("New York City", "New York", "(555)555-5555", 7);
//		locationDAO.update(updateLoc);
//		locationDAO.deleteById(12);
		System.out.println("\n"+locationDAO.getCityState(1));
		System.out.println("\nList of all locations:");
		locationDAO.getAll().forEach(System.out::println);
		
		
		ChefDAO chefDAO = new ChefDAO();
//		Chef addChef = new Chef("First", "Last", 6);
//		chefDAO.add(addChef);
//		Chef updateChef = new Chef("FIRST", "LAST", 7, 6);
//		chefDAO.update(updateChef);
//		chefDAO.deleteById(6);
		System.out.println("\nList of all chefs:");
		chefDAO.getAll().forEach(System.out::println);
		
		
		MenuDAO menuDAO = new MenuDAO();
//		Menu addMenu = new Menu("Condiment", "Ketchup", 99.99);
//		menuDAO.add(addMenu);
//		Menu updateMenu = new Menu("Utensil", "Fork", 999.99, 16);
//		menuDAO.update(updateMenu);
//		menuDAO.deleteById(16);
		System.out.println("\nList of all menu items:");
		menuDAO.getAll().forEach(System.out::println);
		
		
		UserDAO userDAO = new UserDAO();
//		User addUser = new User("User", "Password", 0);
//		userDAO.add(addUser);
//		User updateUser = new User("SuperAdmin", "Super", 1, 3);
//		userDAO.update(updateUser);
//		userDAO.deleteById(3);
		System.out.println("\nList of all users:");
		userDAO.getAll().forEach(System.out::println);
	}
}
