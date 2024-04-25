package day0404;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex2_OraclePerson {
	
	static final String ORACLE_DRIVER="oracle.jdbc.OracleDriver";
	//static final String ORACLE_URL="jdbc:oracle:thin:@localhost:1522/xe";
	static final String ORACLE_URL="jdbc:oracle:thin:@192.168.0.59:1521/xe";
	static final String USERNAME="angel";
	static final String PASSWORD="a1234";
	
	public Ex2_OraclePerson() {
		// TODO Auto-generated constructor stub
		
		try {
			Class.forName(ORACLE_DRIVER);
			System.out.println("드라이버 성공!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 실패!"+e.getMessage());
		}
				
	}
	
	static public void showTitle() {
		System.out.println("=".repeat(37));
		System.out.println("시퀀스\t이름\t혈액형\t나이\t입사일");
		System.out.println("=".repeat(37));
	}
	
	public void writePerson() {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		String sql="select pnum,pname,upper(pblood) pblood,page,to_char(ipsaday,'yyyy-mm-dd') ipsaday from person";
		
		try {
			
			conn=DriverManager.getConnection(ORACLE_URL, USERNAME, PASSWORD);
			System.out.println("서버 연결 성공!");
			
			showTitle();
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				String pnum=rs.getString("pnum");
				String pname=rs.getString("pname");
				String pblood=rs.getString("pblood");
				int page=rs.getInt("page");
				String ipsaday=rs.getString("ipsaday");
				
				System.out.println(pnum+"\t"+pname+"\t"+pblood+"\t"+page+"\t"+ipsaday);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("서버 연결 실패!"+e.getMessage());
		} finally {
			
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException|NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Ex2_OraclePerson ex2=new Ex2_OraclePerson();
		ex2.writePerson();
		

	}

}
