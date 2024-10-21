package admin.domain;
/*
 * 관리자 로그인 DTO
 */
public class AdminLoginDTO {

	private String admin_id; // 관리자 아이디

	private String passwd; // 관리자 비밀번호
	
	// set 함수 오남용 방지를 위한 전체 생성자
	public AdminLoginDTO(String admin_id, String passwd) {
		this.admin_id = admin_id;
		this.passwd = passwd;
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public String getPasswd() {
		return passwd;
	}
}
