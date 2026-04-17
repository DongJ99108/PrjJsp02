package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBHandler {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String dbuid  = "sky";
	private String dbpwd  = "1234";
	
	// 회원추가
	public  int addUser(String userid, String username, String email) throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		  Connection conn = DriverManager.getConnection(url, dbuid, dbpwd);
		  String            sql   = "";
		  sql += " INSERT INTO TUSER VALUES ( ?, ?, ? )";
		  PreparedStatement pstmt = conn.prepareStatement(sql);
		  pstmt.setString(1, userid);
		  pstmt.setString(2, username);
		  pstmt.setString(3, email);
		  
		  int aftcnt = pstmt.executeUpdate();
		  
		  pstmt.close();
		  conn.close();
		  
		  
		  return  aftcnt;
	}

}
