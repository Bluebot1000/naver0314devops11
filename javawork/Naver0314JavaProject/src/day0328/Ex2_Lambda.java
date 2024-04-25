package day0328;
/*
 * 자바에서의 함수형 프로그램인 람다(Lambda) 표현식은 인터페이스를 사용하는
 * 익명 내부 클래스의 또다른 표현식이다
 * 단, 인터페이스는 단 하나의 추상 메소드만 갖고 있어야 람다를 쓸 수 있다.
 * 람다는 ^ 그리스어 알파벳 11번째 글자라고 한다
 */
@FunctionalInterface //메서드가 하나인지 아닌지 검증하는 역할(람다를 쓸 때 오류 확인차 쓰는 게 좋다)
interface Orange{
	public void write();//추상메서드(한개만 가능)
}

@FunctionalInterface
interface DataAdd{
	public void add(int x, int y);
}

public class Ex2_Lambda {
	
	//우리가 알고 있는 익명내부클래스 형태로 Orange를 구현
	Orange or=new Orange() {

		@Override
		public void write() {
			// TODO Auto-generated method stub
			System.out.println("오렌지 먹고 싶어요!!");
		}
		
	};
	
	public void lambdaMethod() {
		Orange or2=()->System.out.println("람다식 오렌지 먹고 싶다");
		or2.write();
	} //한개니까 람다식으로 표현하는 것. 롸이트라는 추상메소드 오버라이드 과정을 생략
		
	public void lambdaMethod2() {
		DataAdd da=(int x, int y)->System.out.println("두수의합:"+(x+y));
		
		da.add(10, 10);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Ex2_Lambda ex=new Ex2_Lambda();//람다 메소드가 담긴 클래스 선언
		ex.lambdaMethod();
		ex.lambdaMethod2();
		

	}

}
