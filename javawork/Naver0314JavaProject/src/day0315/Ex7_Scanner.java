package day0315;

import java.util.Scanner;

public class Ex7_Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		int kor,eng;
		String name;
		
		System.out.println(Integer.parseInt("1203"));//String(문자열)을 Int(정수형, 숫자)로
		
		System.out.println("국어점수는?");
		kor=Integer.parseInt(sc.nextLine());
		System.out.println("영어점수는?");
		eng=Integer.parseInt(sc.nextLine());
		//넥스트 인트보다 넥스트스트링으로 스캔해서 정수처리하는 게 편하다(버퍼 엔터 방지)
		
		System.out.println("이름은?");
		name=sc.nextLine();
		
		System.out.println("이름:"+name);
		System.out.printf("국어점수:%d점,영어점수:%d점\n",kor,eng);
		System.out.printf("총점 : %d점,평균:%3.1f점",kor+eng,(kor+eng)/2.0);//결과가 double 이어야할경우 수식중 한개라도 double 타입이 있어야한다
	
		
	}

}
