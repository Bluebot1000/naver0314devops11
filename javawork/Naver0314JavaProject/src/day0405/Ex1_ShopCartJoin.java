package day0405;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex1_ShopCartJoin {
	
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	static final String USERNAME="root";
	static final String PASSWORD="1234";
	
	public Ex1_ShopCartJoin() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(MYSQL_DRIVER);
			System.out.println("1. 드라이버 접속 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("2. 드라이버 접속 실패"+e.getMessage());
		}
	}
	
	public void writeCartJoin() {
		Connection conn=null;
		PreparedStatement stmt=null; // sql을 미리 검사한다는 게 달라요
		ResultSet rs=null;
		
		String sql="select cartnum,username,sangpum,price,color,date_format(guipday, '%Y-%m-%d %H-%i') guipday from shop,cart where shop.shopnum=cart.shopnum";
		
		try {
			conn=DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
			stmt=conn.prepareStatement(sql);//sql 위치가 달라져
			rs=stmt.executeQuery();
			
			System.out.println("=".repeat(50));
			System.out.println("시퀀스\t이름\t상품명\t가격\t색상\t구입일");
			System.out.println("=".repeat(50));
			
			while(rs.next()) {
				int cn=rs.getInt("cartnum");
				String s=rs.getString("sangpum");
				String u=rs.getString("username");
				int p=rs.getInt("price");
				String c=rs.getString("color");
				String g=rs.getString("guipday");
					
				System.out.println(cn+"\t"+s+"\t"+u+"\t"+p+"\t"+c+"\t"+g+"\t");
				
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
		Ex1_ShopCartJoin a=new Ex1_ShopCartJoin();
		a.writeCartJoin();

	}

}
