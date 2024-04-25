package day0405;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//프리페어로 할 때 변수처리가 더 편해요

public class Ex2_SawonSearchName {
	
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	static final String USERNAME="root";
	static final String PASSWORD="1234";
	
	public Ex2_SawonSearchName() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(MYSQL_DRIVER);
			System.out.println("드라이버 성공!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 오류"+e.getMessage());
		}
	}
	
	public void showT() {
		
		System.out.println("=".repeat(40));
		System.out.println("번호\t이름\t점수\t성별\t부서");
		System.out.println("=".repeat(40));
	}
	
	public void writeSawon(String name) {
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		String sql="select * from sawon where name like concat('%','"+name+"','%')";
		//System.out.println(sql);
		
		boolean find=false;
		
		try {
			conn=DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			showT();
			while(rs.next()) {
				
				String n=rs.getString("name");
				int s=rs.getInt("score");
				String b=rs.getString("buseo");
				String g=rs.getString("gender");
				int num=rs.getInt("num");
						
				System.out.println(num+"\t"+n+"\t"+s+"\t"+g+"\t"+b);
				
				find=true;
				
			}
			
			if(!find)
				System.out.println("찾는 사원은 없어요");
			
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		Ex2_SawonSearchName a=new Ex2_SawonSearchName();
		Scanner sc=new Scanner(System.in);
		String name="";
		
		while(true) {
			System.out.println("검색할 이름을 입력해주세요(종료 x)");
			name=sc.nextLine();
			if(name.equalsIgnoreCase("x")) {
				System.out.println("종료");
				break;
			}
			
			a.writeSawon(name);
			System.out.println();

		}
		
	}

}
