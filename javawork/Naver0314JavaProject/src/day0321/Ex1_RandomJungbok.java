package day0321;

import java.util.Random;

public class Ex1_RandomJungbok {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 1~30 까지의 난수 10개를 발생하는데 중복처리하기
		 */
		
		int []a=new int[10];
		int m=0;
		
		Loop:
		for(int i=0 ; i<10 ; i++) {
			
			m=(int)(Math.random()*30+1);
			
			for(int j=0 ; j<i ; j++) {
				
				if(m==a[j]) {
					i=i-1;
					continue Loop; //i전에서 다시 for문을 돌려라
					//break Loop; //break는 자기를 까고 가는 것
				}
			}
			
			a[i]=m;
			System.out.println(a[i]);
			
		}
		System.out.println("=".repeat(50));
		//순차정렬
		int b=0;
		
		for(int i=0 ; i<a.length ; i++) {
			for(int j=9 ; j>i ; j--) {
				if(a[i]>a[j]) {
					b=a[i];
					a[i]=a[j];
					a[j]=b; // 자리바꾸기
				}
					
			}
			
		}
		
		for(int s: a) {
			System.out.println(s);
		}

	}

}
