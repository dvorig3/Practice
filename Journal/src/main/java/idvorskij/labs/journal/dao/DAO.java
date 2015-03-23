package idvorskij.labs.journal.dao;

import idvorskij.labs.journal.entities.Importance;
import idvorskij.labs.journal.entities.Record;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;

public enum DAO {
	INSTANCE;

	DataSource dataSource;

	// !!! throwing problem
	private DAO() {
		if (dataSource != null) {
			return;
		}
		try {
			Context ic = new InitialContext();
			dataSource = (DataSource) ic.lookup("java:comp/env/jdbc/HRDB");
		} catch (NamingException ex) {
			System.out.println("Naming");
			// throw new ServletException(
			// ex);

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

	public Map<Integer, String> getAllImpId() throws ServletException,
			SQLException {

		Map<Integer, String> intL = new HashMap<Integer, String>();
		Connection con = getConnection();
		PreparedStatement statement = con
				.prepareStatement("SELECT * FROM IMPORTANCE");

		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			intL.put(rs.getInt("ID"), rs.getString("SIGNING"));
		}

		releaseConnection(con);
		return intL;
	}

	public void addRecord(Record record) throws ServletException, SQLException {
		Connection con = getConnection();
		PreparedStatement statement = con
				.prepareStatement("INSERT INTO RECORDS(DATE_E, IMPORTANCE, SOURCE, MESSAGE)"
						+ " VALUES (?, ?, ?, ?)");
		long s = record.getDate().getTime();
		statement.setTimestamp(1, new java.sql.Timestamp(s));
		statement.setInt(2, record.getImportance().getImportanceNumber());
		statement.setString(3, record.getSource());
		statement.setString(4, record.getMessage());
		statement.execute();
		con.commit();

		releaseConnection(con);
	}

	public String getT() {
		return "DAO";
	}

	public List<Record> getRecordsSortedByDate() throws ServletException,
			SQLException {
		// ID DATE_E IMPORTANCE SOURCE MESSAGE
		List<Record> intL = new ArrayList<Record>();
		Connection con = getConnection();
		PreparedStatement statement = con
				.prepareStatement("SELECT * FROM RECORDS"
						+ " ORDER BY DATE_E DESC");

		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			intL.add(new Record(rs.getInt("ID"), new Date(rs.getTimestamp(
					"DATE_E").getTime()), Importance
					.getImportanceByImportanceNumber(rs.getInt("IMPORTANCE")),
					rs.getString("SOURCE"), rs.getString("MESSAGE")));
		}

		releaseConnection(con);
		return intL;
	}

	public List<Record> getRecordsSortedByImportanceDate()
			throws ServletException, SQLException {
		// ID DATE_E IMPORTANCE SOURCE MESSAGE
		List<Record> intL = new ArrayList<Record>();
		Connection con = getConnection();
		PreparedStatement statement = con
				.prepareStatement("SELECT * FROM RECORDS"
						+ " ORDER BY IMPORTANCE, DATE_E DESC");

		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			intL.add(new Record(rs.getInt("ID"), new Date(rs.getTimestamp(
					"DATE_E").getTime()), Importance
					.getImportanceByImportanceNumber(rs.getInt("IMPORTANCE")),
					rs.getString("SOURCE"), rs.getString("MESSAGE")));
		}

		releaseConnection(con);
		return intL;
	}

	public List<Record> getRecordsSortedBySourceDate() throws ServletException,
			SQLException {
		// ID DATE_E IMPORTANCE SOURCE MESSAGE
		List<Record> intL = new ArrayList<Record>();
		Connection con = getConnection();
		PreparedStatement statement = con
				.prepareStatement("SELECT * FROM RECORDS"
						+ " ORDER BY SOURCE, DATE_E DESC");

		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			intL.add(new Record(rs.getInt("ID"), new Date(rs.getTimestamp(
					"DATE_E").getTime()), Importance
					.getImportanceByImportanceNumber(rs.getInt("IMPORTANCE")),
					rs.getString("SOURCE"), rs.getString("MESSAGE")));
		}

		releaseConnection(con);
		return intL;
	}

	public void updateRecord(Record record) throws ServletException,
			SQLException {
		Connection con = getConnection();
		PreparedStatement statement = con
				.prepareStatement("UPDATE RECORDS "
						+ " SET DATE_E = ?,"
						+ " SET IMPORTANCE = ?,"
						+ " SET SOURCE = ?,"
						+ " SET MESSAGE = ? "
						+ " WHERE ID = ?");
		statement.setTimestamp(1, new Timestamp(record.getDate().getTime()));
		statement.setInt(2, record.getImportance().getImportanceNumber());
		statement.setString(3,record.getSource());
		statement.setString(4,record.getMessage());
		statement.setInt(4, record.getId());
		statement.execute();
		con.commit();
		releaseConnection(con);
	}

	public void deleteRecord(Record record) {

	}

	public List<Record> getRecordsSortedByImportanceSourceDate()
			throws ServletException, SQLException {
		// ID DATE_E IMPORTANCE SOURCE MESSAGE
		List<Record> intL = new ArrayList<Record>();
		Connection con = getConnection();
		PreparedStatement statement = con
				.prepareStatement("SELECT * FROM RECORDS"
						+ " ORDER BY IMPORTANCE, SOURCE, DATE_E DESC");

		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			intL.add(new Record(rs.getInt("ID"), new Date(rs.getTimestamp(
					"DATE_E").getTime()), Importance
					.getImportanceByImportanceNumber(rs.getInt("IMPORTANCE")),
					rs.getString("SOURCE"), rs.getString("MESSAGE")));
		}

		releaseConnection(con);
		return intL;
	}

	public int getAllRecordsAmount() throws ServletException, SQLException {
		Connection con = getConnection();
		PreparedStatement statement = con
				.prepareStatement("SELECT COUNT(*) AS r_count FROM records");
		ResultSet result = statement.executeQuery();
		result.next();
		int count = result.getInt("r_count");
		releaseConnection(con);
		return count;
	}
}
