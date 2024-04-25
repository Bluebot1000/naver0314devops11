package day0319;

import java.util.Scanner;

public class Ex12_StringMunje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 문제
		 * String 타입의 문자열(msg) 를 입력받아
		 * 그 문자열안에 대문자,소문자,숫자가 몇개가 포함되어있는지 출력하시오
		 * 예)
		 * Happy Day 123!!
		 * 대문자 : 2개
		 * 소문자 : 6개  
		 * 숫 자 : 3개
		 * 
		 *  String 의 charAt 과 length 를 사용하면 됨
		 */
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("문자열을 작성해주세요");
		String msg=sc.nextLine();
		int sum=0,low=0,num=0;
		
		for(int j=0 ; j<msg.length() ; j++) {
			
			for(char i='A' ; i<='Z' ; i++) {
				if(msg.charAt(j)==i)
					sum++;
			}
		}
		
		for(int j=0 ; j<msg.length() ; j++) {
			
			for(char i='a' ; i<='z' ; i++) {
				if(msg.charAt(j)==i)
					low++;
			}
		}
		
		for(int j=0 ; j<msg.length() ; j++) {
			
			for(char i='1' ; i<='9' ; i++) {
				if(msg.charAt(j)==i)
					num++;
			}
		}
		
		System.out.printf("대문자 : %d\n", sum);
		System.out.printf("소문자 : %d\n", low);
		System.out.printf(" 숫자 : %d", num);
		

	}

}
