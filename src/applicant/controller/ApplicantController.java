package applicant.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import applicant.domain.ApplicantDTO;
import applicant.model.ApplicantDAO;
import applicant.model.ApplicantDAO_imple;

public class ApplicantController {

	// field
	ApplicantDAO applicantDAO = new ApplicantDAO_imple();
	
	// method
	
	// === 구직자 회원가입 === //
	public void register(Scanner sc) {
		System.out.println("=== 구직자 회원가입 ===\n");
		
		String applicantId, passwd, email, name, birthday, gender, tel;
		
		System.out.print("▷ 아이디 : ");
		applicantId = sc.nextLine();

		System.out.print("▷ 비밀번호[영문,숫자,특수문자 조합] : ");
		passwd = sc.nextLine();

		System.out.print("▷ 이메일 : ");
		email = sc.nextLine();

		System.out.print("▷ 성명 : ");
		name = sc.nextLine();

		System.out.print("▷ 생일[19990101] : ");
		birthday = sc.nextLine();

		System.out.print("▷ 성별[남/여] : ");
		gender = sc.nextLine();

		System.out.print("▷ 전화번호 : ");
		tel = sc.nextLine();
		
		
	}

	
	// === 구직자 로그인 === //
	public ApplicantDTO login(Scanner sc) {
		System.out.print("▷ 아이디 : ");
		String applicantId = sc.nextLine();
		
		System.out.print("▷ 비밀번호 : ");
		String passwd = sc.nextLine();
		
		Map<String, String> paraMap = new HashMap<>();
		paraMap.put("applicantId", applicantId);
		paraMap.put("passwd", passwd);
		
		ApplicantDTO applicantDTO = applicantDAO.login(paraMap);
		
		if(applicantDTO != null) {
			System.out.println("\n>> 로그인이 완료되었습니다. <<\n");
		}
		else {
			System.out.println("\n>> 로그인에 실패하였습니다. <<\n");
		}
		
		return applicantDTO;
	}
	
	
	// === 구직자 메인 메뉴 === //
	public void applicantMenu(ApplicantDTO applicant, Scanner sc) {
		do {
			System.out.println("=======< 구직자 메인 메뉴(엄정화님 로그인 중) >=======\n"
							 + "1.내 정보 관리   2.이력서 관리   3.구인회사 찾기\n"
							 + "4.채용공고 찾기   5.입사지원 현황   6.리뷰 작성\n"
							 + "7.공지사항 조회\n"
							 + "0.로그아웃\n"
							 + "=====================================================\n");
			System.out.print("▷ 메뉴번호 선택 : ");
			String menu = sc.nextLine();
			
			switch (menu) {
			case "1": // 내 정보 관리
				// 김규빈
				break;
			
			case "2": // 이력서 관리
				// 이상우
				break;
			
			case "3": // 구인회사 찾기
				// 이지혜
				break;
			
			case "4": // 채용공고 찾기
				// 강이훈
				break;
			
			case "5": // 입사지원 현황
				// 이상우
				break;
			
			case "6": // 리뷰 작성
				// 김규빈
				break;
			
			case "7": // 공지사항 조회
				// 김진성
				break;
			
			case "0": // 로그아웃
				return;

			default:
				System.out.println(">> [경고] 입력하신 메뉴 번호 "+menu+"는 존재하지 않습니다. <<");
				break;
			}
			
		} while(true);
	}
}
