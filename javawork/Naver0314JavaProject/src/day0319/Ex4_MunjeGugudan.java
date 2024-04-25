package day0319;

public class Ex4_MunjeGugudan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.printf("%30s\n\n","[구구단]");
		
		for(int i=2 ; i<10 ; i++) {
				System.out.println("<<"+i+"단 구구단>>");
			for(int j=1 ; j<10 ; j++) {
				
				System.out.printf("%d x %d = %d\n", i, j ,i*j);
				
			}
			System.out.println();
			
		}

	}

}
