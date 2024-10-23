package recruitment.domain;

import company.domain.CompanyDTO;
import job.domain.JobDTO;

//RecruitmenDTO 은 오라클의 TBL_RECRUITMENT에 해당하며, TBL_COMMPANY 와 TBL_JOB 을 참조합니다.
public class RecruitmentDTO { 
	
	// === field ===
	private int recruitmentId; 		    // 채용공고일련번호
	private String fkCompanyId; 		// 회사아이디
	private int fkJobId; 				// 직종일련번호
	private String title; 				// 채용공고제목
	private String contents; 			// 채용공고내용
	private int empType; 			    // 채용형태
	private int people; 				// 채용인원
	private int salary; 				// 연봉
	private String registerday; 		// 등록일자
	private String deadlineday; 		// 채용마감일자
	private int experience; 			// 경력
	private String updateday; 			// 최신수정일
	private int isDelete; 				// 삭제여부
	
	
	private JobDTO jobdto;				// TBL_JOB 테이블과 join하기 위함
	
	private CompanyDTO comdto;			// TBL_COMPANY 테이블과 join하기 위함
	
	
	
	// meythod
	public int getRecruitmentId() {
		return recruitmentId;
	}
	public void setRecruitmentId(int recruitmentId) {
		this.recruitmentId = recruitmentId;
	}
	public String getFkCompanyId() {
		return fkCompanyId;
	}
	public void setFkCompanyId(String fk_companyId) {
		this.fkCompanyId = fk_companyId;
	}
	public int getFkJobId() {
		return fkJobId;
	}
	public void setFkJobId(int fkJobId) {
		this.fkJobId = fkJobId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getEmpType() {
		return empType;
	}
	public void setEmpType(int empType) {
		this.empType = empType;
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getRegisterday() {
		return registerday;
	}
	public void setRegisterday(String registerday) {
		this.registerday = registerday;
	}
	public String getDeadlineday() {
		return deadlineday;
	}
	public void setDeadlineday(String deadlineday) {
		this.deadlineday = deadlineday;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getUpdateday() {
		return updateday;
	}
	public void setUpdateday(String updateday) {
		this.updateday = updateday;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	
	
	// join
	public JobDTO getJobdto() {
		return jobdto;
	}
	public void setJobdto(JobDTO jobdto) {
		this.jobdto = jobdto;
	}
	
	public CompanyDTO getComdto() {
		return comdto;
	}
	public void setComdto(CompanyDTO comdto) {
		this.comdto = comdto;
	}
	
}
