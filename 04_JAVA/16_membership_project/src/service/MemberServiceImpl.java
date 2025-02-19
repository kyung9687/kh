package service;

import dao.MemberDAO;
import dao.MemberDAOImpl;
import dto.Member;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* 왜 Service, Dao 인터페이스를 만들어서 구현했을까?
 * - 인터페이스를 상속 받아 구현하면
 *   모든 자식 클래스가 똑같은 기능을 가지게되어
 *   비슷하게 생김!
 *
 *  -> 언제든지 서로 다른 자식 클래스로 대체 가능!!
 *    ==> 유지보수성 증가
 */

// MemberService를 상속 받아 구현
public class MemberServiceImpl implements MemberService{

    // dao 객체 부모 참조 변수 선언
    private MemberDAO dao = null;
    private String[] gradeArr = {"일반", "골드", "다이아"};


    // 기본 생성자
    // - MemberServiceImpl 객체 생성 시
    //   MemberDAOImpl 객체도 생성
    public MemberServiceImpl() 
    		throws FileNotFoundException, ClassNotFoundException, IOException {
        dao = new MemberDAOImpl();
        dao.saveFile();
    }

    
    //********************************
    // 추가, 수정 삭제 기능이 수행되면
    // 무조건 dao.saveFile() 수행!
    //********************************

    // 회원 추가
    @Override
    public boolean addMember(String name, String phone) throws IOException {
      List<Member> memberList = dao.getMemberList();

      // 전화번호가 중복되는지 확인
      for (Member member : memberList) {
          if (phone.equals(member.getPhone())) {
              return false; // 중복된 전화번호가 있을 경우 false 반환
          }
      }

      // 중복된 전화번호가 없으면 새로운 회원을 추가
      Member newMember = new Member(name, phone, 0, 0);
      return dao.addMember(newMember);
  }


    // DAO에서 조회한 memberList를 그대로 반환
    @Override
    public List<Member> getMemberList() {
        return dao.getMemberList();
    }


    // 이름 검색
    @Override
    public List<Member> selectName(String searchName) {
    	List<Member> memberList = dao.getMemberList();
      List<Member> searchList = new ArrayList<Member>();
      for (Member member : memberList) {
        if (member.getName().equals(searchName)) {
            searchList.add(member);
        }
      }

      return searchList;
    }


    // 금액 누적
    @Override
    public String updateAmount(Member target, int acc) throws IOException {
        int beforeAmount = target.getAmount();
        target.setAmount(beforeAmount + acc);

        int currentAmount = target.getAmount();
        int grade = target.getGrade();

        if (currentAmount >= 1000000 && grade < Member.DIAMOND) {
            grade = Member.DIAMOND;  

        } else if (currentAmount >= 100000 && grade < Member.GOLD) {
            grade = Member.GOLD;  

        }


        StringBuilder sb = new StringBuilder();
        sb.append(target.getName());
        sb.append(" 회원님의 누적 금액\n");
        sb.append(beforeAmount + " -> " + currentAmount);

        if (target.getGrade() != grade) {
            sb.append("\n" + target.getName() + "님의 등급이 " + "\n* " + gradeArr[grade] + " * 등급으로 변경 되셨습니다\n");
            target.setGrade(grade);
        }

        dao.saveFile();

        return sb.toString();
    }


    //회원 정보(전화번호) 수정
    @Override
    public String updateMember(Member target, String phone) throws IOException {

    	String beforePhone = target.getPhone();
      target.setPhone(phone);
      StringBuilder sb = new StringBuilder();
      sb.append(target.getName());
      sb.append("님의 전화번호가 변경 되었습니다\n");
      sb.append(beforePhone + " -> " + phone);
      
      dao.saveFile();
      return sb.toString();
    }


    // 회원 탈퇴
    @Override
    public String deleteMember(Member target) throws IOException {

    	 List<Member> memberList = dao.getMemberList();
       memberList.remove(target);
       
       dao.saveFile();
       return target.getName() + " 회원이 탈퇴 처리 되었습니다";
    }

}