package day0405;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import day0404.Ex1_MysqlSawon;

public class Ex6_SawonDelete2 {
	
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	static final String USERNAME="root";
	static final String PASSWORD="1234";
	
	public Ex6_SawonDelete2() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(MYSQL_DRIVER);
			System.out.println("드라이버 성공!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 오류"+e.getMessage());
		}
	}
	
	public void delete() {
		
		Scanner sc=new Scanner(System.in);
		String delname="";
		System.out.println("삭제할 이름은?");
		delname=sc.nextLine();
		
		String sql="delete from sawon where name=?";
		//System.out.println(sql);
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
			pstmt=conn.prepareStatement(sql);

			pstmt.setString(1, delname);//바인딩해주기 ?에 들어갈 거
			int n=pstmt.executeUpdate();//바인딩 끝나고 execute한다.
			if(n==0)
				System.out.println(delname+" 이(가) 없습니다.");
			else
				System.out.println(n+"명의 "+delname+"을 삭제했습니다.");
			
			//매번 work가서 확인하기 싫으면
			Ex1_MysqlSawon aa=new Ex1_MysqlSawon();
			aa.writeSawon();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException|NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex6_SawonDelete2 sd=new Ex6_SawonDelete2();
		sd.delete();

	}

}
