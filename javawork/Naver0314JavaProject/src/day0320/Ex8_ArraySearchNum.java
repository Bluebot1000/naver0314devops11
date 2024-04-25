package day0320;

import java.util.Scanner;

public class Ex8_ArraySearchNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 숫자(num) 을 입력하여 배열에 몇번째에 있는지 출력
		 * 없을경우 없다고 메세지 출력,반복해서 검색(0입력시 종료)
		 */
		
		Scanner sc=new Scanner(System.in);
		int at=0,count=0;
		int []data= {1,2,34,5,66,78,23,43,54,12};
		
		while(true) {
		System.out.println("숫자를 입력해주세요(종료 0)");
		int num=sc.nextInt();
		
		if(num==0)
			break;
		
		for(int i=0 ; i<data.length ; i++) {
			if(data[i]==num)
				count=1;
				at=i;
		}
		
		if(count==1)
			System.out.println((at+1)+"번째에 숫자가 있습니다.");
		else
			System.out.println("숫자가 없습니다.");
		
		}
	}

}
