package admin.model;

import admin.domain.AdminDTO;
import admin.domain.AdminLoginDTO;

public interface AdminDAO {

	/*
	 * 관리자 로그인
	 */
	AdminDTO login(AdminLoginDTO loginDTO);
}
