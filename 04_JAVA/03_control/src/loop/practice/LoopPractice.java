package loop.practice;

import java.util.Scanner;

public class LoopPractice {

	Scanner sc =new Scanner(System.in);
	
	public void displayMenu() {
		

		System.out.print("실행할 메서드 번호 입력>>");
		int input =sc.nextInt();
		
		switch (input) {
//		case 1: practice1(); break;
//		
//		case 2: practice2(); break;
//		
//		case 3: practice3(); break;
//		case 4: practice4(); break;
//		case 5: practice5(); break;
//		case 6: practice6(); break;
//		case 7: practice7(); break;
//		case 8: practice8(); break;
//		case 9: practice8(); break;
//		case 10: practice8(); break;
		case 11: practice11(); break;
		case 12: practice12(); break;
//		case 13: practice8(); break;
//		case 14: practice8(); break;
//		case 15: practice8(); break;
//		case 16: practice8(); break;
			

		default: System.out.println("의미없는 번호 입력");

		}
	}
	
	
	public void practice11() {
		
		System.out.print("정수입력 : ");
		int num =sc.nextInt();
		
		for (int i = 1; i <=num; i++) {
			for (int k = 1; k <= num-i; k++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 2*i-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void practice12() {
		
		System.out.print("정수입력 : ");
		int num =sc.nextInt();
		for (int top = 0; top < num; top++) {
			System.out.print("*");
		}
		System.out.println();
		for (int i = 1; i <=num-2; i++) {
			System.out.print("*");
			for (int j = 0; j < num-2; j++) {
				System.out.print(" ");
			}
			System.out.print("*");
			System.out.println();
		}
		for (int bot = 0; bot < num; bot++) {
			System.out.print("*");
		}
		System.out.println();
		System.out.println("---------------------------");
		
		for (int row = 1; row <= num; row++) {
			for (int col = 1; col <= num; col++) {
				if(row == 1|| row == num ||col ==num || col ==1) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
}


//package loop.practice;
//
//import java.util.Scanner;
//
//public class LoopPractice {
//	Scanner sc = new Scanner(System.in);
//	
//	public void displayMenu() {
//		System.out.println("[practice]");
//		System.out.println("1. practice1()");
//		System.out.println("2. practice2()");
//		System.out.println("3. practice3()");
//		System.out.println("4. practice4()");
//		System.out.println("5. practice5()");
//		System.out.println("6. practice6()");
//		System.out.println("7. practice7()");
//		System.out.println("8. practice8()");
//		System.out.println("9. practice9()");
//		System.out.println("10. practice10()");
//		System.out.println("11. practice11()");
//		System.out.println("12. practice12()");
//		System.out.println("13. practice13()");
//		System.out.println("14. practice14()");
//		System.out.println("15. practice15()");
//		System.out.println("16. practice16()");
//			
//		System.out.print("번호 입력 >> ");
//		int input = sc.nextInt();
//			
//		switch(input) {
//			case 1: practice1(); break;
//			case 2: practice2(); break;
//			case 3: practice3(); break;
//			case 4: practice4(); break;
//			case 5: practice5(); break;
//			case 6: practice6(); break;
//			case 7: practice7(); break;
//			case 8: practice8(); break;
//			case 9: practice9(); break;
//			case 10: practice10(); break;
//			case 11: practice11(); break;
//			case 12: practice12(); break;
//			case 13: practice13(); break;
//			case 14: practice14(); break;
//			case 15: practice15(); break;
//			case 16: practice16(); break;
//			default : System.out.println("없는 번호 입력함");
//		}
//	}
//	
//	/**
//	 * 실습 문제 1번
//	 */
//	public void practice1(){
//		System.out.print("1이상의 숫자를 입력하세요 : ");
//		int num = sc.nextInt();
//		if(num < 1) {
//			System.out.print("1이상의 숫자를 입력해주세요");
//		}else {
//			for(int i = 1; i<=num; i++) {
//				System.out.print(i + " ");
//			}
//		}
//	}
//	
//	/**
//	 * 실습 문제 2번
//	 */
//	public void practice2(){
//		System.out.print("1이상의 숫자를 입력하세요 : ");
//		int num = sc.nextInt();
//		if(num < 1) {
//			System.out.print("1이상의 숫자를 입력해주세요");
//		}else {
//			for(int i = 0; i<num; i++) {
//				System.out.print(num - i + " ");
//			}
//		}
//	}
//	
//	/**
//	 * 실습 문제 3번
//	 */
//	public void practice3(){
//		System.out.print("정수를 하나 입력하세요 : ");
//		int num = sc.nextInt();
//		int num2 = 0;
//		for(int i = 1 ; i <= num ; i++) {
//			System.out.print(i);
//			if(i != num ) {
//				System.out.print(" + ");
//			}
//			num2 += i;
//		}
//		System.out.print(" = " + num2);
//	}
//	
//	/**
//	 * 실습 문제 4번
//	 */
//	public void practice4(){
//		System.out.print("첫 번째 숫자 : ");
//		int num1 = sc.nextInt();
//		System.out.print("두 번째 숫자 : ");
//		int num2 = sc.nextInt();
//		int start = num1;
//		int end = num2;
//		if(num1 < 1 || num2 < 1) {
//			System.out.print("1이상의 숫자를 입력해주세요");
//		}
//		else if(num1 > num2) {
//			start = num2;
//			end = num1;
//		}
//		for(int i = start; i <= end; i++) {
//			System.out.print(i + " ");
//		}
//	}
//	
//	/**
//	 * 실습 문제 5번
//	 */
//	public void practice5(){
//		System.out.print("숫자 : ");
//		int num = sc.nextInt();
//		System.out.printf("\n===== %d단 =====\n",num);
//		for(int i = 1 ; i <= 9 ; i++){
//			System.out.printf("%d * %d = %d \n",num,i,num*i);
//		}
//	}
//	
//	/**
//	 * 실습 문제 6번
//	 */
//	public void practice6(){
//		System.out.print("숫자 : ");
//		int num = sc.nextInt();
//		for(int i = num ; i <= 9 ; i++){
//			System.out.printf("\n===== %d단 =====\n",i);
//			for(int p = 1; p <= 9 ; p++){
//				System.out.printf("%d * %d = %d \n",i,p,i*p);
//			}
//		}
//	}
//	
//	/**
//	 * 실습 문제 7번
//	 */
//	public void practice7(){
//		System.out.print("정수 입력 : ");
//		int num = sc.nextInt();
//		String v1 = "";
//		for(int i = 1; i <= num ; i++) {
//			v1 += "*";
//			System.out.printf("%s \n",v1);
//		}
//	}
//	
//	/**
//	 * 실습 문제 8번
//	 */
//	public void practice8(){
//		System.out.print("정수 입력 : ");
//		int num = sc.nextInt();
//		String v1 = "";
//		for(int i = 1; i <= num; i++) {
//			for(int p = i; p <= num; p++) {
//				v1 += "*";
//			}
//			System.out.printf("%s \n",v1);
//			v1 = "";
//		}
//	}
//	
//	/**
//	 * 실습 문제 9번
//	 */
//	public void practice9(){
//		System.out.print("정수 입력 : ");
//		int num1 = sc.nextInt();
//		for(int o = 1; o <= num1 ; o++){ // 입력받은 값만큼 반복
//			String v1 = "";
//			for(int i = 1; i <= (num1-o) ; i++) { //
//				v1 += " ";
//			}
//			for(int l = 1; l <= o ; l++){
//				v1 += "*";
//			}
//			System.out.printf("%s \n",v1);
//		}
//	}
//	
//	/**
//	 * 실습 문제 10번
//	 */
//	public void practice10(){
//		System.out.print("정수 입력 : ");
//		int num = sc.nextInt();
//		String v1 = "";
//		for(int i = 1; i <= num-1 ; i++) {
//			v1 += "*";
//			System.out.printf("%s \n",v1);
//		}
//		v1 = "";
//		for(int i = 1; i <= num; i++) {
//			for(int p = i; p <= num; p++) {
//				v1 += "*";
//			}
//			System.out.printf("%s \n",v1);
//			v1 = "";
//		}
//	}
//	
//	/**
//	 * 실습 문제 11번
//	 */
//	public void practice11(){
//		System.out.print("정수 입력 : ");
//		int num1 = sc.nextInt();
//		for(int o = 1; o <= num1 ; o++){ // 입력받은 값만큼 반복
//			String v1 = "";
//			for(int i = 1; i <= (num1-o) ; i++) { //
//				v1 += " ";
//			}
//			for(int l = 1; l <= o ; l++){
//				v1 += "*";
//				if(l != 1) {
//					v1 += "*";
//				}
//			}
//			System.out.printf("%s \n",v1);
//		}
//	}
//	
//	/**
//	 * 실습 문제 12번
//	 */
//	public void practice12(){
//		System.out.print("정수 입력 : ");
//		int num = sc.nextInt();
//		String v1 = "";
//		for(int i = 1; i <= num ; i++) {
//			v1 += "*";
//		}
//		System.out.printf("%s \n",v1);
//		v1 = "";
//		for(int o = 1; o <= num-2 ; o++){
//			v1 += "*";
//			for(int i = 1; i <= num-2 ; i++) {
//				v1 += " ";
//			}
//			v1 += "*";
//			System.out.printf("%s \n",v1);
//			v1 = "";
//		}
//		v1 = "";
//		for(int i = 1; i <= num ; i++) {
//			v1 += "*";
//		}
//		System.out.printf("%s \n",v1);
//	}
//	
//	/**
//	 * 실습 문제 13번
//	 */
//	public void practice13(){
//		System.out.print("자연수 하나를 입력하세요 : ");
//		int num = sc.nextInt();
//		int conunt = 0;
//		for(int i = 1 ; i<=num ; i++) {
//			if(i % 2 == 0 || i % 3 == 0) {
//				System.out.print(i + " ");
//				if(i % 2 == 0 && i % 3 == 0) {
//					conunt++;
//				}
//			}
//		}
//		System.out.printf("\ncount : %d",conunt);
//	}
//	
//	/**
//	 * 실습 문제 14번
//	 */
//	public void practice14(){
//		System.out.print("숫자 : ");
//		int num = sc.nextInt();
//		if(num < 2) {
//			System.out.print("잘못 입력하셨습니다.");
//		}
//		boolean checked = true;
//		for(int i = 2 ; i <=num ; i++) {
//			if(num%i == 0 && i!=num) {
//				checked = false;
//				break;
//			}
//			
//		}
//		if (checked) {
//			System.out.println("소수");
//			return;
//		}
//		System.out.println("아님");
//	}
//	
//	/**
//	 * 실습 문제 15번
//	 */
//	public void practice15(){
//		int input = -1;
//		while(input < 2) {
//			System.out.print("숫자 : ");
//			input = sc.nextInt();
//			if(input < 2){
//				System.out.println("잘못 입력하셨습니다.");
//			}
//		}
//		boolean checked = true;
//		for(int i = 2 ; i <=input ; i++) {
//			if(input%i == 0 && i!=input) {
//				checked = false;
//				break;
//			}
//			
//		}
//		if (checked) {
//			System.out.println("소수");
//			return;
//		}
//		System.out.println("아님");
//	}
//	
//	/**
//	 * 실습 문제 16번
//	 */
//	public void practice16(){
//		System.out.print("숫자 : ");
//		int num = sc.nextInt();
//		int v1 = 0;
//		if(num < 2) {
//			System.out.println("잘못 입력하셨습니다.");
//		}
//		for(int i = 2 ; i <=num ; i++) { // 입력한 값까지 작동하는 구문 2~x까지
//			boolean flag = true;
//			for(int x = 2 ; x < i ; x++) { // 입력한 값까지 검사하는 구문
//				if(i%x == 0 && x!=i) {
//					flag = false;
//					break;
//				}
//			}
//			if(flag) {
//				System.out.print(i + " ");
//				v1++;
//			}
//		}
//		System.out.printf("\n2부터 %s까지의 소수의 개수는 %d개입니다.",num,v1);
//	}
//	
//}
