package com.cognixia.jump.steakhouse.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognixia.jump.steakhouse.connection.ConnManager;
import com.cognixia.jump.steakhouse.dao.chef.Chef;
import com.cognixia.jump.steakhouse.dao.chef.ChefDAO;
import com.cognixia.jump.steakhouse.dao.location.Location;
import com.cognixia.jump.steakhouse.dao.location.LocationDAO;
import com.cognixia.jump.steakhouse.dao.menu.Menu;
import com.cognixia.jump.steakhouse.dao.menu.MenuDAO;
import com.cognixia.jump.steakhouse.dao.user.User;
import com.cognixia.jump.steakhouse.dao.user.UserDAO;

@WebServlet("/")
public class SteakhouseServlet extends HttpServlet {


	private static final long serialVersionUID = -8914749154745833647L;
	
	private LocationDAO locationDAO;
	private MenuDAO menuDAO;
	private UserDAO userDAO;
	private ChefDAO chefDAO;
	
	public void init() {
		locationDAO = new LocationDAO();
		menuDAO = new MenuDAO();
		userDAO = new UserDAO();
		chefDAO = new ChefDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch (action) {
		case "/list_locations":
			listLocations(request, response);
			break;
		case "/edit_location":
			goToEditLocationForm(request, response);
			break;
		case "/update_location":
			editLocation(request, response);
			break;
		case "/new_location":
			goToNewLocationForm(request, response);
			break;
		case "/insert_location":
			addNewLocation(request, response);
			break;
		case "/delete_location":
			deleteLocation(request, response);
			break;
		case "/list_menu":
			listMenu(request, response);
			break;
		case "/edit_menu":
			goToEditMenuForm(request, response);
			break;
		case "/update_menu":
			editMenu(request, response);
			break;
		case "/new_menu":
			goToNewMenuForm(request, response);
			break;
		case "/insert_menu":
			addNewMenu(request, response);
			break;
		case "/delete_menu":
			deleteMenu(request, response);
			break;
		case "/list_chefs":
			listChefs(request, response);
			break;
		case "/edit_chef":
			goToEditChefForm(request, response);
			break;
		case "/update_chef":
			editChef(request, response);
			break;
		case "/new_chef":
			goToNewChefForm(request, response);
			break;
		case "/insert_chef":
			addNewChef(request, response);
			break;
		case "/delete_chef":
			deleteChef(request, response);
			break;
		case "/list_users":
			listUsers(request, response);
			break;
		case "/edit_user":
			goToEditUserForm(request, response);
			break;
		case "/update_user":
			editUser(request, response);
			break;
		case "/new_user":
			goToNewUserForm(request, response);
			break;
		case "/insert_user":
			addNewUser(request, response);
			break;
		case "/delete_user":
			deleteUser(request, response);
			break;
		default:  // default will just go to our index.jsp page
			response.sendRedirect("/CaptainSteakHouseProject");
			break;
		}
	}
	
	private void listLocations(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		List<Location> allLocations = locationDAO.getAll();
		System.out.println("called, allLocations = " + allLocations);
		
		request.setAttribute("allLocations", allLocations);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("location-list.jsp");
		
		dispatcher.forward(request, response);
	}
	
	private void deleteLocation(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		if (locationDAO.deleteById(id)) {
			System.out.println("Deleted location ID#" + id);
		};
		
		response.sendRedirect("list_locations");
	}
	
	private void goToEditLocationForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Location location = locationDAO.getById(id);
		
		request.setAttribute("location", location);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("location-form.jsp");
		
		dispatcher.forward(request, response);
	}
	
	private void editLocation (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		int location_id = Integer.parseInt(request.getParameter("location_id"));
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		int zip = Integer.parseInt(request.getParameter("zip"));
		String phone = request.getParameter("phone");
		
		Location location = new Location(location_id, name, address, city, state, zip, phone);
		
		if(locationDAO.update(location)) {
			System.out.println("Updated Location ID#" + location_id + " as\n" + location);
		};
		
		response.sendRedirect("list_locations");
		
	}
	
	private void goToNewLocationForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("location-form.jsp");
		
		dispatcher.forward(request, response);
		
	}
	
	private void addNewLocation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		int zip = Integer.parseInt(request.getParameter("zip"));
		String phone = request.getParameter("phone");
		
		Location location = new Location(name, address, city, state, zip, phone);
			
			if(locationDAO.add(location)) {
				System.out.println("Created Location" + " as\n" + location);
			};
			
			response.sendRedirect("list_locations");
			
		}
	
	private void listMenu(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		List<Menu> allMenu = menuDAO.getAll();
		System.out.println("called, allMenu = " + allMenu);
		
		request.setAttribute("allMenu", allMenu);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("menu-list.jsp");
		
		dispatcher.forward(request, response);
	}
	
	private void deleteMenu(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		if (menuDAO.deleteById(id)) {
			System.out.println("Deleted menu ID#" + id);
		};
		
		response.sendRedirect("list_menu");
	}
	
	private void goToEditMenuForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Menu menu = menuDAO.getById(id);
		
		request.setAttribute("menu", menu);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("menu-form.jsp");
		
		dispatcher.forward(request, response);
	}
	
	private void editMenu (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int menu_id = Integer.parseInt(request.getParameter("menu_id"));
		String category = request.getParameter("category_name");
		String item = request.getParameter("item_name");
		double price = Double.parseDouble(request.getParameter("price"));

		Menu menu = new Menu(menu_id, category, item, price);
		
		if(menuDAO.update(menu)) {
			System.out.println("Updated menu ID#" + menu_id + " as\n" + menu);
		};
		
		response.sendRedirect("list_menu");
		
	}
	
	private void goToNewMenuForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("menu-form.jsp");
		
		dispatcher.forward(request, response);
		
	}
	
	private void addNewMenu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		String category = request.getParameter("category_name");
		String item = request.getParameter("item_name");
		double price = Double.parseDouble(request.getParameter("price"));

		Menu menu = new Menu(category, item, price);
			
			if(menuDAO.add(menu)) {
				System.out.println("Created menu item" + " as\n" + menu);
			};
			
			response.sendRedirect("list_menu");
			
		}
	
	private void listChefs(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		List<Chef> allChefs = chefDAO.getAll();
		System.out.println("called, allChefs = " + allChefs);
		
		request.setAttribute("allChefs", allChefs);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("chef-list.jsp");
		
		dispatcher.forward(request, response);
	}
	
	private void deleteChef(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		if (chefDAO.deleteById(id)) {
			System.out.println("Deleted chef ID#" + id);
		};
		
		response.sendRedirect("list_chefs");
	}
	
	private void goToEditChefForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Chef chef = chefDAO.getById(id);
		
		request.setAttribute("chef", chef);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("chef-form.jsp");
		
		dispatcher.forward(request, response);
	}
	
	private void editChef (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int index = Integer.parseInt(request.getParameter("chef_id"));
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");

		Chef chef = new Chef(index, firstName, lastName);
		
		if(chefDAO.update(chef)) {
			System.out.println("UPDATED CHEF ID#"  +index+ " as\n" + chef);
		};
		
		response.sendRedirect("list_chefs");
		
	}
	
	private void goToNewChefForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("chef-form.jsp");
		
		dispatcher.forward(request, response);
		
	}
	
	private void addNewChef(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");

		Chef chef = new Chef(firstName, lastName);
			
			if(chefDAO.add(chef)) {
				System.out.println("CREATED CHEF" + " as\n" + chef);
			};
			
			response.sendRedirect("list_chefs");
			
		}
	
	private void listUsers(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		List<User> allUsers = userDAO.getAll();
		System.out.println("called, allUsers = " + allUsers);
		
		request.setAttribute("allUsers", allUsers);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		
		dispatcher.forward(request, response);
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		if (userDAO.deleteById(id)) {
			System.out.println("Deleted user ID#" + id);
		};
		
		response.sendRedirect("list_users");
	}
	
	private void goToEditUserForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		User user = userDAO.getById(id);
		
		request.setAttribute("user", user);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		
		dispatcher.forward(request, response);
	}
	
	private void editUser (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int index = Integer.parseInt(request.getParameter("user_id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = new User(index, username, password);
		
		if(userDAO.update(user)) {
			System.out.println("UPDATED USER ID#" + index + " as\n" + user);
		};
		
		response.sendRedirect("list_users");
		
	}
	
	private void goToNewUserForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		
		dispatcher.forward(request, response);
		
	}
	
	private void addNewUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = new User(username, password);
			
			if(userDAO.add(user)) {
				System.out.println("CREATED USER" + " as\n" + user);
			};
			
			response.sendRedirect("list_users");
			
		}

	public void destroy() {
		try {
			ConnManager.getConnection().close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
