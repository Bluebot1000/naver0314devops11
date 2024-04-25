package day0407;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex2_Roadschola {
	
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	static final String USERNAME="root";
	static final String PASSWORD="1234";
	private static final int Loop = 0;
	
	
	
	public Ex2_Roadschola() {
		// TODO Auto-generated constructor stub
		
		try {
			Class.forName(MYSQL_DRIVER);
			//System.out.println("드라이버 성공!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 오류"+e.getMessage());
		}
	}
	
	public void insert(String name, int kisu, String gender) {
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="insert into roadschola values (null,?,?,?)"; // safe모드 꺼야한다.
		
		try {
			conn=DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(2, kisu);
			pstmt.setString(1, name);
			pstmt.setString(3, gender);
			pstmt.execute();
			
			System.out.println(name+"님의 정보가 추가되었습니다.");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		
	}
	
	public void delete(String name) {
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="delete from roadschola where name=?"; // safe모드 꺼야한다.
		
		try {
			conn=DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.execute();
			
			System.out.println(name+"님의 정보가 삭제되었습니다.");
			
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
	
	public void select() {
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from roadschola";
		
		
		try {
			conn=DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			System.out.println("넘버"+"\t"+"이름"+"\t"+"기수"+"\t성별");
			while(rs.next()) {
				int num=rs.getInt("num");
				String name=rs.getString("name");
				int kisu=rs.getInt("kisu");
				String gender=rs.getString("gender");
				
				System.out.println(num+"\t"+name+"\t"+kisu+"\t"+gender);
			}
			System.out.println();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
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
		
		Scanner sc=new Scanner(System.in);
		Ex2_Roadschola ex2=new Ex2_Roadschola();
		
		while(true) {
		System.out.println("1. 학생 정보 추가  2. 학생 삭제  3. 학생 명단 보기 4. 종료");
		System.out.println("=".repeat(30));
		int menu=Integer.parseInt(sc.nextLine());
		
	
		switch(menu) {
			case 1:
				System.out.println("이름을 작성해주세요");
				String name=sc.nextLine();
				System.out.println("기수를 작성해주세요");
				int kisu=Integer.parseInt(sc.nextLine());
				System.out.println("성별을 작성해주세요");
				String gender=sc.nextLine();
				
				ex2.insert(name, kisu, gender);
				break;
				
			case 2:
				
				System.out.println("삭제할 이름을 작성해주세요");
				String delname=sc.nextLine();
				
				ex2.delete(delname);				
				break;
			case 3:
				
				ex2.select();
				break;
				
			case 4:
				
				System.out.println("종료합니다");
				return;
				
			default:
				System.out.println("숫자를 잘못 입력하셨습니다.");
				break;
		}
		}

	}

}
