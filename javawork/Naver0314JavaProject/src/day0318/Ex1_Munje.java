package day0318;

import java.util.Scanner;

public class Ex1_Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 *  점수(score)를 입력후 점수가
		 *  90 이상이면 "A"
		 *  80 이상이면 "B
		 *  70 이상이면 "C"
		 *  60 이상이면 "D"
		 *  나머지는 "F" 를 출력
		 *  (조건연산자를 이용해서 구하기)
		 *  
		 *  (예)
		 *  점수?
		 *  89
		 *  
		 *  89점은 B학점입니다
		 * 
		 */
		
		Scanner sc=new Scanner(System.in);
		int score;
		String msg;
		
		Loop:
		while(true)
		{
		//점수입력
		
		System.out.println("점수를 입력하시오");
		score=sc.nextInt();
		
		if(score<0 || score>100)
		   {System.out.println("잘못 입력하셨습니다");
		   continue Loop;
		   
		}
		
		//판단
		
		msg = score>=90 && score <=100 ? "A" : score>=80 ?
									    "B" : score>=70 ?
									    "C" : score>=60 ?
									    "D" : "F";	   
		
		//출력
		System.out.printf("%d점은 %s학점입니다",score,msg);
			break Loop;	//loop브레이크						   
		   
		}
	}

}
