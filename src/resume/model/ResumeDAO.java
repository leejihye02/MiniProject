package resume.model;

import java.util.Map;

import applicant.domain.ApplicantDTO;
import resume.domain.ResumeDTO;

//이력서
public interface ResumeDAO {
	
	
	// *** 이력서가 작성되어있는지 검사 *** //
	boolean resume_Completed(ApplicantDTO applicant);
	
	// *** 이력서 관리 *** //
	ResumeDTO list_Resume(ApplicantDTO applicant);
	
	
	// *** 이력서 작성 *** //
	int writeResume(ApplicantDTO applicant,ResumeDTO resumeDTO);

	// *** 이력서 수정 *** //
	int modifyResume(ResumeDTO resumeDTO,ApplicantDTO applicant);

	

	




}
