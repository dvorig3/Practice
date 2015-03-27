package com.idvorskij.forum.controlers;

import java.io.IOException;
import java.net.HttpRetryException;
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
 * Servlet implementation class QuestionPage
 */
public class QuestionPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String TOPIC_PARAMETER_NAME = "topic";
	private static final String QUESTION_PARAMETER_NAME = "question";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int topicId = 0;
		try {
			topicId = getTopicId(request);
		} catch (Exception e1) {
			response.sendRedirect("Home");
			return;
		}
		Topic topic = null;
		try {
			topic = DAO.INSTANCE.getTopicyId(topicId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (topic == null) {
			response.sendRedirect("Home");
			return;
		}

		List<com.idvorskij.forum.entities.Question> questions = null;
		try {
			questions = DAO.INSTANCE.getQuestionsByTopicId(topicId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (questions == null) {
			response.sendRedirect("Home");
			return;
		}
		HttpSession session = request.getSession();
		User user = Login.getUserFromSession(session);
		if (user != null)
			request.setAttribute(
					"userdata",
					"You are logged in as <span class = \"user-title\">"
							+ user.getNickname() + "</span>");
		else
			request.setAttribute("user", "You need to log in. ");
		request.setAttribute("topicdata", topic);
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

		String question = request.getParameter(QUESTION_PARAMETER_NAME);
		if (question == null) {
			response.sendRedirect("Home");
			return;
		}

		HttpSession session = request.getSession();
		User user = Login.getUserFromSession(session);
		if (user == null) {
			response.sendRedirect("Home");
			return;
		}
		int topicId = 0;
		try {
			topicId = getTopicId(request);
		} catch (Exception e1) {
			response.sendRedirect("Home");
			return;
		}

		Topic topic = null;
		try {
			topic = DAO.INSTANCE.getTopicyId(topicId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (topic == null) {
			response.sendRedirect("Home");
			return;
		}

		try {
			DAO.INSTANCE.addQuestion(new com.idvorskij.forum.entities.Question(
					0, user, topicId, new java.util.Date(), question, 0));
		} catch (SQLException e) {
			response.sendRedirect("Home");
			return;
		}
		response.sendRedirect("Question?topic="+topicId);
	}

	private int getTopicId(HttpServletRequest request) throws Exception {

		String topicIdInString = request.getParameter(TOPIC_PARAMETER_NAME);
		String patternPageN = "[0123456789]*";

		// -------------------------------------------------------------------------------------------------------
		// validation topicIdInString if null or does not matches pattern
		// redirect Home
		// getting current page to show integer

		if (topicIdInString == null) {
			throw new Exception();
		}
		if (!topicIdInString.matches(patternPageN)) {
			throw new Exception();
		}

		int topicId = Integer.parseInt(topicIdInString);
		return topicId;
	}

}
