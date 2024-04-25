package day0328;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex8_Munje extends JFrame{
	
	//넣을 사진 주소 넣기
	final static String PHOTO="C:\\Users\\bluebot\\Desktop\\naver0314devops11\\workall\\image\\음식사진\\8.jpg";
	
	MyCanvas draw = new MyCanvas();	
	
	//제이프레임 윈도우창 만들기
	public Ex8_Munje(String title) {
		super(title);
		this.setLocation(100,100);//시작위치
		this.setSize(500,500);//프레임 크기
		this.getContentPane().setBackground(Color.white);//배경색
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료
		this.initDesign();//각종 채울 거리를 여기에 넣는다
		this.setVisible(true);
	}
	
	public void initDesign() {
		//기본레이아웃없애기
		//this.setLayout(null);
			
		//버튼 하나 만들기
		JButton bu1=new JButton("예제문제다");
		bu1.setBounds(190,20,100,50);
		this.add(bu1);
		
		//사진 띄우기
		this.add(draw);
		
	}
	
	//캔버스 내부 클래스
	class MyCanvas extends Canvas{
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
				
			//채워진 박스 그리기
			g.setColor(Color.black);
			g.drawRoundRect(90, 90, 300, 300, 10, 10);
				
			//사진넣기
			Image image=null;
			image=new ImageIcon(PHOTO).getImage();
			g.drawImage(image, 130, 110, 220, 260, this);
				
		}		
	}
		
	public static void main(String[] args) {
		Ex8_Munje a = new Ex8_Munje("title");
	}

}
