package day0404;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex1_MysqlSawon {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	static final String USERNAME="root";
	static final String PASSWORD="1234";
	
	public Ex1_MysqlSawon() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(MYSQL_DRIVER);
			System.out.println("드라이버 성공!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 오류"+e.getMessage());
		}
	}
	
	static public void showTitle() {
		System.out.println("=".repeat(37));
		System.out.println("시퀀스\t이름\t성별\t부서\t점수");
		System.out.println("=".repeat(37));
	}
	
	public void writeSawon() {
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;//select문일 경우게만 필요한 클래스
		String sql="select * from sawon order by num";
		
		try {
			//url유저비번이 맞으면 connection을 얻는다
			conn=DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
			System.out.println("mysql 서버에 연결 성공");
			
			showTitle();
			
			stmt=conn.createStatement();//sql 실행 위한 statement 얻기
			rs=stmt.executeQuery(sql);//select문일 경우 무조건 excuteQuery로 실행
			//rs.next()는 다음 레코드로 이동을 하면서 true 반환, 그런데 이동할 데이터 없으면 false 반환
			while(rs.next()) {
//				//데이터를 가져올 때는 컬럼번호 또는 컬럼명으로 가져오면 된다
//				int num=rs.getInt(1);
//				String name=rs.getString(2);
//				int score=rs.getInt(3);
//				String gender=rs.getString(4);
//				String buseo=rs.getString(5);
				
				//데이터를 가져올 때는 컬럼번호 또는 컬럼명으로 가져오면 된다
				int num=rs.getInt("num");
				String name=rs.getString("name");
				int score=rs.getInt("score");
				String gender=rs.getString("gender");
				String buseo=rs.getString("buseo");
				
				System.out.println(num+"\t"+name+"\t"+gender+"\t"+buseo+"\t"+score);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("url,id,비번 확인할 것"+e.getMessage());
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
		Ex1_MysqlSawon ex1=new Ex1_MysqlSawon(); // 생성자 소환. 드라이브 가져옴/라이브러리에 mysql추가 되어 있는지 확인
		
		ex1.writeSawon();
	}

}
