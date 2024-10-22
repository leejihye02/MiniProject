package admin.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import admin.domain.AdminDTO;
import admin.model.AdminDAO;
import admin.model.AdminDAO_imple;
import notification.controller.NotificationController;

/*
 * 관리자 컨트롤러
 */
public class AdminController {

	private final AdminDAO adminDAO = new AdminDAO_imple(); // AdminDAO 구현체

	private final NotificationController notificationController = new NotificationController(); // 공지사항 Controller 인스턴스

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
				System.out.println(">> [경고] 아이디 및 비밀번호는 공백이 될 수 없습니다. <<\n");
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
				System.out.println(">> [경고] 아이디 또는 비밀번호가 일치하지 않습니다. <<\n");
				continue;
			}

			break;
		}

		return adminDTO;
	}

	/*
	 * 관리자 전용메뉴
	 */
	public void adminMenu(AdminDTO adminDTO, Scanner sc) {
		String menu = null; // 메뉴번호

		System.out.println("=== 관리자 전용메뉴(" + adminDTO.getName() + "님 로그인 중) ===");
		System.out.println("1.구직자 관리   2.구인회사 관리   3.공지사항 관리   0.로그아웃");
		System.out.println("-".repeat(50));

		System.out.print("▷ 메뉴번호 선택 : ");
		menu = sc.nextLine();

		do {
			switch (menu) {
			case "0": { // 로그아웃
				return;
			}
			case "1": { // 구직자 관리

				break;
			}
			case "2": { // 구인회사 관리

				break;
			}
			case "3": { // 공지사항 관리
				notificationController.notificationMenu(adminDTO, sc);
				break;
			}
			default:
				System.out.println(">> [경고] 메뉴에 없는 번호입니다. <<\n");
			}
		} while (!"0".equals(menu));
	}
}
