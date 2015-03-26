package com.idvorskij.forum.controlers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.idvorskij.forum.dao.DAO;
import com.idvorskij.forum.entities.Topic;

/**
 * Servlet implementation class Question
 */
public class Question extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String TOPIC_PARAMETER_NAME = "topic";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String topicIdInString = request.getParameter(TOPIC_PARAMETER_NAME);
		String patternPageN = "[0123456789]*";

		// -------------------------------------------------------------------------------------------------------
		// validation topicIdInString if null or does not matches pattern
		// redirect Home
		// getting current page to show integer

		if (topicIdInString == null) {
			response.sendRedirect("Home");
			return;
		}
		if (!topicIdInString.matches(patternPageN)) {

			response.sendRedirect("Home");
			return;
		}
		int topicId = Integer.parseInt(topicIdInString);
		Topic topic = null;
		try {
			topic = DAO.INSTANCE.getTopicyId(topicId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (topic == null){
			response.sendRedirect("Home");
			return;
			}

		List<com.idvorskij.forum.entities.Question> questions = null;
		try {
			questions = DAO.INSTANCE.getQuestionsByTopicId(topicId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (questions == null){
			response.sendRedirect("Home");
			return;
			}

		request.setAttribute("topicdata", topic.getContent());
		request.setAttribute("questions", questions);
		request.getRequestDispatcher("questions.jsp")
				.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
