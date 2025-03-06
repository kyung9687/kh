package com.kh.mvc.run;

import java.util.Properties;

import com.kh.mvc.view.UserView;

public class Run {

	public static void main(String[] args) {
		/*
		 * model : 데이터 관련된 모든 작업
		 * view	 : 화면 입/ 출력(얘는 힘 안줄 것)
		 * controller: view에서의 요청을 받아서 처리해주는 역할
		 * 
		 */
		
		new UserView().mainMenu();
	}

}
