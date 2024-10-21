package company.domain;

public class companyDTO {
      //오라클의 tbl_company 테이블에 해당한다.
	
	//field
	
	private String companyId; 		//회사 아이디
	private String passwd;			// 회사 비번
	private String email; 			//이메일
	private String name; 			// 회사명
	private String businessNo; 	//사업자등록번호
	private String address; 		//주소
	private String businessType; 	//기업형태
	private String tel;  			//연락처
	private String inustry;   		//업종
	private int	status;				//가입상태
	
	
	
	
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
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
	
	
	public String getBusinessNo() {
		return businessNo;
	}
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String getBusinessType() {
		return businessType;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
	public String getInustry() {
		return inustry;
	}
	public void setInustry(String inustry) {
		this.inustry = inustry;
	}
	
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
