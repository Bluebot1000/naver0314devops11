package day0315;

import java.util.Scanner;

public class Ex8_Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 이름(name),핸드폰(hp),태어난 년도(birthYear) 입력받은후
		 * 이름,핸드폰,태어난년도,나이(age, 2024-태어난년도)를 출력하는 프로그램을 작성하시오		
		 * 선언-입력-계산-출력 
		 */
		
		Scanner sc=new Scanner(System.in);
		String name, hp, birthyear;
		
		//입력
		System.out.println("당신의 이름은?");
		name=sc.nextLine();
		
		System.out.println("당신의 연락처는?");
		hp=sc.nextLine();
		
		System.out.println("당신의 탄생연도는?");
		birthyear=sc.nextLine();
		
		//나이계산
		int age=2024-Integer.parseInt(birthyear);
		
		
		//출력
		System.out.println("이름 :"+name);
		System.out.println("핸드폰:"+hp);
		System.out.println("태어난 년도:"+birthyear);
		System.out.println("나이:"+age);
		

	}

}
