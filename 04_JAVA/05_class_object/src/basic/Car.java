package basic;
/*
 * 클래스
 * 객체가 가지고있는 속성 기능을 저으이한것
 * 이를 통해 새로운 자료형을 만들수 있기 때문에
 * 사용자 정의 자료형 이라고도 한다
 * 자바에서 객체(object)
 * 클래스에 정의된 내용을 토대로
 * new 연산에 우ㅏ해 jvm heap 메모리 영역에 생성된것
 */
public class Car {
	 // 필드(Fields) - 객체의 상태/속성
	 String brand;
	 String model;
	 int year;

	 // 메서드(Methods) - 객체의 행동
	 public void start() {
	 System.out.println("시동을 겁니다.");
	 }

	 public void stop() {
	 System.out.println("시동을 끕니다.");
	 }
}
