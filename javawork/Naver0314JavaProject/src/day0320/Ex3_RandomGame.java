package day0320;

import java.util.Scanner;

public class Ex3_RandomGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		/*
		 *  1. 1~100 사이의 난수를 발생한후 숫자 알아맞추기
		 *  2. 숫자입력시 앞에 횟수 출력
		 *  3. 숫자 n 이  난수보다 크면 (n보다 작습니다)
		 *  4. 드디어 숫자를 맞췄을경우 (횟수와 정답을 출력후)
		 *  5. 계속 숫자맞추기 게임을 하시겠습니까?(y/n)
		 *  6. y를 누르면 다시 난수발생후 숫자맞추기 시작
		 *  7. y가 아니면 게임 종료
		 */
		
		Scanner sc=new Scanner(System.in);
		
		Loop:
		while(true) {
		int su=(int)(Math.random()*100)+1;	
		int count=0;
	
		while(true) {
			
			System.out.println("숫자를 제시해주세요");
			int a=Integer.parseInt(sc.nextLine());
			if(a>su) {
				System.out.println("이 숫자보다 작습니다");
				count++;
				continue;}
			else if(a<su) {
				System.out.println("이 숫자보다 큽니다");
				count++;
				continue;}
			else
				count++;
				System.out.println("정답 : "+su+"  횟수 :"+count);
				System.out.println();
				System.out.println("계속 숫자 게임을 하시겠습니까?(y/n)");
				String ab=sc.nextLine();
				if(ab.equalsIgnoreCase("n")) 
					return;
				else if(ab.equalsIgnoreCase("y"))
					continue Loop;
		}
		}

	}

}
