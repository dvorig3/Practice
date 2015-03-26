package com.idvorskij.forum.controlers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.idvorskij.forum.dao.DAO;
import com.idvorskij.forum.entities.Topic;
import com.idvorskij.forum.entities.User;

/**
 * Servlet implementation class Home
 */
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");
		if(user != null)
		request.setAttribute("userdata", "You are logged in as <span class = \"user-title\">"+user.getNickname()+"</span>");
		else request.setAttribute("user", "You need to log in. ");
		List<Topic> topics = null;
		try {
			topics = DAO.INSTANCE.getTopics();
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		request.setAttribute("topics", topics);
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	


}
