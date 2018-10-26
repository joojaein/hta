package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class JDBCMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			
			//드라이버 커넥트
			Connection con = //Connection 임포트 : java.sql
					DriverManager.getConnection(
							"jdbc:oracle:thin:@localhost:1521:xe", //url -> 다른사람꺼 들어갈때 localhost 대신 아이피 입력
							"hr", //id
							"hr"); //pw
			
			Statement stmt = //Statement 임포트 : java.sql
					con.createStatement();
			
			//select 사용시
			ResultSet rs = stmt.executeQuery("select * from test2");
			
			while(rs.next()){
				String id = rs.getString("id");
				Date reg_date = rs.getDate("reg_date"); // Date 임포트 : java.util
				int grade = rs.getInt("grade");
				System.out.println(id+","+reg_date+","+grade+">>>>>");
			}
			
			
			rs.close();
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
