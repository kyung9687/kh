package ex;

public class VariableEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* [상수] 
		 * -한번 값을 대입하면 바꿀 수 없는 변수
		 * 작성법
		 * final 자료형 변수명 =값;
		 * 단 변수명은 대문자+_
		 * 
		 */
		
		final double PI =3.141592;
		final int NATIONAL_CODE =82;
		
//		NATIONAL_CODE =1; 오류발생(대입불가)
		
		final int TEMP;
		TEMP = 100;
		
//		TEMP = 200; 처음 초기화 이후 값 대입 불가
		
		System.out.println("[상수확인]");
		int r =5;
		System.out.println("원의 둘레 : " +(2*PI* r));
		System.out.println("원의 넓이 : " +(PI*r*r));
		
		System.out.println("국가 코드 : "+ NATIONAL_CODE);
		System.out.println("temp: "+ TEMP);
		
		
		int num = Integer.MAX_VALUE;
		System.out.println("num: " +num);
		num = num+1;
		System.out.println("num: " +num);
		num = num -1;
		System.out.println("num: " +num);
		
//		문제 원인
//		-num의 자료형 int 라서 최대 최솟값을 초과하는 문제 발생 
	}

}
