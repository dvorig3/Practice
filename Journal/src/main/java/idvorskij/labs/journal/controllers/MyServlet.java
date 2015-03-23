package idvorskij.labs.journal.controllers;

import idvorskij.labs.journal.dao.DAO;
import idvorskij.labs.journal.entities.Importance;
import idvorskij.labs.journal.entities.Record;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet() {
		super();
	}

	/**
	 * @throws ServletException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub

		response.setContentType("text/html; charset=ISO-8859-1");
		DAO dao = DAO.INSTANCE;
		// response.getWriter().print(dao.getT());
		//
		//
		// try {
		// response.getWriter().print(dao.getAllImpId());
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// response.getWriter().print("Error");
		// }

//		for (int i = 0; i < 100; ++i)
//			try {
//				dao.addRecord(new Record(RandomGenerator.getRandomDate(),
//						Importance.getImportanceBySigning(RandomGenerator
//								.getRandomImportanceSigningGenerator()),
//						RandomGenerator.getRandomString(5), RandomGenerator
//								.getRandomString(10)));
//			} catch (NullPointerException e) {
//				response.getWriter().print("Error1");
//			} catch (IllegalArgumentException e) {
//				response.getWriter().print("Error2");
//			} catch (SQLException e) {
//				response.getWriter().print("Error3");
//			}

		// try {
		// printList(response.getWriter(), dao.getRecordsSortedByDate());
		// } catch (SQLException e) {
		// response.getWriter().print("Erro4r3");
		// }
		// response.getWriter().print("------------------------ <p> <hr> <p>");
		// try {
		// response.getWriter().print(dao.getAllRecordsAmount());
		// } catch (SQLException e) {
		// response.getWriter().print("Erro4r3");
		// }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	public <T> void printList(PrintWriter out, List<T> list) {
		for (T t : list)
			out.print(t + "<br>");
	}

}
