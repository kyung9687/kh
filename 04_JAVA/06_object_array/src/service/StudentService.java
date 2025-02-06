package service;

import java.util.Random;

import dto.StudentDTO;

/* Service 
 * - 프로그램의 실질적인 기능(비즈니스 로직)을 
 *   제공하는 클래스
 */
public class StudentService {

	// StudentDTO 객체 배열 선언
	private StudentDTO[] students = new StudentDTO[5];
	
	// new StudentDTO[5] 
	// - StudentDTO 참조형 변수 5칸짜리 배열 생성
	// - 인덱스 : 0 ~ 4
	// - 각 인덱스 요소의 초기값 : null (참조 객체 없음)
	/* 기본 생성자 */
	public StudentService() {
		System.out.println("[초기 학생 정보가 추가됨...]\n");
		
		students[0] = new StudentDTO("20250001", "짱구", '남');
		students[1] = new StudentDTO("20250002", "유리", '여');
		students[2] = new StudentDTO("20250003", "훈이", '남');
		
		
		Random random = new Random();
		
		for(StudentDTO std : students) {
			if(std == null) {
				continue;
			}
			
			std.setHtml(random.nextInt(101));
			std.setCss(random.nextInt(101));
			std.setJs(random.nextInt(101));
			std.setJava(random.nextInt(101));
		}
		
	}
	
	/**
	 * students 객체 배열을 반환하는 메서드
	 * (students에 저장된 주소가 복사되서 반환됨 == 얕은 복사) 
	 * @return students
	 */
	public StudentDTO[] getStudents() {
		return students;
	}
	
	public boolean addStudent(StudentDTO student) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] =student;
				return true;
			}
		}
		
		return false;
	}
	
	
	public StudentDTO selectIndex(int index) {
		
		if(index <0|| index >= students.length) {
			return null;
		}
		return students[index];
		
		
	}
	
	
	public StudentDTO selectName(String targetName) {
		
		for(StudentDTO std : students) {
			if(std == null) {
				return null;
			}
		
		if (std.getName().equals(targetName)) {
			return std;
		}
		}
		return null;
	}
	
	public int checkIndex(int index) {
		
		if (index <0|| index >= students.length) {
			return 1;
		}
		
		if (students[index] == null) {
			return 2;
		}
		return 3;
	}
	
	public void updateScore(int index,int html,int css, int js,int java) {
		
		students[index].setHtml(html);
		students[index].setCss(css);
		students[index].setJs(js);
		students[index].setJava(java);
		
		
		
	}
	
	public String selectMaxMin() {
		
		String maxName = null;
		double MaxAvg = 0.0;
		
		
		String minName = null;
		double MinAvg = 100.0;
		
		for(StudentDTO std : students) {
			if(std == null) {
				break;
			}
			
			
			
		}
		return null;
		
		
	}

	public String deleteStudent(int index) {
		
		String studentName = students[index].getName();
		
		students[index] = null;
		
		for (int i = index; i < students.length; i++) {
			students[i] = students[i+1];
		}
		students[students.length-1]= null;
		
		return studentName;
		
		
		
	}
}
