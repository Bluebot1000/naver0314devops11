package day0328;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ex5_SwingCanvas extends JFrame{
	//캔바스 변수 선언
	MyDraw draw=new MyDraw();
	//음식 사진 경로
	String foodImage="C:\\Users\\bluebot\\Desktop\\naver0314devops11\\workall\\image\\음식사진\\11.jpg";
	String foodImage2="C:\\Users\\bluebot\\Desktop\\naver0314devops11\\workall\\image\\음식사진\\1.jpg";
	
	public Ex5_SwingCanvas(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setLocation(100,100);
		this.setSize(500,500);//창크기
		//this.getContentPane().setBackground(new Color(93, 199, 187));
		//this.getContentPane().setBackground(Color.blue);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료
		this.initDesign();//각종 컴포넌트 생성
		this.setVisible(true);
	}
	
	//캔바스를 상속받는 내부 클래스
	class MyDraw extends Canvas{
		//처음 시작시, 그리고 프레임 크기 변경시에는 자동 호출, 그 외에는 강제호출!(repaint)
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			
			//색상 변경
			g.setColor(Color.magenta);
			g.drawOval(100, 100, 50, 50);
			g.fillOval(150, 30, 100, 50);
			g.setColor(Color.orange);
			g.fillOval(200, 120, 30, 10);
			
			//테두리만 있는 사각형
			g.drawRect(200, 150, 20,20);
			
			//글꼴 출력
			g.setFont(new Font("Comic Sans MS", Font.BOLD,30));
			g.drawString("Good Day", 240, 240);
			
			//이미지 그리기 1번 방법
			Image img1=new ImageIcon(foodImage).getImage();
			g.drawImage(img1, 300, 200, 100, 100, this);
			
			//이미지 그리기 2번 방법
			Image img2=Toolkit.getDefaultToolkit().getImage(foodImage2);
			g.drawImage(img2, 300, 350, 100, 100, this);
		}
	}
	
	public void initDesign() {
		//기본 레이아웃의 center에 캔바스 추가
		this.add("Center",draw);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex5_SwingCanvas a=new Ex5_SwingCanvas("캔바스");
	}

}
