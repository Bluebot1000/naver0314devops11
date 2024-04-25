package day0405;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import day0404.Ex1_MysqlSawon;

public class Ex8_SawonUpdate {
	
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	static final String USERNAME="root";
	static final String PASSWORD="1234";
	
	public Ex8_SawonUpdate() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(MYSQL_DRIVER);
			System.out.println("드라이버 성공!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 오류"+e.getMessage());
		}
	}
	
	public void update() {
		
		Ex1_MysqlSawon saw=new Ex1_MysqlSawon();
		saw.writeSawon();
		System.out.println();
		Scanner sc=new Scanner(System.in);
		String updateName,updateBuseo;
		int updateScore;
		
		System.out.println("수정 이름은?");
		updateName=sc.nextLine();
		System.out.println("수정 점수는?");
		updateScore=Integer.parseInt(sc.nextLine());
		System.out.println("수정 부서명은?");
		updateBuseo=sc.nextLine();
		
		String sql="update sawon set score="+updateScore+", buseo='"+updateBuseo+"' where name='"+updateName+"'";
		System.out.println(sql);
		
		Connection conn=null;
		Statement stmt=null;
		
		
		try {
			conn=DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
			stmt=conn.createStatement();
			stmt.execute(sql);
			
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
		Ex8_SawonUpdate su=new Ex8_SawonUpdate();
		su.update();

	}

}
