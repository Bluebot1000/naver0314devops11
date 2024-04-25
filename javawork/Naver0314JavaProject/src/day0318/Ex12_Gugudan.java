package day0318;

import java.util.Scanner;

public class Ex12_Gugudan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
				/*
				 * 구구단? 11  
				 *   잘못된 숫자입니다  : if문
				 *   
				 * 구구단?5
				 *    
				 *    ** 5단 **
				 *    
				 *    5 x 1 = 5   : 단일for문
				 *    5 x 2 = 10
				 *    .
				 *    .
				 *    .
				 *    5 x 9 =45		 
				 * 
				 */
		int num;
		
		//숫자입력하여 if문 출력
		Scanner sc=new Scanner(System.in);
		System.out.println("구구단 단수를 입력하세요(1단에서 9단까지)");
		num=sc.nextInt();
		
		if(num<2 || num>9)
			System.out.println("잘못된 숫자입니다");
		
		
		else
		//for문으로 단수 만들기
		{
			System.out.println("          ** "+num+"단 **");
			for(int i=1; i<10; i++)
			{
				
				System.out.println("\t"+num+" x  "+i+"  = "+(num*i));
			}
		}
		
	}

}
