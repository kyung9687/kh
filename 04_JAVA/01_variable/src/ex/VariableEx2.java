package ex;

public class VariableEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*
		 * ---자동형변환(묵시적 형변환)---
		 * 값의 범위가 다른 값들 끼리
		 * 연산시
		 * 컴파일러 가 자동으로
		 * 값의 범위가 작은 값을
		 * 큰범위의 자료형으로 변환하는것
		 * 
		 */
		
		int a1 =12;
		double b1 =1.3;
		/*
		 * 변수선언 자료형int 처럼 명시한 자료형은 자동형변환의 대상 x
		 * 
		 */
//		int result1 = a1+b1;
		double result1 =a1+b1;
		System.out.println(result1);
		
		System.out.println("-----------------");
		System.out.println("자동형변환 예시");
		
		char ch2 = 'A';
		int num2 = 100;
		int result2 =ch2 + num2;
		
		System.out.println("result2:"+result2);
		
		System.out.println("-----------------");
		System.out.println("자동형변환 예시3");
		
		int a3 =3;
		int b3 = 2;
		int result3 =a3/b3;
		
		System.out.println("result3: " +result3);
		/*
		 * 값처리 원칙에 의해서
		 * int/int의 결과는 무조건 int
		 */
		System.out.println("-----------------");
		System.out.println("자동형변환 예시4");
		
		int a4 =100;
		double b4 =23.4;
		int result4 = (int)(a4+b4);
		
		System.out.println("result4: " +result4);
		
		
	}

}
