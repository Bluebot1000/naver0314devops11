package day0320;

import java.util.Scanner;

public class Ex10_ArraySearchStartWith {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String []members= {"강호동","한가인","유재석","이승민","강하나",
				"손미나","이영자","박남정","한지혜","손창민"};
		/*
		 *  검색할 이름은? 강
		 *      1번째 : 강호동
		 *      5번째 : 강하나
		 *      총 2명 검색
		 *      
		 *  검색할 이름은? 박이
		 *      "박이" 로 시작하는 멤버는 없습니다
		 *      
		 *   검색할 이름은? Q
		 *      ** 검색을 종료합니다 **
		 */
		Scanner sc=new Scanner(System.in);
		
		
		while(true) {
		System.out.println("검색할 이름은? (종료:q)");
		String name=sc.nextLine();
		if(name.equalsIgnoreCase("q"))
			break;
		
		int sum=0;
		for(int i=0 ; i<members.length ; i++) {
			if(members[i].startsWith(name)) {
				sum++;
				System.out.println((i+1)+"번째 : "+members[i]);
			}
		}
		if(sum>0)
		System.out.println("총 "+sum+"명 검색");
		else
		System.out.println("'"+name+"'"+"으로 시작하는 멤버는 없습니다.");
		
		}
		
	}

}
