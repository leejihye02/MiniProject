package admin.domain;

/*
 * 관리자 DTO
 * TBL_ADMIN 테이블
 */
public class AdminDTO {
	
	private String admin_id; // 관리자 아이디
	
	private String passwd; // 관리자 비밀번호
	
	private String name; // 관리자 성명
	
	private int status; // 가입 상태 (0 : 탈퇴, 1 : 가입)

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
