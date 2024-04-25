package day0326;

interface Apple
{
	public void one();
}

//인터페이스끼리의 상속은 extends,일반클래스끼리는 implements
interface Banana extends Apple
{
	public void two();
}

class Orange implements Banana
{
	@Override
	public void one() {
		// TODO Auto-generated method stub
		System.out.println("하나");
	}
	
	@Override
	public void two() {
		// TODO Auto-generated method stub
		System.out.println("둘");
	}
	
	public void three()
	{
		System.out.println("셋");
	}
	
}

class Mango {
	public void Four() {
		System.out.println("넷");
	}
	}

public class Ex5_Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Banana b=new Orange();
		b.one();
		b.two();
		((Orange)b).three();
		((Mango)b).Four();//관련이 없어도 형변환은 가능하지만 출력안됨
		
	}

}