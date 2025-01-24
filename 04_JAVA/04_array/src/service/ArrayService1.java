package service;

import java.util.Scanner;

public class ArrayService1 {

/*
 * 배열
 * -같은 자료형의 변수를 하나의묶음으로 다루는것
 * 생성시 Heap 메모리영역에 할당
 * -주소를 참조해서 배열 요소 접근 가능
 */

	
	public void method1() {
		
		int num;
		
		int[] arr;
		
		
		arr = new int[4];
//		int형 변수4개 묶인 배열 할당
		
		arr[0]=10;
		arr[1]=20;
		arr[2]=30;
		arr[3]=40;
		
		for (int i = 0; i < arr.length; i++) {
			arr[i]=(i+1)*100;
		}
		
		System.out.println("arr[0] : "+arr[0]);
		System.out.println("arr[1] : "+arr[1]);
		System.out.println("arr[2] : "+arr[2]);
		System.out.println("arr[3] : "+arr[3]);
		
		
	}
	
	public void method2() {
		
		int[] arr = {10,20,30};
		for(int num:arr) {
			System.out.println(num);
			
		}
		

	}
	public void method3() {
		String[] menus = {"순대국", "닭갈비","마라탕","햄버거",
											"짜장면","짬뽕","포케","샐러드"};
		
		int randomNumber = (int)(Math.random()* menus.length);
		System.out.println("오늘의 점심매뉴는: " +menus[randomNumber]);
		}
	
	public void method4() {
		Scanner sc = new Scanner(System.in);
		long[] arr =new long[3];
		
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d] 값 입력 :",i);
			arr[i] =sc.nextLong();
		}
		
		for(long num :arr) {
			System.out.println(num);
		}
		
		System.out.print("arr[3]에 대입 할 값 : ");
		long input = sc.nextLong();
		
		arr[3] =input;
		
		System.out.println("확인 : "+arr[3]);
		
	}
	
	public void method5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력받을 인원수 : ");
		int size = sc.nextInt();
		
		int[] scoreArr =new int[size];
		
		int sum =0;
		for(int i=0; i<scoreArr.length; i++) {
			System.out.printf("%d번째 인덱스 점수 입력 : ",i+1);
			scoreArr[i] =sc.nextInt();
			
			sum += scoreArr[i];
		}
		System.out.println("합계 : " +sum);
		System.out.println("평균 : " +(double)sum/size);
		
		int maxIndex =0;
		int minIndex =0;
		
		for (int i = 1; i < scoreArr.length; i++) {
			if(scoreArr[i]> scoreArr[maxIndex]) {
				maxIndex=i;
			}
			if(scoreArr[i]< scoreArr[minIndex]) {
				minIndex=i;
			}
		}
		System.out.println("최대값 : "+ scoreArr[maxIndex]);
		System.out.println("최소값 : "+ scoreArr[minIndex]);
		 
		
	}
}
