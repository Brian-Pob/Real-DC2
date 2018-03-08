package designchallenge2;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class AgendaDB {
	private static String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://127.0.0.1:3306/?user=root/";
	private static String USERNAME = "root";
	private static String PASSWORD = "1234";
	private static String DATABASE = "RealDC2_DB";
	//jdbc:mysql://127.0.0.1:3306/?user=root
	public Connection getConnection() {
		try {
			Class.forName(DRIVER_NAME);
			Connection connection = DriverManager.getConnection(
					URL +
					DATABASE + "?autoReconnect=true&useSSL=false",
					USERNAME,
					PASSWORD);
			System.out.println("MySQL Connection Successful");
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("[MYSQL] Connection failed! SQLException");
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[MYSQL] Connection failed! ClassNotFoundException");
			return null;
		}	
	}
	
	public static void main(String[] args) {
		AgendaDB db = new AgendaDB();
		db.getConnection();
	}
}
