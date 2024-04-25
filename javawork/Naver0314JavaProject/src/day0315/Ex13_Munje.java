package day0315;

import java.util.Scanner;

public class Ex13_Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*조건연산자 문제
		 * 점수(score)를 입력받아 
		 * 점수가 90 이상이면 "참 잘했어요!!"
		 *      80 이상이면 "수고했어요!"
		 *      70 이상이면 "조금 더 노력하세요!"
		 *      그 나머지는 "재시험입니다!"
		 *        메세지를 저장할 문자열 변수명 : msg 
		 */
		//변수넣기
		int score;
		String msg;
		
		//점수입력
		Scanner sc=new Scanner(System.in);
		System.out.println("점수를 입력하시오");
		score=sc.nextInt();
		
		//점수판단(switch, if, 삼항조건문-일반 숫자는 삼항으로 가도 되겠지)
		msg = score <= 100 && score >= 90 ? 
		"참 잘했어요!!" : score>=80 ?
		"수고했어요!" : score>=70 ? 
		"조금 더 노력하세요!" : "재시험입니다!";
		
		System.out.println(msg);
		
	}

}
