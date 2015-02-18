package idvorskij.labs.journal.dao;

import idvorskij.labs.journal.entities.ErrorType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAO {

	public static final DAO INSTANCE = new DAO();

	private DAO() {
		try {
			initContext = new InitialContext();
			ds = (DataSource) initContext
					.lookup("jdbc/db");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	};

	public Connection getConnection() {
		return conn;
	}

	private InitialContext initContext;
	private DataSource ds;
	private Connection conn;
	
	public int[] getTypes() throws SQLException{
		PreparedStatement prepSt = getConnection().prepareStatement("SELECT id from Journal;");
		ResultSet resSet= prepSt.executeQuery();
		int[] et = new int[4];
		int i = 0;
		while(resSet.next() && i < 4){
			et[i] = (int)  resSet.getInt("id");
		}
		
		return et;
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(DAO.INSTANCE.getTypes());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
