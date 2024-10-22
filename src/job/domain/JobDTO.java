package job.domain;

//JobDTO 은 오라클의 TBL_JOB에 해당하며, TBL_RECRUITMENT 테이블의 부모테이블에 해당됩니다.
public class JobDTO {

	// === field ===
	private int job_id; 	// 직종일련번호
	private String name; 	// 직종이름
	
	
	// meythod
	public int getJob_id() {
		return job_id;
	}
	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
