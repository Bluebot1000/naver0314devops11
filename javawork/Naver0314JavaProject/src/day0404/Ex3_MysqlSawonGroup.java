package day0404;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex3_MysqlSawonGroup {
	
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	static final String USERNAME="root";
	static final String PASSWORD="1234";
	
	
	public void showtitle() {
		
		System.out.println("=".repeat(37));
		System.out.println("부서\t인원수\t최고점수\t평균");
		System.out.println("=".repeat(37));
		
	}
	
	
	public void writeSawon() {
		//2. 커넥션을 해야해 드라이브를 만들었으면
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;//select문일 경우게만 필요한 클래스
		String sql="select buseo, count(*) inwon, max(score) maxscore, ceiling(avg(score)) avgscore from sawon group by buseo";
		
		
		try {
			
			conn=DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
			System.out.println("2. 커넥션 성공!(url,username,password필요)");
			showtitle();
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				
				String buseo=rs.getString("buseo");
				int inwon=rs.getInt("inwon");
				int maxscore=rs.getInt("maxscore");
				int avg=rs.getInt("avgscore");
				
				System.out.println(buseo+"\t"+inwon+"\t"+maxscore+"\t"+avg);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("커넥션 실패!"+e.getMessage());
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		
		
	}
	
	public Ex3_MysqlSawonGroup() {
		// TODO Auto-generated constructor stub
		
		try {
			Class.forName(MYSQL_DRIVER);
			System.out.println("1. 드라이버 접속 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("1. 드라이버 접속 실패"+e.getMessage());
		}
		
	}
	
	public static void main(String[] args) {
		
		Ex3_MysqlSawonGroup a=new Ex3_MysqlSawonGroup();
		
		a.writeSawon();
	
		
	}

}
