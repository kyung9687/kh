package com.kh.mvc.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.kh.mvc.controller.UserController;
import com.kh.mvc.model.UserDTO;


/**
 * memberView 클래스는 jdbc 실습을 위해 생성하였으며.
 * 사용자에게 입력및 출력을 수행하는 메소드를 제공합니다.
 * 
 * 
 */
public class UserView {
	
	private Scanner sc = new Scanner(System.in);
	private UserController userController = new UserController();
	
	public void mainMenu() {
		while (true) {
			System.out.println("--- USER테이블 관리 프로그램 ---");
			System.out.println("1.회원 전체 조회");
			System.out.println("2.회원 추가");
			System.out.println("9.프로그램 종료");
			System.out.print("이용할 메뉴를 선택해 주세요 > ");
			int menuNo =0;
			
			try {
				menuNo = sc.nextInt();
			} catch (InputMismatchException e) {
				sc.nextLine();
				continue;
			}
			sc.nextLine();
			
			switch (menuNo) {
			case 1:	findAll();
				
				break;
			case 2:	insertUser();
			
			break;
			
			case 9: System.out.print("프로그램 종료");
			return;
			default: System.out.println("잘못된 메뉴 선택입니다");
			}
		}
		
	}
	private void findAll() {
		System.out.println("\n --- 회원전체 목록입니다 ---");
		
		List<UserDTO> list = userController.findAll();
		
		System.out.println(list.size());
		if (!list.isEmpty()) {
			System.out.println("================================================");
			for(UserDTO user: list) {
				System.out.println(user.getUserName()+"님의 정보");
				System.out.println("아이디: "+user.getUserId());
				System.out.println("가입일: "+user.getEnrollDate());
				System.out.println();
			}
			System.out.println("================================================");
		}else {
			System.out.println("회원없음");
		}
	
	}
	
	
	private void insertUser() {

		System.out.print("회원아이디를 입력하세요 >");
		String userId = sc.nextLine();
		System.out.print("비밀번호를 입력하세요 >");
		String userPw = sc.nextLine();
		System.out.print("이름를 입력하세요 >");
		String userName = sc.nextLine();

		int result= userController.insertUser(userId,userPw,userName);
		
		if(result >0) {
			System.out.println("잘됨");
		}else {
			System.out.println("안됨");
		}
	}
}
