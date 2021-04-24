package Default;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {
	
	public static Connection getConnection() {
		
		Connection conn = null;
		Statement stmt;
		
		try { //Database 연결 코드
			String url = "jdbc:mysql://localhost:3306/bms_new_version?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "root", "mysql");
			
		} catch (Exception e) { //연결 실패시 오류메세지 출력
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		}
		return conn;
	}//Connection END

}
