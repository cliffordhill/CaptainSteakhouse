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
import com.cognixia.jump.steakhouse.dao.chef.ChefDAO;
import com.cognixia.jump.steakhouse.dao.location.LocationDAO;
import com.cognixia.jump.steakhouse.dao.menu.MenuDAO;
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
		// depending on ending url path, will redirect our servlet to complete
		// one of the actions in the switch case below
		String action = request.getServletPath();
		
		switch (action) {
		case "/account":
			account(request, response);
			break;
		case "/location":
			location(request, response);
			break;
		case "/deleteMenuItem":
			deleteMenuItem(request, response);
			break;
		case "/deleteLocation":
			deleteLocation(request, response);
			break;
		case "/deleteUser":
			deleteUser(request, response);
			break;
		case "/deleteChef":
			deleteChef(request, response);
			break;
		case "/editMenuItem":
			editMenuItem(request, response);
			break;
		case "/editLocation":
			editLocation(request, response);
			break;
		case "/editUser":
			editUser(request, response);
			break;
		case "/editChef":
			editChef(request, response);
			break;
		case "/update":
			editProduct(request, response);
			break;
		case "/new":
			goToNewProductForm(request, response);
			break;
		case "/insert":
			addNewProduct(request, response);
			break;

		default:  // default will just go to our index.jsp page
			response.sendRedirect("/CaptainSteakHouse");
			break;
		}
	}
	
	public void destroy() {
		try {
			ConnManager.getConnection().close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
