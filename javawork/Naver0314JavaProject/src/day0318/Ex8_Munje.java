package day0318;

import java.util.Scanner;

public class Ex8_Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 상품명(sang)과 수량(su),단가(dan) 입력받은후
		 * 총금액(total) 을 구하고 만약 수량이 5개 이상이면
		 * "10프로 할인입니다" 와 함께 할인된금액(dctotal) 을 출력하시오
		 * 
		 * 상품명?
		 * 딸기
		 * 수량?
		 * 6
		 * 단가?
		 * 2000
		 * 
		 * 딸기 6개의 총금액 : 12000
		 * 10프로 할인입니다
		 * 10프로 할인된 금액 : 10800
		 */
		
		//변수입력
		int su,dan,total,dctotal;
		String sang;
		
		//입력
		Scanner sc=new Scanner(System.in);
		System.out.println("상품명은?");
		sang=sc.nextLine();
		System.out.println("수량은?");
		su=sc.nextInt();
		System.out.println("단가는?");
		dan=sc.nextInt();
		
		total=dan*su;
		dctotal=(dan*su)*9/10;
		
		
		System.out.printf(sang+" "+su+"개의 총금액 : "+total+"\n");
		//5개이상일때와 아닐때(switch 삼항조건문 if)
		if(su>=5)
		{
		System.out.println("10프로 할인입니다");
		System.out.println("10프로 할인된 금액 : "+dctotal);
		}
		
		
		

	}

}
