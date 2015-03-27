package com.idvorskij.forum.controlers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.idvorskij.forum.dao.DAO;
import com.idvorskij.forum.entities.Answer;
import com.idvorskij.forum.entities.Question;
import com.idvorskij.forum.entities.User;

/**
 * Servlet implementation class AnswerPage
 */
public class AnswerPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int questId = 0;
		try {
			questId = getQuestionId(request);
		} catch (Exception e1) {
			response.sendRedirect("Home");
			return;
		}

		Question question = null;
		try {
			question = DAO.INSTANCE.getQuestionById(questId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (question == null) {
			response.sendRedirect("Home");
			return;
		}

		List<Answer> answers = null;
		try {
			answers = DAO.INSTANCE.getAnswersByQuestionId(questId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (answers == null)
			answers = new LinkedList<Answer>();

		request.setAttribute("question", question);

		request.setAttribute("answers", answers);

		request.getRequestDispatcher("answers.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String answer = request.getParameter(ANSWER_PARAMETER_NAME);
		System.out.println("1");
		if (answer == null) {
			response.sendRedirect("Home");
			return;
		}
		System.out.println(2);
		HttpSession session = request.getSession();
		User user = Login.getUserFromSession(session);
		if (user == null) {
			response.sendRedirect("Home");
			return;
		}
		
		int questionId = 0;
		try {
			questionId = getQuestionId(request);
		} catch (Exception e1) {
			response.sendRedirect("Home");
			return;
		}

		Question question = null;
		try {
			question = DAO.INSTANCE.getQuestionById(questionId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (question == null) {
			response.sendRedirect("Home");
			return;
		}

		try {
			DAO.INSTANCE.addAnswer(new Answer(0, answer, user, new Date(),
					question));
		} catch (SQLException e) {
			response.sendRedirect("Home");
			return;
		}
		response.sendRedirect("Answer?question=" + questionId);
	}

	private int getQuestionId(HttpServletRequest request) throws Exception {

		String topicIdInString = request.getParameter(QUESTION_PARAMETER_NAME);
		String patternPageN = "[0123456789]*";

		// -------------------------------------------------------------------------------------------------------
		// validation topicIdInString if null or does not matches pattern
		// redirect Home
		// getting current page to show integer

		if (topicIdInString == null) {
			throw new Exception("1");
		}
		if (!topicIdInString.matches(patternPageN)) {
			throw new Exception("2");
		}

		int topicId = Integer.parseInt(topicIdInString);
		return topicId;
	}

	private static final String ANSWER_PARAMETER_NAME = "answer";
	private static final String QUESTION_PARAMETER_NAME = "question";

}
