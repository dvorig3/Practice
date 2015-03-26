package com.idvorskij.forum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;

import com.idvorskij.forum.entities.User;

public enum DAO {
	INSTANCE;

	DataSource dataSource;

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

	public Connection getConnection() throws ServletException {
		try {
			Connection conn = dataSource.getConnection();
			conn.setAutoCommit(false);
			return conn;
		} catch (SQLException ex) {
			throw new ServletException("Cannot obtain connection", ex);
		}
	}

	public void releaseConnection(Connection conn) throws ServletException {
		try {
			conn.close();
		} catch (SQLException ex) {
			throw new ServletException("Cannot release connection", ex);
		}
	}

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

	private static final String ADMIN_ROLE_NAME = "admin";
	// private static final String USER_ROLE_NAME = "user";

}
