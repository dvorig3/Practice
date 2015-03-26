package idvorskij.labs.journal.controllers;

import idvorskij.labs.journal.dao.DAO;
import idvorskij.labs.journal.entities.Record;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Updater
 */
public class Updater extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String FA_ER = "fe";
	private static final String SI_ER = "si";
	private static final String WA = "w";
	private static final String RE = "r";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("Paginator?pageN=1");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// get id of record to update recordIdToUpdate
		String recordIdToUpdInObject = request.getParameter("id");

		// redirect to paginator if recordIdToUpdInObject == null or
		// recordIdToUpdInObject instanceof Integer == false
		if (recordIdToUpdInObject == null)
			response.sendRedirect("Paginator");
		// pattern to validate recordIdToUpdInObject (is a number?)
		String patternPageN = "[0123456789]*";
		if(!recordIdToUpdInObject.matches(patternPageN))
			response.sendRedirect("Paginator");

		// get recordIdToUpdate
		int recordIdToUpdate = Integer.parseInt(recordIdToUpdInObject);

		Record recordToUpdate = null;
		try {
			recordToUpdate = DAO.INSTANCE.getRecordById(recordIdToUpdate);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// validation of recordToUpdate if null redirect to paginator
		if (recordToUpdate == null)
			response.sendRedirect("Paginator");

		// get importance
		String importanceInObject = request.getParameter("imp");
		if (importanceInObject == null)
			response.sendRedirect("Paginator");
	}

}
