package day0318;

import java.util.Scanner;

public class Ex11_for {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("1~100까지 합계구하기");
		int sum=0;
		
		for(int i=1;i<=100;i++)
		{
			sum+=i;
		}
		System.out.println("합계:"+sum);
		
		sum=0;//원상태로 돌리기 인스턴스변수이기 때문에 변할 수 있음. static은 안변함
		Scanner sc=new Scanner(System.in);
		int x,y;
		System.out.println("합계를 구할 시작값?");
		x=sc.nextInt();
		System.out.println("합계를 구할 끝값?");
		y=sc.nextInt();
		
		for(int i=x;i<=y;i++)
		{
			sum+=i;
		}
		
		System.out.printf("%d~%d 까지의 합 : %d\n",x,y,sum);
	}

	

}
