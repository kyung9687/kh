package encapsulation;

// 클래스 객체의 속성과 기능을 정의한 문서(설계도)
public class Person {
	private String personName;
	private double height;


	public void setName(String name) {
		this.personName = name;
	}
	
	public void setHeight(double height) {
		if(height>=0) {
			this.height= height;
		}else {
			this.height = height * -1;
		}
	}
	public String getInfo() {
		return "이름: " + personName + "/ 키 : " + height;
	}
}



