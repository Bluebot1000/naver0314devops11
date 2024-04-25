package day0328;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class Ex3_LambdaForEach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List에 데이타를 넣는 방법 1
		List<String> list1=new Vector<String>();
		list1.add("빨강색");
		list1.add("노랑색");
		list1.add("분홍색");
		list1.add("초록색");
		
		for(String s:list1)
			System.out.println(s);
		System.out.println("=========");
		
		//list에 데이타 넣는 방법 2
		List<String> list2=Arrays.asList("장미","타놀라","프리지아","튤립","수국");
		
		list2.forEach(a->System.out.println(a));
		

	}

}
