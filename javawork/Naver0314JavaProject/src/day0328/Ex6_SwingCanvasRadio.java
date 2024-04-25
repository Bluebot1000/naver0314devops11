package day0328;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Ex6_SwingCanvasRadio extends JFrame{
	
	final static String PHO1="C:\\Users\\bluebot\\Desktop\\naver0314devops11\\workall\\image\\연예인사진\\13.jpg";
	final static String PHO2="C:\\Users\\bluebot\\Desktop\\naver0314devops11\\workall\\image\\연예인사진\\2.jpg";
	final static String PHO3="C:\\Users\\bluebot\\Desktop\\naver0314devops11\\workall\\image\\연예인사진\\11.jpg";
	final static String PHO4="C:\\Users\\bluebot\\Desktop\\naver0314devops11\\workall\\image\\연예인사진\\9.jpg";
	
	Color boxColor=new Color(125,11,200);//초기 박스 색상
	JRadioButton rbBox1,rbBox2,rbBox3,rbBox4;
	JRadioButton []rbPhoto=new JRadioButton[4];
	int photoIndex=1;
	
	MyDraw draw=new MyDraw();
	
	public Ex6_SwingCanvasRadio(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setLocation(100,100);
		this.setSize(400,500);//창크기
		//this.getContentPane().setBackground(new Color(93, 199, 187));
		this.getContentPane().setBackground(Color.blue);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료
		this.initDesign();//각종 컴포넌트 생성
		this.setVisible(true);
	}
	
	//
	class MyDraw extends Canvas{
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			
			//채워진 박스 그리기
			g.setColor(boxColor);
			g.fillRect(30,40,320,320);
			

			Image image=null;
			switch(photoIndex)
			{
			case 1:
				image=new ImageIcon(PHO1).getImage();
				break;
			case 2:
				image=new ImageIcon(PHO2).getImage();
				break;
			case 3:
				image=new ImageIcon(PHO3).getImage();
				break;
			case 4:
				image=new ImageIcon(PHO4).getImage();
				break;
			}
			
			g.drawImage(image, 80, 70, 220, 260, this);
			
		}
	}
	
	public void initDesign() {
		
		this.add("Center",draw);
		//상단에 색상 라디오 버튼 추가
		JPanel pTop=new JPanel();
		ButtonGroup bg1=new ButtonGroup();//버튼 그룹 안에 버튼을 넣어줘야함
		rbBox1=new JRadioButton("초록색");
		bg1.add(rbBox1);
		pTop.add(rbBox1);
		
		rbBox2=new JRadioButton("하늘색",true);
		bg1.add(rbBox2);
		pTop.add(rbBox2);
		
		rbBox3=new JRadioButton("분홍색");
		bg1.add(rbBox3);
		pTop.add(rbBox3);
		
		rbBox4=new JRadioButton("오렌지색");
		bg1.add(rbBox4);
		pTop.add(rbBox4);
		
		//rbBox1에 대한 이벤트
		rbBox1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boxColor=Color.green;
				draw.repaint();
			}
		});
		
		rbBox2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boxColor=Color.blue;
				draw.repaint();
			}
		});
		
		rbBox3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boxColor=Color.pink;
				draw.repaint();
			}
		});
		
		rbBox4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boxColor=Color.orange;
				draw.repaint();
			}
		});
		
		
		//프레임 상단에 panel 추가
		this.add("North",pTop);
		
		//프레임 하단에는 사진선택하는 라디오 버튼 추가
		JPanel pBottom=new JPanel();
		ButtonGroup bg2=new ButtonGroup();
		
		String []s= {"1","2","3","4"};
		for(int i=0 ; i< rbPhoto.length ; i++) {
			
			final int n=i+1;
			
			rbPhoto[i]=new JRadioButton(s[i], i==(photoIndex-1)?true:false);
			bg2.add(rbPhoto[i]);
			pBottom.add(rbPhoto[i]);
			
			rbPhoto[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					photoIndex=n;
					draw.repaint();//캔바스 내부 클래스의 paint 메소드 강제 호출
				}
			});
			
		}
		
		
		this.add("South",pBottom);
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex6_SwingCanvasRadio a=new Ex6_SwingCanvasRadio("캔바스2");
	}

}
