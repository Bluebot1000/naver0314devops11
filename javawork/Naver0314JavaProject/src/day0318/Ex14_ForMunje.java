package day0318;

import java.util.Scanner;

public class Ex14_ForMunje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 *   5개의 점수(score)를 입력하면 갯수(count)와 합계(sum) 출력하기
		 *   (단, 1~100 아 아닐경우는 갯수에서 제외하고 합계에서도 제외하기-continue 사용)
		 *   
		 *   (예)
		 *   점수는? 80
		 *   점수는? 120
		 *   점수는? 70
		 *   점수는? 60
		 *   점수는? 100
	 
		 *   입력한 점수 갯수 : 4
		 *   총 합계 : 310		 *   
		 */
		int score, count=0, sum=0;
		Scanner sc=new Scanner(System.in);
		//다섯개 입력-포문-if로 판단해서 continue로 i++로 넘어가기
		
		for(int i=1; i<6;i++)
		{
			System.out.println("점수는?");
			score=sc.nextInt();
			if(score>100 || score<1)
				continue; // i++로 돌아가세요 지금까지 했던건 다 넣어요
			sum+=score;
			count++;
				
		}
		
		//출력
		System.out.println("입력한 점수 갯수 : "+count);
		System.out.println("총 합계 : "+sum);
		
	}

}
