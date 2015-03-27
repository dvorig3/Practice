package com.idvorskij.forum.controlers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.idvorskij.forum.dao.DAO;
import com.idvorskij.forum.entities.Question;
import com.idvorskij.forum.entities.Topic;
import com.idvorskij.forum.entities.User;

/**
 * Servlet implementation class Adder
 */
public class Adder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		try {
//			DAO.INSTANCE.addUser(new User(0, "oleg"), "oleg");
//			DAO.INSTANCE.addUser(new User(0, "alan"), "alan");
//			DAO.INSTANCE.addUser(new User(0, "irena"), "irena");
//			DAO.INSTANCE.addUser(new User(0, "ivan"), "ivan");
//			DAO.INSTANCE.addUser(new User(0, "anna"), "anna");
//			DAO.INSTANCE.addUser(new User(0, "piter"), "piter");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			response.getWriter().print(DAO.INSTANCE.getTopics());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		try {
//			DAO.INSTANCE.addQuestion(new QuestionPage(0, new User(2, "oleg"), 24, new Date(), "NullPointerException occured!!!", 0));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	} 


}
