package day0405;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex10_OraclePerson {
	
	
	static final String ORACLE_DRIVER="oracle.jdbc.OracleDriver";
	//static final String ORACLE_URL="jdbc:oracle:thin:@localhost:1522/xe";//내컴퓨터
	static final String ORACLE_URL="jdbc:oracle:thin:@192.168.0.59:1521/xe";//강사님 컴퓨터
	static final String USERNAME="angel";
	static final String PASSWORD="a1234";
	
	public Ex10_OraclePerson() {
		// TODO Auto-generated constructor stub
		
		try {
			Class.forName(ORACLE_DRIVER);
			//System.out.println("드라이버 성공!");
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
	
	public void insert(String name, String blood, int age) {
		String sql="insert into person values (seq_test.nextval,?,?,?,sysdate)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=DriverManager.getConnection(ORACLE_URL, USERNAME, PASSWORD);
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, blood);
			pstmt.setInt(3, age);
			pstmt.execute();
			System.out.println("데이터 추가되었습니다/바인더 하고 실행하세요!");

			
			
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
	
	public void writePerson() {
		String sql2="select pnum,pname,page||'세' page,upper(pblood)||'형' pblood, to_char(ipsaday, 'yyyy-mm-dd HH:mi') ipsaday from person order by pnum asc";
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			conn=DriverManager.getConnection(ORACLE_URL,USERNAME,PASSWORD);
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql2);
			
			showTitle();
			
			while(rs.next()) {
				
				String pnum=rs.getString("pnum");
				String pname=rs.getString("pname");
				String pblood=rs.getString("pblood");
				String page=rs.getString("page");
				String ipsaday=rs.getString("ipsaday");
				
				System.out.println(pnum+"\t"+pname+"\t"+pblood+"\t"+page+"\t"+ipsaday);
				
			}
			
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
		
		Ex10_OraclePerson op=new Ex10_OraclePerson();
		Scanner sc=new Scanner(System.in);
		int menu=0;
		String name,blood;
		int age;
		
		while(true) {
			System.out.println("1. 데이터 추가 2. 전체출력 3. 종료");
			menu=Integer.parseInt(sc.nextLine());
			switch(menu) {
			case 1:
				System.out.println("이름입력");
				name=sc.nextLine();
				System.out.println("혈액형?");
				blood=sc.nextLine();
				System.out.println("나이?");
				age=Integer.parseInt(sc.nextLine());
				
				op.insert(name, blood, age);
				break;
			case 2:
				op.writePerson();
				break;
			default:
				System.out.println("프로그램 종료");
				System.exit(0);
			}
			
			System.out.println();
		}
		

	}

}
