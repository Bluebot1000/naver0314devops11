package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import data.dto.ShopDto;
import db.common.MySqlConnect;

public class ShopDao {
	MySqlConnect connect=new MySqlConnect();
	
	public void insertShop(ShopDto dto) {
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="""
				insert into myshop (sname,sprice,scount,scolor,sphoto,writeday)
				values (?,?,?,?,?,now())
					""";
		conn=connect.getConnection();//db 연결
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSname());
			pstmt.setInt(2, dto.getSprice());
			pstmt.setInt(3, dto.getScount());
			pstmt.setString(4, dto.getScolor());
			pstmt.setString(5, dto.getSphoto());
			
			//실행
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("insert 오류 :"+e.getMessage());
		} finally {
			connect.dbClose(pstmt, conn);
		}
		
	}
	
	public List<ShopDto> getShopDatas(){
		List<ShopDto> list=new Vector<ShopDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from myshop order by shopidx desc";
		
		conn=connect.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ShopDto dto=new ShopDto();
				
				dto.setShopidx(rs.getString("shopidx"));
				dto.setSname(rs.getString("sname"));
				dto.setSprice(rs.getInt("sprice"));
				dto.setScount(rs.getInt("scount"));
				dto.setScolor(rs.getString("scolor"));
				dto.setSphoto(rs.getString("sphoto"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				//list 추가
				list.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("select 오류"+e.getMessage());
		} finally {
			connect.dbClose(rs, pstmt, conn);
		}
		
		return list;
	}
}
