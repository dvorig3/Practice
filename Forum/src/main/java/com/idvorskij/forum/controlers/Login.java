package com.idvorskij.forum.controlers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.idvorskij.forum.dao.DAO;
import com.idvorskij.forum.entities.User;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final String IS_LOGGED_ATTRIBUT_NAME = "logged";

	private static final String IS_LOGGED_ATTRIBUT_VALUE = "logged";

	private static final String LOGIN_PARAMETER_NAME = "nickname";

	private static final String PASSWORD_PARAMETER_NAME = "password";

	private static final long serialVersionUID = 1L;

	private static final String USER_ATTRIBUT_NAME = "user";

	private static final String ERROR_ATTRIBUT_NAME = "user";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		logout(session);
		response.sendRedirect("Home");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);

		// !isLogged
		if (isLoggedAnyone(session)) { // do smth
			request.setAttribute(ERROR_ATTRIBUT_NAME, "You need to log out!!!");
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
			return;
		}
		User user = null;
		try {
			user = getUserDataFromLoginFormAndReturnUser(request);
		} catch (SQLException e) {
			request.setAttribute(ERROR_ATTRIBUT_NAME,
					"Some problem occurred!!! Try again");
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
			return;
		}
		if (user == null) {// do smth
			request.setAttribute(ERROR_ATTRIBUT_NAME,
					"You input incorrect data!!!");
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
			return;
		}

		if (!login(session, user)) {
			request.setAttribute(ERROR_ATTRIBUT_NAME,
					"Some problem occurred!!! Try again");
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
			return;
		} else
			response.sendRedirect("Home");

	}

	/**
	 * check if any user is logged in
	 * 
	 * @param session
	 * @return false if no user is logged
	 */
	public static boolean isLoggedAnyone(HttpSession session) {
		if (session == null)
			return false;
		Object login = session.getAttribute(IS_LOGGED_ATTRIBUT_NAME);
		if (login == null)
			return false;
		if (!(login instanceof String))
			return false;
		if (!((String) login).equals(IS_LOGGED_ATTRIBUT_VALUE))
			return false;
		if (session.getAttribute(USER_ATTRIBUT_NAME) == null)
			return false;
		return true;
	}

	/**
	 * put to Session session -> User user
	 * 
	 * @param session
	 * @param user
	 * @return false if session or user is null value
	 */
	public static boolean login(HttpSession session, User user) {
		if (session == null || user == null)
			return false;
		session.setAttribute(IS_LOGGED_ATTRIBUT_NAME, IS_LOGGED_ATTRIBUT_VALUE);
		session.setAttribute(USER_ATTRIBUT_NAME, user);
		return true;
	}

	public static void logout(HttpSession session) {
		if (session != null)
			session.invalidate();
	}

	public static User getUserFromSession(HttpSession session) {
		if (session == null)
			return null;
		Object userObj = session.getAttribute(USER_ATTRIBUT_NAME);
		if (userObj == null)
			return null;
		if (!(userObj instanceof User))
			return null;

		return (User) userObj;
	}

	public static boolean isLoggedAdmin(HttpSession session) {
		if (isLoggedAnyone(session)) {
			User user = Login.getUserFromSession(session);
			if (user == null)
				return false;
			else {
				try {
					return isUserAdmin(user);
				} catch (ServletException e) {
					return false;
				} catch (SQLException e) {
					return false;
				}
			}
		}
		return false;
	}

	public static boolean isUserAdmin(User user) throws ServletException,
			SQLException {
		if (user == null)
			return false;
		return DAO.INSTANCE.isAdmin(user.getId());

	}

	private User getUserDataFromLoginFormAndReturnUser(
			HttpServletRequest request) throws ServletException, SQLException {
		// get login value and validate
		String login = request.getParameter(LOGIN_PARAMETER_NAME);
		if (login == null)
			return null;
		if (login.equals(""))
			return null;
		// get login value and validate
		String password = request.getParameter(PASSWORD_PARAMETER_NAME);
		if (password == null)
			return null;
		if (password.equals(""))
			return null;
		// get user by login data
		User user = DAO.INSTANCE.getUserByLoginData(login, password);

		return user;
	}

}
