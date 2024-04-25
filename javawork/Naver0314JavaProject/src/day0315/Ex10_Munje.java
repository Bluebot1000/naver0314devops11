package day0315;

import java.util.Scanner;

public class Ex10_Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 백만단위의 금액(money) 를 입력받은후
		 * 만원,천원,백원,십원,일원 단위로 몇개인지 출력하시오
		 * 예)
		 * 금액입력
		 * 4567893
		 * 만원 : 456장
		 * 천원 : 7장
		 * 백원 : 8개
		 * 십원 : 9개
		 * 일원 : 3개
		 */
		
		//입력
		Scanner sc=new Scanner(System.in);
		int money; 
		
		System.out.println("금액을 입력하시오");
		money=sc.nextInt();
		
		//출력
		System.out.printf("만원 : %d장\n",(int)money/10000);
		System.out.printf("천원 : %d장\n",(int)(money%10000)/1000);
		System.out.printf("백원 : %d장\n",(int)(money%1000)/100);
		System.out.printf("십원 : %d장\n",(int)(money%100)/10);
		System.out.printf("천원 : %d장",(int)money%10);
		
		
		
		
	}

}
