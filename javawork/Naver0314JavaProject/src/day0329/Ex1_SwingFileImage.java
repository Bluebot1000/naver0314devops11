package day0329;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex1_SwingFileImage extends JFrame{
	
	static String photo="C:\\Users\\bluebot\\Desktop\\naver0314devops11\\workall\\image\\음식사진\\8.jpg";
	
	JButton btn = new JButton();
 	Myphoto myPhoto=new Myphoto();
	
	public Ex1_SwingFileImage(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setLocation(100,100);
		this.setSize(300,300);//창크기
		//this.getContentPane().setBackground(new Color(93, 199, 187));
		this.getContentPane().setBackground(Color.blue);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료
		this.initDesign();//각종 컴포넌트 생성
		this.setVisible(true);
	}
	
	public void initDesign() {
		//패널에 버튼을 생성후 패널을 북쪽에 추가
		
		JPanel p=new JPanel();
		btn=new JButton("이미지 불러오기");
		p.add(btn);
		this.add("North",p);
		this.add("Center",myPhoto);
		
		
		//버튼 이벤트
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FileDialog dlg=new FileDialog(Ex1_SwingFileImage.this, "이미지 불러오기,", FileDialog.LOAD);
				dlg.setVisible(true);
				if(dlg.getFile()==null)
					return;
				
				photo=dlg.getDirectory()+dlg.getFile();
				myPhoto.repaint();
			}
		});
	}
	
	class Myphoto extends Canvas {
			@Override
			public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			
			Image image=new ImageIcon(photo).getImage();
			g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
			}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1_SwingFileImage a=new Ex1_SwingFileImage("사진 불러오기");
	}

}
