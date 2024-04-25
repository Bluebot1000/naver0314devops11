package day0401;

public class Ex4_CastingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car car = null; // 클래스 선언/ 완전하지않은
		FireEngine fe = new FireEngine(); // 클래스선언
		FireEngine fe2 = null;//클래스 선언 / 완전하지 않은

		fe.water();
		car = fe;    // car =(Car)fe;에서 형변환이 생략된 형태다.
//		car.water();	
		fe2 = (FireEngine)car; // 자손타입 ← 조상타입
		fe2.water();
	}
}

class Car {
	String color;
	int door;

	void drive() { 		// 운전하는 기능
		System.out.println("drive, Brrrr~");
	}

	void stop() {		// 멈추는 기능	
		System.out.println("stop!!!");	
	}
}

class FireEngine extends Car {	// 소방차
	void water() {		// 물을 뿌리는 기능
		System.out.println("water!!!");
	}
}