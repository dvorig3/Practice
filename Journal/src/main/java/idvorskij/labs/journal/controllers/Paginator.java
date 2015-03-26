package idvorskij.labs.journal.controllers;

import idvorskij.labs.journal.dao.DAO;
import idvorskij.labs.journal.entities.Record;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Paginator
 */
public class Paginator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int pageCapacityDefault = 20;
	private static String sortTypeDate = "d";
	private static String sortTypeDefault = sortTypeDate;
	private static String sortTypeImportanceDate = "id";
	private static String sortTypeImportanceSourceDate = "isd";
	private static String sortTypeSourceDate = "sd";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// get session
		HttpSession session = request.getSession();

		// -------------------------------------------------------------------------------------------------------
		// get page capacity
		Object pagecapObj = session.getAttribute("pageCapacity");
		if (pagecapObj == null)
			session.setAttribute("pageCapacity", pageCapacityDefault);
		int pageCapacity = pagecapObj == null ? pageCapacityDefault
				: (pagecapObj instanceof Integer ? (Integer) pagecapObj
						: pageCapacityDefault);

		// -------------------------------------------------------------------------------------------------------
		// get sort type sortT from session
		Object sorttObj = session.getAttribute("sortT");
		if (sorttObj == null)
			session.setAttribute("sortT", sortTypeDefault);
		String sortType = sorttObj == null ? sortTypeDefault
				: (sorttObj instanceof String ? (String) sorttObj
						: sortTypeDefault);

		// -------------------------------------------------------------------------------------------------------
		// get amount of records
		int recordsAmount = 0;
		try {
			recordsAmount = DAO.INSTANCE.getAllRecordsAmount();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// -------------------------------------------------------------------------------------------------------
		// compute page amount
		int pageAmount = recordsAmount / pageCapacity + 1;

		// -------------------------------------------------------------------------------------------------------
		// get the number of page to show from parameter "pageN". write into
		// pageCurrentInString
		String pageCurrentInString = request.getParameter("pageN");

		// -------------------------------------------------------------------------------------------------------
		// pattern to validate pageCurrentInString (pageN parameter) (is a
		// number?)
		String patternPageN = "[0123456789]*";

		// -------------------------------------------------------------------------------------------------------
		// validation pageCurrentInString if null or does not matches pattern
		// set 1
		// getting current page to show integer

		//                      !!! instance of integer !!!!
		int pageCurrent = pageCurrentInString == null ? 1
				: !pageCurrentInString.matches(patternPageN) ? 1 : Integer
						.parseInt(pageCurrentInString) > pageAmount ? 1
						: Integer.parseInt(pageCurrentInString);

		// -------------------------------------------------------------------------------------------------------
		// define start and finish record in current page
		int start = (pageCurrent - 1) * pageCapacity;
		int finish = pageCurrent * pageCapacity - 1 >= recordsAmount ? recordsAmount - 1
				: pageCurrent * pageCapacity - 1;

		// -------------------------------------------------------------------------------------------------------
		// get list of records
		List<Record> records = null;
		try {
			records = getRecords(sortType).subList(start, finish);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// -------------------------------------------------------------------------------------------------------
		// compute previousPage, nextPage
		int previousPage = pageCurrent - 1 <= 1 ? 1 : pageCurrent - 1;
		int nextPage = pageCurrent + 1 >= pageAmount ? pageAmount
				: pageCurrent + 1;

		// -------------------------------------------------------------------------------------------------------
		// set request attribute
		request.setAttribute("sortTypeName", getSortTypeNameById(sortType));
		request.setAttribute("records", records);
		request.setAttribute("pageA", pageAmount);
		request.setAttribute("previous", previousPage);
		request.setAttribute("current", pageCurrent);
		request.setAttribute("next", nextPage);
		request.getRequestDispatcher("/paging.jsp").forward(request, response);
	}

	private List<Record> getRecords(String sortType) throws ServletException,
			SQLException {
		// sortTypeDate = 1
		// sortTypeImportanceDate = 2
		// sortTypeImportanceSourceDate = 3
		// sortTypeSourceDate = 4
		// other = 5 default

		int identificatorSortType = sortType.equals(sortTypeDate) ? 1
				: sortType.equals(sortTypeImportanceDate) ? 2 : sortType
						.equals(sortTypeImportanceSourceDate) ? 3 : sortType
						.equals(sortTypeSourceDate) ? 4 : 5;

		List<Record> list;

		switch (identificatorSortType) {
		case 1:
			list = DAO.INSTANCE.getRecordsSortedByDate();
			break;
		case 2:
			list = DAO.INSTANCE.getRecordsSortedByImportanceDate();
			break;
		case 3:
			list = DAO.INSTANCE.getRecordsSortedByImportanceSourceDate();
			break;
		case 4:
			list = DAO.INSTANCE.getRecordsSortedBySourceDate();
			break;
		default:
			list = DAO.INSTANCE.getRecordsSortedByDate();
			;
			break;
		}

		return list;
	}

	private String getSortTypeNameById(String sortType) {
		// sortTypeDate = 1
		// sortTypeImportanceDate = 2
		// sortTypeImportanceSourceDate = 3
		// sortTypeSourceDate = 4
		// other = 5 default

		int identificatorSortType = sortType.equals(sortTypeDate) ? 1
				: sortType.equals(sortTypeImportanceDate) ? 2 : sortType
						.equals(sortTypeImportanceSourceDate) ? 3 : sortType
						.equals(sortTypeSourceDate) ? 4 : 5;
		switch (identificatorSortType) {
		case 1:
			return "date";
		case 2:
			return "importance-date";
		case 3:
			return "importance-source-date";
		case 4:
			return "source-date";
		default:
			return "default:date";
		}
	}
}
