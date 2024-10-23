package admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import admin.domain.AdminDTO;
import admin.model.AdminDAO;
import admin.model.AdminDAO_imple;
import applicant.domain.ApplicantDTO;
import applicant.model.ApplicantDAO;
import applicant.model.ApplicantDAO_imple;
import company.domain.CompanyDTO;
import notification.controller.NotificationController;
import utils.Msg;
import utils.ValidationUtil;

/*
 * 관리자 컨트롤러
 */
public class AdminController {

	private final AdminDAO adminDAO = new AdminDAO_imple(); // AdminDAO 구현체

	private final ApplicantDAO applicantDAO = new ApplicantDAO_imple(); // ApplicantDAO 구현체

	private final NotificationController notificationController = new NotificationController(); // 공지사항 Controller 인스턴스

	private StringBuilder sb = new StringBuilder(); // StringBuilder 객체 초기화

	/*
	 * 관리자 로그인
	 */
	public AdminDTO login(Scanner sc) {
		Map<String, String> loginMap = new HashMap<>(); // 로그인 Map
		AdminDTO adminDTO = null; // 관리자 DTO 객체 초기화
		String adminId; // 관리자 아이디
		String passwd; // 관리자 비밀번호

		System.out.println("\n=== 관리자 로그인 ===");

		while (true) {
			System.out.print("아이디 : ");
			adminId = sc.nextLine();

			System.out.print("비밀번호 : ");
			passwd = sc.nextLine();

			// 아이디, 비밀번호 공백 검사
			if (adminId.isBlank() || passwd.isBlank()) {
				Msg.W("아이디 및 비밀번호는 공백이 될 수 없습니다.");
				continue;
			}

			// 관리자 로그인 DTO 객체 설정
			loginMap.put("adminId", adminId);
			loginMap.put("passwd", passwd);

			// 관리자 아이디, 비밀번호 인증
			// AdminDTO 객체를 반환하는 AdminDAO_imple login 메소드 실행
			// 아이디 또는 비밀번호가 일치하지 않는 경우 null 이 반환됨
			adminDTO = adminDAO.login(loginMap);

			if (adminDTO == null) {
				Msg.W("아이디 또는 비밀번호가 일치하지 않습니다.");
				continue;
			}

			break;
		}

		return adminDTO;
	}

	/*
	 * 관리자 전용메뉴
	 */
	public void adminMenu(CompanyDTO companyDTO, AdminDTO adminDTO, Scanner sc) {
		String menu = null; // 메뉴번호

		do {
			System.out.println("\n=== 관리자 전용메뉴(" + adminDTO.getName() + "님 로그인 중) ===");
			System.out.println("1.구직자 관리   2.구인회사 관리   3.공지사항 관리   0.로그아웃");
			System.out.println("-".repeat(50));

			System.out.print("▷ 메뉴번호 선택 : ");
			menu = sc.nextLine();
			
			switch (menu) {
			case "0": { // 로그아웃
				adminDTO = null;
				return;
			}
			case "1": { // 구직자 관리
				applicantManage(sc);
				break;
			}
			case "2": { // 구인회사 관리
				companyManage(companyDTO, sc);
				break;
			}
			case "3": { // 공지사항 관리
				notificationController.notificationMenu(adminDTO, sc);
				break;
			}
			default:
				Msg.W("메뉴에 없는 번호입니다.");
			}
		} while (!"0".equals(menu));
	}

	/*
	 * 구인회사 관리
	 */
	private void companyManage(CompanyDTO companyDTO, Scanner sc) {
		String menu = null; // 메뉴번호

		do {
			System.out.println("=== 구인회사 관리 ===");

			System.out.println("=====================< 메뉴 >========================");
			System.out.println("1.리뷰점수로 목록조회\t2.지원수로 목록조회\n3.카테고리 검색\t0.돌아가기");
			System.out.println("====================================================");

			System.out.print("▷ 메뉴번호 선택 : ");
			menu = sc.nextLine();
			
			switch (menu) {
			case "0": { // 돌아가기
				return;
			}
			case "1": { // 리뷰점수로 목록조회
//				getCompanyListByReviewScore();
				break;
			}
			case "2": { // 지원수로 목록조회
//				getCompanyListByApplicants(companyDTO, sc);
				break;
			}
			case "3": { // 카테고리 검색

				break;
			}
			default:
				Msg.W("메뉴에 없는 번호입니다.");
			}
		} while (!"0".equals(menu));

//		System.out.println("===========< 카테고리별 검색 메뉴 >==========");
//		System.out.println("1.회사명\t2.업종별\t3.지역별");
//		System.out.println("========================================");
	}

	/*
	 * 구직자 관리
	 */
	private void applicantManage(Scanner sc) {
		String menu = null; // 메뉴번호

		do {
			System.out.println("\n=== 구직자 관리 ===");

			System.out.println("===============< 메뉴 >=================");
			System.out.println("1.성명 검색\t2.나이대 검색\n3.아이디 검색\t4.구직자 차단\n5.구직자 차단해제\t0.돌아가기");
			System.out.println("=======================================");

			System.out.print("▷ 메뉴번호 선택 : ");
			menu = sc.nextLine();
			
			switch (menu) {
			case "0": { // 돌아가기
				return;
			}
			case "1": { // 성명으로 구직자 검색
				getApplicantListByName(sc);
				break;
			}
			case "2": { // 나이대로 구직자 검색
				getApplicantListByAgeline(sc);
				break;
			}
			case "3": { // 아이디로 구직자 검색
				getApplicantById(sc);
				break;
			}
			case "4": { // 구직자 차단
				blockApplicant(true, sc);
				break;
			}
			case "5": { // 구직자 차단 해제
				blockApplicant(false, sc);
				break;
			}
			default:
				Msg.W("메뉴에 없는 번호입니다.");
			}
		} while (!"0".equals(menu));
	}

	/*
	 * 성명으로 구직자 검색
	 */
	private void getApplicantListByName(Scanner sc) {
		String name = null; // 구직자 성명
		List<ApplicantDTO> applicantList = new ArrayList<>(); // 구직자 리스트
		
		System.out.print("▷ 성명 입력 : ");
		name = sc.nextLine();

		// ApplicantDAO_imple에서 해당 성명의 구직자 반환
		applicantList = applicantDAO.getApplicantListByName(name);
		
		// 구직자가 존재하지 않는 경우
		if (applicantList.size() < 1) {
			System.out.println(">> 조회된 결과가 없습니다. <<\n");
			return;
		}
		
		for (ApplicantDTO applicantDTO : applicantList) {
			sb.append(applicantDTO.toString());
		}

		System.out.println(sb.toString());
	}

	/*
	 * 나이대로 구직자 검색
	 */
	private void getApplicantListByAgeline(Scanner sc) {
		sb.setLength(0); // StringBuilder 객체 초기화
		String ageline = null; // 나이대
		List<ApplicantDTO> applicantList = new ArrayList<>(); // 구직자 리스트

		while (true) {
			System.out.print("▷ 나이대 입력[10의 자리수] : ");
			ageline = sc.nextLine();

			// 나이대 유효성 검사
			// 10의 자리수 10, 20, 30, 40, 50 ...
			if (!ValidationUtil.isNumberValid(ageline)) {
				continue;
			}

			if (Integer.parseInt(ageline) % 10 != 0) {
				Msg.W("나이대는 10의 자리수로 입력해야 합니다.");
				continue;
			}

			break;
		}

		// applicantDAO_imple에서 해당 나이대의 구직자 목록 반환
		applicantList = applicantDAO.getApplicantListByAgeline(ageline);

		if (applicantList.size() < 1) {
			System.out.println(">> 조회된 결과가 없습니다. <<\n");
			return;
		}

		System.out.println("\n-< " + ageline + "대의 구직자 목록 >" + "-".repeat(32));
		System.out.println("이름\t아이디\t나이\t성별\t핸드폰 번호\t상태");
		System.out.println("-".repeat(51));

		for (ApplicantDTO applicantDTO : applicantList) {
			sb.append(applicantDTO.getName() + "\t");
			sb.append(applicantDTO.getApplicantId() + "\t");
			sb.append(getAge(applicantDTO.getBirthday()) + "\t");
			sb.append(applicantDTO.getGender() + "\t");
			sb.append(applicantDTO.getTel() + "\t");
			sb.append(applicantDTO.transStatus() + "\n");
		}

		System.out.println(sb.toString());
		sb.setLength(0);
	}

	/*
	 * 구직자 아이디로 구직자 검색
	 */
	private void getApplicantById(Scanner sc) {
		String applicantId = null; // 구직자 아이디

		System.out.println("=== 구직자 상세검색 ===");

		System.out.print("▷ 아이디 입력 : ");
		applicantId = sc.nextLine();

		// ApplicantDAO_imple에서 해당 아이디의 구직자 반환
		ApplicantDTO applicantDTO = applicantDAO.getApplicantById(applicantId);

		// 구직자가 존재하지 않는 경우
		if (applicantDTO == null) {
			System.out.println(">> 조회된 결과가 없습니다. <<\n");
			return;
		}

		System.out.println(applicantDTO.toString());
	}

	/*
	 * 구직자 차단 관리
	 * block = true : 차단, block = false : 차단 해제
	 */
	private void blockApplicant(boolean block, Scanner sc) {
		String applicantId = null; // 구직자 아이디
		String isblock = block ? "차단" : "차단해제";
		int result = 0; // DML 쿼리 결과

		System.out.println("=== 구직자 차단 관리 ===");

		System.out.print("▷ 아이디 입력 : ");
		applicantId = sc.nextLine();

		// ApplicantDAO_imple에서 해당 아이디의 구직자 차단
		result = applicantDAO.blockApplicant(applicantId, block);

		// 구직자가 존재하지 않는 경우
		if (result == 1) {
			System.out.println(">> 구직자 " + isblock + "을 완료되었습니다. ദ്ദി*ˊᗜˋ*) <<\n");
		} else {
			System.out.println(">> 구직자 " + isblock + "을 실패하였습니다. <<\n");
		}
	}

	/*
	 * 생일에서 나이를 반환하는 메소드
	 */
	private int getAge(String birthday) {

		return 0;
	}
}
