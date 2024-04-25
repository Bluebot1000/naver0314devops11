package day0408;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import db.common.DbConnect;

public class Ex2_DBSawon extends JFrame{
	
	DbConnect db=new DbConnect();
	JTable table;
	DefaultTableModel tableModel;
	JTextField tfName,tfScore;
	JButton btnAdd,btnDel;
	JComboBox<String> cbgen, cbbu, cbSearch;
	JRadioButton rbtn1, rbtn2, rbtn3;
	int order=1;//성별전체
	int buseoIndex=1;//부서전체
	
	public Ex2_DBSawon(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setLocation(100, 100);//시작위치
		this.setSize(500, 400);//창크기
		this.getContentPane().setBackground(new Color(93, 199, 187));//배경색 변경
		//this.getContentPane().setBackground(Color.yellow);//배경색 변경
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료
		this.initDesign();//각종 컴포넌트 생성
		this.setVisible(true);
	}
	
	public void initDesign()
	{
		//위에 넣기
		JPanel p1=new JPanel();
		p1.add(new JLabel("이름"));
		tfName=new JTextField(5);
		p1.add(tfName);
		

		p1.add(new JLabel("점수"));
		tfScore=new JTextField(5);
		p1.add(tfScore);
		
		String[] cb1= {"남자", "여자"};
		cbgen=new JComboBox<String>(cb1);
		p1.add(new JLabel("성별"));
		p1.add(cbgen);

		
		String[] cb2= {"기획부", "홍보부", "보건복지부", "연구개발부"};
		cbbu=new JComboBox<String>(cb2);
		p1.add(new JLabel("부서"));
		p1.add(cbbu);

		
		this.add("North",p1);
		
		//테이블 넣기
		String []title= {"시퀀스","이름","점수","성별","점수"};
		tableModel=new DefaultTableModel(title, 0);
		table=new JTable(tableModel);
		this.add("Center",new JScrollPane(table));
		write();
		
		//바텀에 뭘 넣을까
		JPanel p2=new JPanel();
		btnAdd=new JButton("추가");
		btnDel=new JButton("삭제");
		p2.add(btnAdd);
		p2.add(btnDel);
		
		String[] buseo1= {"전체","기획부","홍보부","보건복지부","연구개발부"};
		cbSearch=new JComboBox<String>(buseo1);
		p2.add(cbSearch);
		
		ButtonGroup bg1=new ButtonGroup();
		rbtn1=new JRadioButton("전체");
		rbtn2=new JRadioButton("남");
		rbtn3=new JRadioButton("여");
		p2.add(rbtn1);
		p2.add(rbtn2);
		p2.add(rbtn3);
		bg1.add(rbtn1);
		bg1.add(rbtn2);
		bg1.add(rbtn3);
		
		this.add("South",p2);
		
		//부서별 보기 write
		cbSearch.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
				if(cbSearch.getSelectedIndex()==0) {
					buseoIndex=1;
					write();
				}
				if(cbSearch.getSelectedIndex()==1) {
					buseoIndex=2;
					write();
				}
				if(cbSearch.getSelectedIndex()==2) {
					buseoIndex=3;
					write();
				}
				if(cbSearch.getSelectedIndex()==3) {
					buseoIndex=4;
					write();
				}
				if(cbSearch.getSelectedIndex()==4) {
					buseoIndex=5;
					write();
				}
				
				
				
			}
		});
				
		
		//라디오버튼 이벤트
		
		rbtn1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				order=1;
				write();
			}
		});
		rbtn2.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				order=2;
				write();
			}
		});
		rbtn3.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				order=3;
				write();
			}
		});
		
		
		//추가 이벤트
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(tfName.getText().length()==0)
					return;
				if(tfScore.getText().length()==0)
					return;
				
				Connection conn=db.getConnection();
				PreparedStatement pstmt=null;
				
				String sql="insert into sawon values (null,?,?,?,?)";
				
				try {

					pstmt=conn.prepareStatement(sql);
					pstmt.setString(1, tfName.getText());
					pstmt.setInt(2, Integer.parseInt(tfScore.getText()));
					pstmt.setString(3,cbgen.getSelectedItem().toString());
					pstmt.setString(4,cbbu.getSelectedItem().toString());
					
					pstmt.execute();
					
					write();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					db.dbClose(pstmt, conn);
				}
				
				
			}
		});
		
		
		
		
		//삭제 이벤트
		btnDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//테이블의 선택한 행번호 row를 얻는다
				int row=table.getSelectedRow();
				//row가 -1이면 경고메세지후 이벤트 종료
			
				if(row==-1) {
					JOptionPane.showMessageDialog(Ex2_DBSawon.this, "삭제할 행을 선택해주세요");
					return;
				}
				
				//row행의 0번열에 있는 시퀀스값을 얻는다 getValueAT
				String num=table.getValueAt(row, 0).toString();
				
				Connection conn=db.getConnection();
				PreparedStatement pstmt=null;
				String sql="delete from sawon where num=?";
				
				try {
					pstmt=conn.prepareStatement(sql);
					pstmt.setString(1, num);
					pstmt.execute();
					
					write();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					db.dbClose(pstmt, conn);
				}
				
			}
		});
		
	}
	
	public void write() {
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="";
		if(order==1) {
			sql="select * from sawon";
		} if(order==2) {
			sql="select * from sawon where gender='남자'";
		} if(order==3) {
			sql="select * from sawon where gender='여자'";
		} 
		
		
		if(buseoIndex==1) {
			sql="select * from sawon";
		} if(buseoIndex==2) {
			sql="select * from sawon where buseo='기획부'";
		} if(buseoIndex==3) {
			sql="select * from sawon where buseo='홍보부'";
		} if(buseoIndex==4) {
			sql="select * from sawon where buseo='보건복지부'";
		} if(buseoIndex==5) {
			sql="select * from sawon where buseo='연구개발부'";
		}
		
		
		
		try {
			pstmt=conn.prepareStatement(sql);
			//실행
			rs=pstmt.executeQuery();
			
			tableModel.setRowCount(0); // 기존테이블 싹 지우기
			
			while(rs.next()) {
				//벡터로 만들어서 추가해주는 거야
				Vector<String> data=new Vector<>();
				data.add(rs.getString("num"));
				data.add(rs.getString("name"));
				data.add(rs.getString("score"));
				data.add(rs.getString("gender"));
				data.add(rs.getString("buseo"));
				
				tableModel.addRow(data);
			}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn, rs);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2_DBSawon a=new Ex2_DBSawon("사원 리스트");
	}

}