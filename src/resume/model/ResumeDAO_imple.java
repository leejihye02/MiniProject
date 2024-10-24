package resume.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import applicant.domain.ApplicantDTO;
import apply.model.ApplyDAO;
import common.ProjectDBConnection;
import job.domain.JobDTO;
import resume.domain.ResumeDTO;

public class ResumeDAO_imple implements ResumeDAO{
	
	

	Connection conn = ProjectDBConnection.getConn();
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	ResumeDTO resumeDTO = null;
	JobDTO jobDTO = null;
	String sql = "";
	
	// === 자원반납 === //
	private void close() {
		try {
			if(rs != null) { rs.close(); rs = null; }
			if(pstmt != null) { pstmt.close(); pstmt = null; }
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}// end of close()-------------------------
	
	
	
	// *** 이력서가 작성되어있는지 검사 *** //
	
	@Override
	public boolean resume_Completed(ApplicantDTO applicant) {
		
		boolean completed = false;
		
		sql = " select * "
			+ " from TBL_RESUME R JOIN tbl_job J "
			+ " ON R.fk_job_id = J.job_id "
			+ " JOIN TBL_APPLICANT A "
			+ " ON R.fk_applicant_id = A.applicant_id "
			+ " where applicant_id = ? ";
		
			try {
				pstmt = conn.prepareStatement(sql);
			
				pstmt.setString(1,applicant.getApplicantId());
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					completed = true;
					return completed;	//행이 존재함(이력서를 이미 작성함)
				}
				
				
			} catch (SQLException e) {
			}
			finally {
				close();
			}
		return completed;	// 행이 존재하지 않음 (이력서를 작성하지 않음 즉, 이력서 작성 실행가능)
	}

	
	
	// *** 이력서 관리(이력서관리탭에 들어오면 이력서 무조건 보여주기위함) *** //
	@Override
	public ResumeDTO list_Resume(ApplicantDTO applicant) {
		
		resumeDTO = new ResumeDTO();
		jobDTO = new JobDTO();
		
	try {
		
		sql = " select R.experience,R.education,R.hope_location,J.job_id,J.name,R.job_description,R.hope_salary "
				+ " from TBL_RESUME R JOIN tbl_job J "
				+ " ON R.fk_job_id = J.job_id "
				+ " JOIN TBL_APPLICANT A "
				+ " ON R.fk_applicant_id = A.applicant_id "
				+ " where applicant_id = ? ";
		
		
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,applicant.getApplicantId());
			
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				
				
				resumeDTO.setExperience(rs.getInt("experience"));
				resumeDTO.setEducation(rs.getInt("education"));
				resumeDTO.setHope_location(rs.getString("hope_location"));
				jobDTO.setName(rs.getString("name")); 					// Jobdto의 setName에 희망직종 set. 
				resumeDTO.setJob_description(rs.getString("job_description"));
				resumeDTO.setHope_salary(rs.getInt("hope_salary"));
				jobDTO.setJob_id(rs.getInt("job_id"));
				resumeDTO.setJobDTO(jobDTO);
			}
			
		    } catch (SQLException e) {
				e.printStackTrace();
		    }finally {
				close();
			}
			
		return resumeDTO;
	}
	
	

	
	// *** 이력서 작성 *** //
	@Override
	public int writeResume(ApplicantDTO applicant,ResumeDTO resumeDTO) {
		System.out.println("");
		int result = 0;
		try {
			
			sql = " insert into TBL_RESUME (resume_id,fk_applicant_id,fk_job_id "
				+ " ,experience,education,hope_location,job_description,hope_salary) "
				+ " values(seq_resume_id.nextval,?,?,?,?,?,?,?) ";
			

			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, applicant.getApplicantId());// 로그인된 회원의 아이디를 인자로 받아 고정입력
			pstmt.setInt(2, resumeDTO.getFk_job_id()); //희망직종코드 
			pstmt.setInt(3, resumeDTO.getExperience());
			pstmt.setInt(4, resumeDTO.getEducation());
			pstmt.setString(5, resumeDTO.getHope_location());
			pstmt.setString(6, resumeDTO.getJob_description());
			pstmt.setInt(7, resumeDTO.getHope_salary());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return result;
	}// end of public void writeResume() ----


	
	

	// *** 이력서 수정 *** //
	@Override
	public int modifyResume(ResumeDTO resumeDTO,ApplicantDTO applicant) {
		int result = 0;
		
		try {
			
			sql = " update TBL_RESUME  "
					+ " set fk_job_id=? "
					+ "    ,experience=? "
					+ "    ,education=? "
					+ "    ,hope_location=? "
					+ "    ,job_description=? "
					+ "    ,hope_salary=? "
					+ " where fk_applicant_id = ? "; // 로그인된 구직자의 아이디로 조건 설정
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, resumeDTO.getFk_job_id());
			pstmt.setInt(2, resumeDTO.getExperience());
			pstmt.setInt(3, resumeDTO.getEducation());
			pstmt.setString(4, resumeDTO.getHope_location());
			pstmt.setString(5, resumeDTO.getJob_description());
			pstmt.setInt(6, resumeDTO.getHope_salary());
			pstmt.setString(7, applicant.getApplicantId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return result;
	}
	
	
	

}
