package com.idvorskij.forum.controlers;

import javax.servlet.http.HttpSession;

import com.idvorskij.forum.entities.User;

public class StaticMethodsClass {

	private static final String IS_LOGGED_ATTRIBUT_NAME = "logged";
	private static final String IS_LOGGED_ATTRIBUT_VALUE = "logged";
	private static final String USER_ATTRIBUT_NAME = "user";

	/**
	 * check if any user is logged in
	 * @param session
	 * @return false if no user is logged
	 */
	public static  boolean isLogged(HttpSession session) {
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
}
