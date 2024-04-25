package day0405;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex5_SawonInsert2 {
	
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	static final String USERNAME="root";
	static final String PASSWORD="1234";
	
	public Ex5_SawonInsert2() {
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
	
	public void InsertSawon() {
		Scanner sc=new Scanner(System.in);
		String name,gender,buseo;
		int score,gnum,bnum;
		String sql="";
		
		System.out.println("이름은?");
		name=sc.nextLine();
		System.out.println("점수는?");
		score=Integer.parseInt(sc.nextLine());
		System.out.println("성별은 선택 1. 남자 2. 여자 ");
		gnum=Integer.parseInt(sc.nextLine());
		gender=gnum==1?"남자":"여자";
		
		System.out.println("부서는 1.보건복지부 2.연구부 3.홍보부");
		bnum=Integer.parseInt(sc.nextLine());
		buseo=bnum==1?"보건복지부":bnum==2?"연구부":"홍보부";
		
		sql="insert into sawon (name,score,gender,buseo) values (?,?,?,?)";
		//System.out.println(sql);
		
		Connection conn=null;
		PreparedStatement pstmt=null; //rs은 select만 필요
		
		try {
			conn=DriverManager.getConnection(MYSQL_URL,USERNAME,PASSWORD);
			pstmt=conn.prepareStatement(sql);
			//4개 값을 바인딩
			pstmt.setNString(1, name);
			pstmt.setInt(2, score);
			pstmt.setString(3, gender);
			pstmt.setString(4, buseo);
			
			//바인딩 끝나고 익스큐트
			pstmt.execute();//그냥 익스큐트로 하면 됨
			System.out.println("데이터 추가 성공!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("오류"+e.getMessage());
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
		
		Ex5_SawonInsert2 si=new Ex5_SawonInsert2();
		si.InsertSawon();

	}

}
