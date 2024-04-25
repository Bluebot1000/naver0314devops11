package day0405;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex11_Student {
	
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	static final String USERNAME="root";
	static final String PASSWORD="1234";
	
	
	
	public Ex11_Student() {
		// TODO Auto-generated constructor stub
		
		try {
			Class.forName(MYSQL_DRIVER);
			System.out.println("드라이버 성공!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 오류"+e.getMessage());
		}
	}
		
	public void insertStu(String name, int java, int spring, int html) {
		
		String sql="insert into student (name,java,spring,html,testday) values (?,?,?,?,now())";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=DriverManager.getConnection(MYSQL_URL,USERNAME,PASSWORD);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, java);
			pstmt.setInt(3, spring);
			pstmt.setInt(4, html);
			pstmt.execute();
			
			System.out.println(name+"님의 성적을 등록하였습니다.");
			
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
	
	public void deleteStu(String name) {
		
		String sql="delete from student where name=?";
		//해당학생 없으면 없다. 있으면 있다 나오기
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=DriverManager.getConnection(MYSQL_URL,USERNAME,PASSWORD);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			int n=pstmt.executeUpdate();
			
			if(n==0) {
				System.out.println("학생이 없습니다.");
			} else {
				System.out.println(n+"명의 학생이 삭제되었습니다.");
			}
			
			
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
	
	public void writeStu() {
		
		String sql="select num,name,java,spring,html,java+html+spring total,(java+html+spring)/3 avg,date_format(testday,'%Y-%m-%D %H:%i') testday from student;";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=DriverManager.getConnection(MYSQL_URL,USERNAME,PASSWORD);
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			System.out.println("넘버"+"\t"+"이름"+"\t"+"자바"+"\t"+"스프링"+"\t"+"HTML"+"\t"+"총점"+"\t"+"평균"+"\t"+"시험일");
			
			while(rs.next()) {
				
				int num=rs.getInt("num");
				String n=rs.getString("name");
				int j=rs.getInt("java");
				int s=rs.getInt("spring");
				int h=rs.getInt("html");
				int t=rs.getInt("total");
				int avg=rs.getInt("avg");
				String td=rs.getString("testday");
						
				System.out.println(num+"\t"+n+"\t"+j+"\t"+s+"\t"+h+"\t"+t+"\t"+avg+"\t"+td);
				
				
			}
			
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
		Ex11_Student ex11=new Ex11_Student();

		System.out.println("1. 학생 정보 추가  2. 학생 삭제  3. 학생 명단 보기 4. 종료");
		System.out.println("=".repeat(30));
		int menu=Integer.parseInt(sc.nextLine());
		
		
		if(menu==1) {
			System.out.println("학생 이름은?");
			String name=sc.nextLine();
			System.out.println("자바점수는?");
			int java=Integer.parseInt(sc.nextLine());
			System.out.println("스프링점수는?");
			int spring=Integer.parseInt(sc.nextLine());
			System.out.println("html점수는?");
			int html=Integer.parseInt(sc.nextLine());
			
			ex11.insertStu(name, java, spring, html);
			
		}
		else if(menu==2) {
			System.out.println("삭제할 학생 이름은?");
			String delname=sc.nextLine();
			
			ex11.deleteStu(delname);
			
		}
		else if(menu==3) {
			
			ex11.writeStu();
			
		}
		else {
			System.out.println("**프로그램 종료했습니다**");
			return;
		}
		
		System.out.println();
		

		

	}

}
