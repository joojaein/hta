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
			//����̹� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			
			//����̹� Ŀ��Ʈ
			Connection con = //Connection ����Ʈ : java.sql
					DriverManager.getConnection(
							"jdbc:oracle:thin:@localhost:1521:xe", //url -> �ٸ������ ���� localhost ��� ������ �Է�
							"hr", //id
							"hr"); //pw
			
			Statement stmt = //Statement ����Ʈ : java.sql
					con.createStatement();
			
			//select ����
			ResultSet rs = stmt.executeQuery("select * from test2");
			
			while(rs.next()){
				String id = rs.getString("id");
				Date reg_date = rs.getDate("reg_date"); // Date ����Ʈ : java.util
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
