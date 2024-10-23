package review.domain;

public class ReviewAuthDTO {
	
	// field
    private int reviewAuthId;     // 회사인증일련번호
    private String fkApplicantId; // 구직자아이디
    private String fkCompanyId;   // 회사아이디
    private int isPermitted;      // 관리자허가여부 0:요청 1:허용 2:거부

	// method
	public int getReviewAuthId() {
		return reviewAuthId;
	}
	
	public void setReviewAuthId(int reviewAuthId) {
		this.reviewAuthId = reviewAuthId;
	}
	
	public String getFkApplicantId() {
		return fkApplicantId;
	}
	
	public void setFkApplicantId(String fkApplicantId) {
		this.fkApplicantId = fkApplicantId;
	}
	
	public String getFkCompanyId() {
		return fkCompanyId;
	}
	
	public void setFkCompanyId(String fkCompanyId) {
		this.fkCompanyId = fkCompanyId;
	}
	
	public int getIsPermitted() {
		return isPermitted;
	}
	
	public void setIsPermitted(int isPermitted) {
		this.isPermitted = isPermitted;
	}
}
