package applicant.domain;

public class ApplicantDTO {
	
	// field
	private String applicantId;  // 구직자아이디
	private String passwd;       // 비밀번호
	private String email;        // 이메일
	private String name;         // 성명
	private String birthday;     // 생일
	private int gender;       // 성별
	private String tel;          // 휴대폰번호
	private int status;          // 가입상태


	
	// method
	public String getApplicantId() {
		return applicantId;
	}
	
	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBirthday() {
		return birthday;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public int getGender() {
		return gender;
	}
	
	public void setGender(int gender) {
		this.gender = gender;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
}
