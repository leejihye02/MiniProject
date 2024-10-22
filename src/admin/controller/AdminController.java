package admin.controller;

import java.util.Scanner;

import admin.domain.AdminDTO;
import admin.domain.AdminLoginDTO;
import admin.model.AdminDAO;
import admin.model.AdminDAO_imple;
import utils.AuthUtil;

public class AdminController {

	private final AdminDAO adminDAO = new AdminDAO_imple(); // 재할당 불가능 AdminDAO 구현체

	/*
	 * 관리자 로그인
	 */
	public AdminDTO login(Scanner sc) {
		AdminLoginDTO loginDTO = null; // 관리자 로그인 DTO 객체 초기화
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
			
			// 비밀번호 유효성 검사
			if(!AuthUtil.isPasswordValid(passwd)) {
				System.out.println(">> [경고] 아이디 또는 비밀번호가 일치하지 않습니다. <<\n");
				continue;
			}
			
			// 관리자 로그인 DTO 객체 설정
			loginDTO = new AdminLoginDTO(adminId, passwd);
			
			// 관리자 아이디, 비밀번호 인증 
			// AdminDTO 객체를 반환하는 AdminDAO_imple login 메소드 실행
			// 아이디 또는 비밀번호가 일치하지 않는 경우 null 이 반환됨
			adminDTO = adminDAO.login(loginDTO);
			
			if(adminDTO == null) {
				System.out.println(">> [경고] 아이디 또는 비밀번호가 일치하지 않습니다. <<\n");
				continue;
			}
			
			break;
		} 
		
		return adminDTO;
	}
}
