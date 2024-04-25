package day0319;

public class Ex1_Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				/*
				 * 1.  1-100 사이의 소수를 
			    모두 출력하고 몇개인지 갯수를 구하라
			   소수? 1을 제외하고 자기자신만을 약수로
			         가지고 있는수
			    (다중 for문)
				 */
				int count1=0;
		
				for(int i=1 ; i<=100 ; i++) {
					
					
					int count=0;
					
					for(int j=1 ; j<=i ; j++) {
						
						
						if(i%j==0) 
							count++;
					}
					
					if(count==2) {
						System.out.printf("%3d",i);
						count1++;}
				
				}
				
				System.out.println("\n총 갯수 : "+count1);

	}

}
