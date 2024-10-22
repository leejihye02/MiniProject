package admin.model;

import java.util.Map;

import admin.domain.AdminDTO;
/*
 * 관리자와 관련된 DB 데이터 접근 인터페이스
 */
public interface AdminDAO {

	/*
	 * 관리자 로그인
	 */
	AdminDTO login(Map<String, String> loginMap);
}
