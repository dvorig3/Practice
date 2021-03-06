package com.idvorskij.forum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;

import com.idvorskij.forum.entities.Answer;
import com.idvorskij.forum.entities.Question;
import com.idvorskij.forum.entities.Topic;
import com.idvorskij.forum.entities.User;

public enum DAO {
	INSTANCE;

	private static final String ADMIN_ROLE_NAME = "admin";

	// private static final String USER_ROLE_NAME = "user";

	/**
	 * 
	 */
	private DAO() {
		if (dataSource != null) {
			return;
		}
		try {
			Context ic = new InitialContext();
			dataSource = (DataSource) ic.lookup("java:comp/env/jdbc/HRDB");
		} catch (NamingException ex) {
			System.out.println("Naming");
		}
	}

	public void addAnswer(Answer answer) throws ServletException, SQLException {
		if (answer == null)
			return;
		if (answer.getQuestion() == null)
			if (answer.getContent() == null)
				return;
		if (answer.getDate() == null)
			return;
		if (answer.getUser() == null)
			return;

		Connection conn = getConnection();

		PreparedStatement statement = conn
				.prepareStatement("INSERT INTO ANSWER( CONTENT, DATE_A , QUESTION_ID, USER__ID) "
						+ " VALUES(?, ?, ?, ?)");
		statement.setString(1, answer.getContent());
		statement.setDate(2, new java.sql.Date(answer.getDate().getTime()));
		statement.setInt(3, answer.getQuestion().getId());
		statement.setInt(4, answer.getUser().getId());
		statement.execute();
		conn.commit();
		releaseConnection(conn);
	}

	/**
	 * 
	 * @param question
	 * @throws ServletException
	 * @throws SQLException
	 */
	public void addQuestion(com.idvorskij.forum.entities.Question question)
			throws ServletException, SQLException {
		if (question == null)
			return;
		if (question.getContent() == null)
			return;
		if (question.getDate() == null)
			return;
		if (question.getUser() == null)
			return;

		Connection con = getConnection();
		PreparedStatement statement = con
				.prepareStatement("INSERT INTO QUESTION( CONTENT, DATE_Q, USER__ID, TOPIC_ID) VALUES(?, ?, ?, ?)");
		statement.setString(1, question.getContent());
		statement.setDate(2, new java.sql.Date(question.getDate().getTime()));
		statement.setInt(3, question.getUser().getId());
		statement.setInt(4, question.getTopicId());
		statement.execute();
		con.commit();

		releaseConnection(con);
	}

	/**
	 * 
	 * @param topic
	 * @throws ServletException
	 * @throws SQLException
	 */

	public void addTopic(Topic topic) throws ServletException, SQLException {
		if (topic == null)
			return;
		if (topic.getContent() == null)
			return;
		Connection con = getConnection();
		PreparedStatement statement = con
				.prepareStatement("INSERT INTO TOPIC(CONTENT) VALUES (?)");
		statement.setString(1, topic.getContent());
		statement.execute();
		con.commit();
		releaseConnection(con);
	}

	/**
	 * 
	 * @param user
	 * @param password
	 * @throws SQLException
	 * @throws ServletException
	 */
	public void addUser(User user, String password) throws SQLException,
			ServletException {
		// ID NICKNAME STATUS USER_ROLE_ID PASSWORD
		if (user == null)
			return;
		if (password == null)
			return;
		if (user.getNickname() == null)
			return;
		if (user.getNickname().equals("") || password.equals(""))
			return;

		Connection con = getConnection();
		PreparedStatement statement = con
				.prepareStatement("INSERT INTO USER_(NICKNAME, STATUS, USER_ROLE_ID, PASSWORD ) VALUES (?, 0, 2, ?)");
		statement.setString(1, user.getNickname());
		statement.setString(2, password);
		statement.execute();
		con.commit();
		releaseConnection(con);
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws ServletException
	 * @throws SQLException
	 */
	public Topic getTopicyId(int id) throws ServletException, SQLException {
		Connection con = getConnection();
		PreparedStatement statement = con
				.prepareStatement("SELECT ID, CONTENT FROM TOPIC WHERE ID = ?");
		statement.setInt(1, id);
		Topic topic = null;
		ResultSet rs = statement.executeQuery();
		if (rs.next())
			topic = new Topic(rs.getInt("ID"), rs.getString("CONTENT"),
					getAnswerAmountOfQuestionById(id));
		releaseConnection(con);
		return topic;
	}

	/**
	 * 
	 * @param qId
	 * @return
	 * @throws ServletException
	 * @throws SQLException
	 */
	public List<Answer> getAnswersByQuestionId(int qId)
			throws ServletException, SQLException {
		Connection conn = getConnection();

		PreparedStatement statement = conn
				.prepareStatement("SELECT ID, CONTENT, DATE_A , QUESTION_ID, USER__ID  FROM ANSWER "
						+ " WHERE QUESTION_ID = ?");
		statement.setInt(1, qId);
		ResultSet rs = statement.executeQuery();
		List<Answer> listA = new LinkedList<Answer>();
		while (rs.next()) {
			listA.add(new Answer(rs.getInt("ID"), rs.getString("CONTENT"),
					getUserById(rs.getInt("USER__ID")), new java.util.Date(rs
							.getDate("DATE_A").getTime()), getQuestionById(rs
							.getInt("QUESTION_ID"))));
		}
		releaseConnection(conn);
		return listA;
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws ServletException
	 * @throws SQLException
	 */
	public Topic getAnswerById(int id) throws ServletException, SQLException {
		Connection con = getConnection();
		PreparedStatement statement = con
				.prepareStatement("SELECT ID, CONTENT FROM ANSWER WHERE ID = ?");
		statement.setInt(1, id);
		Topic topic = null;
		ResultSet rs = statement.executeQuery();
		if (rs.next())
			topic = new Topic(rs.getInt("ID"), rs.getString("CONTENT"),
					getAnswerAmountOfQuestionById(id));
		releaseConnection(con);
		return topic;
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws ServletException
	 * @throws SQLException
	 */
	public int getAnswerAmountOfQuestionById(int id) throws ServletException,
			SQLException {
		Connection con = getConnection();
		PreparedStatement statement = con
				.prepareStatement("SELECT COUNT(*) Q_COUNT FROM ANSWER WHERE QUESTION_ID = ?");
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();
		int res = 0;
		if (rs.next()) {
			res = rs.getInt("Q_COUNT");
		}
		releaseConnection(con);
		return res;
	}

	/**
	 * 
	 * @return
	 * @throws ServletException
	 */
	public Connection getConnection() throws ServletException {
		try {
			Connection conn = dataSource.getConnection();
			conn.setAutoCommit(false);
			return conn;
		} catch (SQLException ex) {
			throw new ServletException("Cannot obtain connection", ex);
		}
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws ServletException
	 * @throws SQLException
	 */
	public int getQuestionAmountOfTopicById(int id) throws ServletException,
			SQLException {
		Connection con = getConnection();
		PreparedStatement statement = con
				.prepareStatement("SELECT COUNT(*) Q_COUNT FROM QUESTION WHERE TOPIC_ID = ?");
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();
		int res = 0;
		if (rs.next()) {
			res = rs.getInt("Q_COUNT");
		}
		releaseConnection(con);
		return res;
	}

	/**
	 * 
	 * @return
	 * @throws ServletException
	 * @throws SQLException
	 */
	public List<Topic> getTopics() throws ServletException, SQLException {
		Connection con = getConnection();
		PreparedStatement statement = con
				.prepareStatement("SELECT ID, CONTENT FROM TOPIC");
		ResultSet rs = statement.executeQuery();
		List<Topic> listTopic = new LinkedList<Topic>();
		while (rs.next()) {
			int id = rs.getInt("ID");
			listTopic.add(new Topic(id, rs.getString("CONTENT"),
					getQuestionAmountOfTopicById(id)));
		}
		releaseConnection(con);
		return listTopic;
	}

	/**
	 * 
	 * @param topicId
	 * @return
	 * @throws ServletException
	 * @throws SQLException
	 */
	public List<Question> getQuestionsByTopicId(int topicId)
			throws ServletException, SQLException {
		Connection con = getConnection();
		PreparedStatement statement = con
				.prepareStatement("SELECT ID, CONTENT, DATE_Q, USER__ID, TOPIC_ID FROM QUESTION WHERE TOPIC_ID = ?");
		statement.setInt(1, topicId);
		ResultSet rs = statement.executeQuery();
		List<Question> listQuestion = new LinkedList<Question>();
		while (rs.next()) {
			int id = rs.getInt("ID");
			listQuestion.add(new Question(id,
					getUserById(rs.getInt("USER__ID")), topicId,
					new java.util.Date(rs.getDate("DATE_Q").getTime()), rs
							.getString("CONTENT"),
					getAnswerAmountOfQuestionById(id)));
		}
		releaseConnection(con);
		return listQuestion;
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws ServletException
	 * @throws SQLException
	 */
	public User getUserById(int id) throws ServletException, SQLException {
		Connection con = getConnection();
		PreparedStatement statement = con
				.prepareStatement("SELECT ID, NICKNAME FROM USER_ WHERE ID = ?");
		statement.setInt(1, id);
		User user = null;
		ResultSet rs = statement.executeQuery();
		if (rs.next())
			user = new User(rs.getInt("ID"), rs.getString("NICKNAME"));
		releaseConnection(con);
		return user;
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws ServletException
	 * @throws SQLException
	 */
	public Question getQuestionById(int id) throws ServletException,
			SQLException {
		Connection con = getConnection();
		PreparedStatement statement = con
				.prepareStatement("SELECT ID, CONTENT, DATE_Q, USER__ID, TOPIC_ID FROM QUESTION WHERE ID = ?");
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();

		Question q = null;
		if (rs.next()) {
			int idQ = rs.getInt("ID");
			q = new Question(idQ, getUserById(rs.getInt("USER__ID")),
					rs.getInt("TOPIC_ID"), new java.util.Date(rs.getDate(
							"DATE_Q").getTime()), rs.getString("CONTENT"),
					getAnswerAmountOfQuestionById(idQ));
		}
		releaseConnection(con);
		return q;
	}

	/**
	 * 
	 * @param nick
	 * @param password
	 * @return
	 * @throws ServletException
	 * @throws SQLException
	 */
	public User getUserByLoginData(String nick, String password)
			throws ServletException, SQLException {
		if (nick == null || password == null)
			return null;
		if (nick.equals("") || password.equals(""))
			return null;
		Connection con = getConnection();
		PreparedStatement statement = con
				.prepareStatement("SELECT ID, NICKNAME FROM USER_ WHERE NICKNAME = ? AND PASSWORD = ?");
		statement.setString(1, nick);
		statement.setString(2, password);
		User user = null;
		ResultSet rs = statement.executeQuery();
		if (rs.next())
			user = new User(rs.getInt("ID"), rs.getString("NICKNAME"));
		releaseConnection(con);
		return user;
	}

	/**
	 * 
	 * @param adminId
	 * @return
	 * @throws ServletException
	 * @throws SQLException
	 */
	public boolean isAdmin(int adminId) throws ServletException, SQLException {
		Connection con = getConnection();
		PreparedStatement statement = con
				.prepareStatement("SELECT USER_.ID ID_ , USER_.NICKNAME NICK_ "
						+ " FROM USER_ INNER JOIN  USER_ROLE ON USER_.USER_ROLE_ID = USER_ROLE.ID"
						+ " WHERE USER_.ID = ? AND USER_ROLE.ROLE = ?");
		statement.setInt(1, adminId);
		statement.setString(2, ADMIN_ROLE_NAME);
		User user = null;
		ResultSet rs = statement.executeQuery();
		if (rs.next())
			user = new User(rs.getInt("ID_"), rs.getString("NICK_"));
		releaseConnection(con);
		return user != null;
	}

	public void releaseConnection(Connection conn) throws ServletException {
		try {
			conn.close();
		} catch (SQLException ex) {
			throw new ServletException("Cannot release connection", ex);
		}
	}

	DataSource dataSource;

}
