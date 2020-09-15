package Default;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
	
	public static String url = "jdbc:mysql://localhost:3306/bms_new_version?characterEncoding=UTF-8&serverTimezone=UTC";
	public static String user = "root";
	public static String password = "1234";
	public static String bookName;

	public static void main(String[] args) {

//		Connection conn = null;
//		Statement state =  null;
//		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			System.out.println("드라이버 검색 성공!");
//			conn = DriverManager.getConnection(url,user,password);
//			System.out.println("접속 성공 " + conn);
//			state = conn.createStatement();
//						
//		} catch (ClassNotFoundException e) {
//			System.out.println("드라이버 검색 실패!");
//			e.printStackTrace();
//		}
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					Default_BMS_main frame = new Default_BMS_main();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}			
				
			}
			
		});	
		
	}	
	
}
