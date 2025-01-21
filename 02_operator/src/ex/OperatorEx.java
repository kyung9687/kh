package ex;

import java.util.Scanner;

/**
 * 예제 기능(메서드)를 제골하는 클래스
 */
public class OperatorEx {

	public void test1() {
		System.out.println("test1() 호출됨");
	}

	public void test2() {
		System.out.println("test2() 호출됨~~");
	}
	/**
	 * 입력 받은 두 정수의 산술 연산 결과 출력하기
	 * [실행 화면]
	 * 정수 입력1:10
	 * 정수입력 2:3
	 * 
	 * 10+3 =13
	 * 10-3 =7
	 */
	public void method1() {
		Scanner sc =new Scanner(System.in);
		
		System.out.print("정수 입력 1: ");
		long num1 =sc.nextLong();
		
		System.out.print("정수 입력 2: ");
		long num2 =sc.nextLong();
		
		System.out.println();
		
//		System.out.println(num1-num2);
//		System.out.println(num1%num2);
		
		System.out.printf("합은%d 차는%d 곱은%d 몫은%d 나머지%d",num1+num2,num1-num2,num1*num2,num1/num2,num1%num2);
		
		
	}
	
	public void method2() {
		Scanner sc =new Scanner(System.in);
		
		System.out.print("정수 입력:");
		int input =sc.nextInt();
		
		String result =(input % 3 ==0) ? "맞습니다": "아닙니다";
		
		System.out.printf("%d은 3의 배수가 %s",input,result);
		
	}
	
	public void method3() {
		Scanner sc =new Scanner(System.in);
		
		System.out.print("나이 입력:");
		int age =sc.nextInt();
		
		String result = (age<=13) ? "어린이":(age<=19? "청소년":"성인");
		System.out.println(result);
	}
}
