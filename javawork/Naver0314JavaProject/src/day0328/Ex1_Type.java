package day0328;

//<T>는 타입 파라미터라는 뜻, 타입이 필요한 자리에 사용한다
//T는 클래스 타입만 가능하다

class GenericType<T> {
	T []v;
	
	public void set(T[] n) {
		v=n;
	}
	
	public void print()
	{
		for(T s:v)
			System.out.println(s+"  ");
		System.out.println();
	}
}

public class Ex1_Type {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GenericType<String> a=new GenericType<>();
		
		String []s= {"후리지아","장미","민들레","씨앗"};
		
		a.set(s);
		a.print();
		
		GenericType<Integer> b=new GenericType<>();
		
		Integer []i= {1,2,3,4,5};//선언시 앞에 대문자, 전부 써야 함. int 같은 선언이 아님 객체로 취급함
		
		b.set(i);
		b.print();
		
		GenericType<Double> c=new GenericType<>();
		
		Double []d= {1.2,2.5,3.6,4.1,5.2};
		
		c.set(d);
		c.print();
		
	
	}

}
