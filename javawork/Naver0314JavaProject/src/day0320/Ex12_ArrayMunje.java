package day0320;

import java.util.Scanner;

public class Ex12_ArrayMunje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 처음에 인원수(inwon) 를 입력받은후 해당 인원수만큼
		 * name,kor,eng,tot,rank 변수를 배열할당하고
		 * 인원수만큼 이름,국어점수,영어점수를 입력하면
		 * 총점과 등수를 계산해서 출력하는 프로그램을 작성하시오
		 * 
		 * 출력은
		 * ------------------------------------
		 * 번호   이름   국어   영어   총점   등수
		 * ------------------------------------
		 *   1  강호동   90    100  190    1
		 *   2  이영자  100     70  170    3
		 *   3  유재석   90     90  180    2   
		 * 
		 */
		
		Scanner sc=new Scanner(System.in);
		System.out.println("인원수를 입력해주세요");
		int n=sc.nextInt();//인트 다음에는 개행문자처리를 해줘야 한다.
		sc.nextLine();
		
		String [][]array=new String[n][5];
		String kor="",eng="";
		
		for(int i=0 ; i<array.length ; i++) {
			System.out.println((i+1)+"번째 학생 이름을 입력해주세요");
			String name=sc.nextLine();
			array[i][0]=name;
			
			
			System.out.println((i+1)+"번째 학생 국어점수를 입력해주세요");
			kor=sc.nextLine();
			array[i][1]=kor;
			
			
			System.out.println((i+1)+"번째 학생 영어점수를 입력해주세요");
			eng=sc.nextLine();
			array[i][2]=eng;
			array[i][3]=Integer.toString(Integer.parseInt(kor)+Integer.parseInt(eng));
		}
		
		
		for(int i=0 ; i<array.length ; i++) {
			int gr=1;
			for(int j=0 ; j<array.length ; j++) {
				if(Integer.parseInt(array[i][3])<Integer.parseInt(array[j][3])) {
					gr++;
				}
				array[i][4]=Integer.toString(gr);
			}

		}
		
		//출력
		System.out.println("=".repeat(20));
		System.out.println("번호\t이름\t국어\t영어\t총점\t등수");
		System.out.println("=".repeat(20));
		for(int i=0 ; i<array.length ;i++) {
			System.out.println((i+1)+"\t"+array[i][0]+"\t"+array[i][1]+"\t"+array[i][2]+"\t"
					+array[i][3]+"\t"+array[i][4]);
		}
		System.out.println();

	}

}
