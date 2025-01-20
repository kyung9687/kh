package ex;

public class VariableEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1.값의 범위가 큰 자료형 -> 작은 자료형으로 변환 
		 * 		(데이터손실을 고려해야 한다!!!)
		 * 2.의도적으로 자료형을 변환 할 떄
		 * 
		 */
		
		System.out.println("강제형변환 예시1 -데이터손실");
		int num1 =290;
		byte result1 =(byte)num1;
		
		System.out.println(num1);
		System.out.println(result1);
		
		
		System.out.println("-----------------------");
		System.out.println("강제형변환 예시2 -데이터손실");
		
		double num2 =123.99;
		int result2 =(int)num2;
		
		System.out.println(num2);
		System.out.println(result2);
		
		
		System.out.println("-----------------------");
		System.out.println("강제형변환 예시3 -데이터손실");
		
		for(int i=0; i<5;i++){
			int randomNumber = (int)(Math.random()*100+1);
			System.out.println("randomNumber:"+randomNumber);
		}
		
		System.out.println("-----------------------------");
		System.out.println("의도적으로 자료형을 변환");
		
		int a3 =5;
		int b3 =2;
		System.out.println(a3/b3);
		System.out.println((double)a3/(double)b3);
		System.out.println((double)a3/b3);
		
		System.out.println("-----------------------------");
		System.out.println("의도적으로 자료형을 변환2");
		
		System.out.println("문자(char)<->유니코드(int)");
		
		System.out.println("A의 유니코드 번호 : "+ (int)'A');
		System.out.println("A의 뒤에 10번째 문자 : "+(char)('A' +10));
		
	}

}
