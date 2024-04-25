package day0405;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import day0404.Ex1_MysqlSawon;

public class Ex7_SawonDelete {
	
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	static final String USERNAME="root";
	static final String PASSWORD="1234";
	
	public Ex7_SawonDelete() {
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
		
		String sql="delete from sawon where name='"+delname+"'";
		System.out.println(sql);
		
		Connection conn=null;
		Statement stmt=null;
		
		try {
			conn=DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
			stmt=conn.createStatement();
			int n=stmt.executeUpdate(sql);//executeUpdate는 실행한 레코드 개수 반환
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
		Ex7_SawonDelete sd=new Ex7_SawonDelete();
		sd.delete();

	}

}
