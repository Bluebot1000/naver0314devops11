package day0328;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ex4_SwingButton extends JFrame{
	//변수선언
	JButton btn1,btn2;
	JButton []btnArray=new JButton[6];//각 배열의 값 null로 되어 있음 
	String []btnLabel= {"빨강","노랑","살구","딥블루","사파이어","랜덤색"};
	
	
	public Ex4_SwingButton(String title) {
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
	
	//1 각종 컴포넌트 생성(버튼추가)
	public void initDesign() {
		this.setLayout(null);//기본 레이아웃 없애기
		//버튼 1 생성
		btn1=new JButton("Hello!");
		//프레임추가
		btn1.setBounds(10, 10, 100, 30);//x,y,w,h
		this.add(btn1);
		//btn1 이벤트 추가-익명 내부 클래스 형태로 이벤트 구현
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(Ex4_SwingButton.this, "버튼 1을 눌렀어요");
			}
		});
		
		//버튼 2 생성후 프레임에 추가해보세요
		btn2=new JButton("안녕");
		//프레임추가
		btn2.setBounds(150, 100, 100, 30);
		this.add(btn2);
		btn2.addActionListener(new Button2Event());
		
		//내부클래스 방법
//		btn2.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				JOptionPane.showMessageDialog(Ex4_SwingButton.this, "버튼 2를 눌렀어요");
//			}
//		});
		
		//BtnArray 배열 변수를 생성후 프레임에 추가(여러 번튼 한번에 만들기)
		int yPos=50;
		for(int i=0 ; i<btnArray.length ; i++) {
			btnArray[i]=new JButton(btnLabel[i]);
			btnArray[i].setBounds(10, yPos, 100, 30);
			this.add(btnArray[i]);
			yPos+=35;
			
			//익명 내부 클래스로 이벤트 구현
			btnArray[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//Object ob=e.getSource();//이벤트가 발생한 오브젝트 (e가 발생해요!!)
					JButton ob=(JButton)e.getSource();
					System.out.println(ob.getText());
					//System.out.println(ob.getLabel());//getText를 써라고 권장함, 디플리케이트되었을때
					
					switch(ob.getText()) {
					case "빨강":
						//부모 컴포넌트의 인스턴스변수인 this를 통해서 배경색 변경
						Ex4_SwingButton.this.getContentPane().setBackground(Color.red);
						break;
						
					case "노랑":
						//부모 컴포넌트의 인스턴스변수인 this를 통해서 배경색 변경
						Ex4_SwingButton.this.getContentPane().setBackground(Color.yellow);
						break;
						
					case "딥블루":
						//부모 컴포넌트의 인스턴스변수인 this를 통해서 배경색 변경
						Ex4_SwingButton.this.getContentPane().setBackground(Color.blue);
						break;
						
					case "사파이어":
						//부모 컴포넌트의 인스턴스변수인 this를 통해서 배경색 변경
						Ex4_SwingButton.this.getContentPane().setBackground(Color.blue);
						break;
						
					case "살구":
						//부모 컴포넌트의 인스턴스변수인 this를 통해서 배경색 변경
						Ex4_SwingButton.this.getContentPane().setBackground(new Color(120,190,10));
						break;
						
					case "랜덤색":
						//부모 컴포넌트의 인스턴스변수인 this를 통해서 배경색 변경
						Random rand = new Random();
						int ran[]=new int[3];
						Loop:
						for(int i=0 ; i<ran.length ; i++)
						{
							ran[i]=rand.nextInt(256);
							for(int j=ran.length-1 ; j>i ; j--)
								{if(ran[i]==ran[j])//이것도 포문 돌려야해/이중포문
									continue Loop;}
						}
						
//						int n1 = rand.nextInt(256);
//						int n2 = rand.nextInt(256);
//						int n3 = rand.nextInt(256);
						
						Ex4_SwingButton.this.getContentPane().setBackground(new Color(ran[0],ran[1],ran[2]));
						break;
					}
				}
			});
			
		}
		
	}
	
	//2 이벤트를 밖으로 빼는 방법할때 쓴 클래스
	class Button2Event implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(Ex4_SwingButton.this, "맛있는 점심 먹고 오세요");
		}
	}
	
	//3
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex4_SwingButton a=new Ex4_SwingButton("스윙버튼");//메인에서 스윙버튼 실행
	}

}
