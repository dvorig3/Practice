package idvorskij.labs.journal.controllers;

import idvorskij.labs.journal.dao.DAO;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SortRegistrator
 */
public class SortRegistrator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sortType = request.getParameter("sort");
		HttpSession session = request.getSession(true);
		session.setAttribute("sortT", sortType);
		int pageAmount = 0;
		try {
			pageAmount = DAO.INSTANCE.getAllRecordsAmount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.setAttribute("pageA", pageAmount);
		response.sendRedirect("Paginator?pageN=1");
		
	}

}
