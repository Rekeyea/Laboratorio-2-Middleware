package middleware.componentes;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class MDataSource implements DataSource{

	private static String MYSQL_CONNECTION = "jdbc:mysql://";
	private static int TIMEOUT = 15;
	
	private String db = MYSQL_CONNECTION + "localhost:3306/middleware";
	private String login = "root";
	private String pw = "root";
	private Connection connection = null;
	
	
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}


	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}


	public <T> T unwrap(Class<T> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		return getConnection(login, pw);
	}

	public Connection getConnection(String username, String password)
			throws SQLException {
		// TODO Auto-generated method stub
		try{
			Class.forName("com.mysql.jdbc.Driver");
	        connection = DriverManager.getConnection(db ,username,password);
	        return connection;
		}catch(ClassNotFoundException ex){
			throw new SQLException(ex.getMessage());
		}
	}

}
