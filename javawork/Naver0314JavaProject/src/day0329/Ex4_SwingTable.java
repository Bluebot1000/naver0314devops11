package day0329;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex4_SwingTable extends JFrame{
	JTable table;
	JLabel lblMessage;
	
	public Ex4_SwingTable(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setLocation(100,100);
		this.setSize(500,300);//창크기
		//this.getContentPane().setBackground(new Color(93, 199, 187));
		this.getContentPane().setBackground(Color.blue);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료
		this.initDesign();//각종 컴포넌트 생성
		this.setVisible(true);
	}
	
	public void initDesign() {
		String []title= {"이름","나이","혈액형","핸드폰","주소"};
		String [][]date= {
				{"이영자","43세","B","010-3333-4444","서울"},
				{"최현욱","24세","O","010-4444-3333","하남"},
				{"유재석","23세","AB","010-3434-2323","화성"},
				{"주우재","39세","O","010-4433-9876","안양"}
		};
		
		table=new JTable(date, title);
		//상단에 제목 추가
		this.add("North",new JLabel("701 멤버 현황",JLabel.CENTER));
		//프레임의 센터에 추가
		this.add("Center",new JScrollPane(table)); // 테이블도 스크롤바가 생겨야 한다(제목포함)
		//메세지 라벨을 south에 추가
		lblMessage=new JLabel("결과 나올 곳...", JLabel.CENTER);
		lblMessage.setFont(new Font("", Font.BOLD, 20));
		this.add("South",lblMessage);
		
		//테이블 이벤트
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				
				//선택한 행번호
				int rowIndex=table.getSelectedRow();
				
				//클릭한 곳에서 이름,나이,주소정도만 얻어서 메세지에 출력해보자
				String name=table.getValueAt(rowIndex, 0).toString();
				String age=table.getValueAt(rowIndex, 1).toString();
				String addr=table.getValueAt(rowIndex, 4).toString();
				
				String m=name+"님은 "+age+"이며 "+addr+"에 살고 있어요";
				lblMessage.setText(m);
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex4_SwingTable a=new Ex4_SwingTable("테이블 이용하기");
	}

}
