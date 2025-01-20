package ex;

public class VariableEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("[java변수와 자료형]");
		
		/*
		 *  java자료형
		 *  boolean -true/false 저장 가능
		 *  
		 *  -정수형
		 *  byte	(1byte)
		 *  short	(2byte)
		 *  int		(4byte,정수 기본형)
		 *  -> 정수 형태로 작성된 값은 무조건 int 자료형으로 판단
		 *  long	(8byte)
		 *  숫자 뒤에 L또는 l을 붙입 (L,l의 long의 리터럴)
		 *  
		 *  -실수형
		 *  float 	(4byte)
		 *  숫자뒤에 F 또는 f를 붙임
		 *  double	(8byte, 실수 기본형)
		 *  실수형태로 작성된 값은 무조건 double 자료형으로 판단
		 *  
		 *  -문자형
		 *  char	(2byte) :문자하나 를 지정하는 유니코드
		 *  
		 *  1byte == 8bit
		 */
		//변수 선언
		int num1;
		
		/*
		 * java 지역 변수를 초기화를 하지 않은 경우 
		 * 출력 연산을 할 수 없다
		 * 
		 */
		//The local variable num1 may not have been initialized
//		System.out.println(num1);
		/* 변수초기화 */
		num1= 200;
		System.out.println("num1:"+num1);
		
		System.out.println("----------------------------");
		System.out.println("[자료형별 리터럴 작성법]");
		
		boolean bool1 =true;
		boolean bool2 =false;
		
		System.out.println("bool1:"+bool1);
		System.out.println("bool2:"+bool2);
		
		if(bool1 && !bool2) {
			System.out.println("이거 출력 될까?");
		}
		
		System.out.println("정수형");
		
		int intNum1 =2147483647; //int 최대값
		
		
//		int intNum2 =2147483648;
		long longNum1 =2147483648L;
//		자릿수 구분을 위해 _ 사용가능
		long longNum2 =30_000_000_000L;
		
		
		System.out.println("intNum:"+ intNum1);
		System.out.println("longNum1:"+ longNum1);
		System.out.println("longNum2:"+ longNum2);
//		출력 결과에 리터럴 표기법 L,l 포함 x
//		코드 상에서만 리터럴을 이용해 자료형 구분
		
//		byte,short 다른언어와 호환을 위해 남겨지 자료형
//		별도의 리터럴 표기법 x
		byte byteNum =100;
		short shortNum =2000;
		
		System.out.println("-------");		
		System.out.println("--실수형--");		
		
		float floatNum =1.123456789f;
		double doubleNum =1.123456789;
		
		System.out.println(floatNum);
		System.out.println(doubleNum);
		// float는 소수점 아래 8번째 자리에서 반올림
		// double은 소수점 아래 16번째 자리에서 반올림
		//정확도 더높음 실수의 기본형으로 채택
		
		/* 문자형(char):리터럴 표기법('')*/
		char ch1 = 'A';
		
		char ch2 = '가';
		char ch3 = '福';
		char ch4 = '★';
		
		System.out.println("-------------");
		System.out.println("----[문자형]----");
		System.out.println("ch1:"+ch1);
		
	// 	%c :문자형
//		%d :10진수 정수형
//		%x :16진수 정수형
//		(int)ch1 : ch1의 자료형을 int로 전환
		System.out.printf("%c,%d,%x,\n",ch1,(int)ch1,(int)ch1);
		System.out.println("ch2:"+ch2);
		System.out.println("ch3:"+ch3);
		System.out.println("ch4:"+ch4);
		/*
		 * 문자열(string,4byte 또는 8byte)
		 * 값이 아닌 주소를 저장하는 참조자료형
		 * 리터
		 */
		
		String str1 ="A";
		String str2 ="AB";
		String str3 ="ABC";
		String str4 ="ABCD";
		
		System.out.println("str1"+str1);
		System.out.println(System.identityHashCode(str1));
		//hashCode 주소를 해시함수로 변환한것
		// 주소가 다르면 같은 결과가 나올수 없다
		System.out.println("str2"+str2);
		System.out.println(System.identityHashCode(str2));
		
		
		int num123;
		int show_me_the_money;
		
		final int NATIONAL_CODE =82;
		
		int 정수1 =10;
		double 실수2 =3.14;
				
		
	}

}
