package basic;

public class BasicRun {

	public static void main(String[] args) {
		
	// 객체 생성
		Car myCar = new Car();
		// 참조변수명.필드명 , 참조변수명.메서드명으로 필드/메서드에 접근
		// 객체 필드에 값 대입
		myCar.brand = "현대";
		myCar.model = "소나타";
		myCar.year = 2025;
		// 객체 필드에 저장된 값 얻어오기
		System.out.println("myCar brand : " + myCar.brand);
		System.out.println("myCar model : " + myCar.model );
		System.out.println("myCar year : " + myCar.year);
		// 객체의 메서드 호출
		myCar.start();
		myCar.stop();

	}

}
