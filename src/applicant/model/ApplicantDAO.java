package applicant.model;

import java.util.Map;

import applicant.domain.ApplicantDTO;

public interface ApplicantDAO {

	// === 회원가입 === //
	public int register(ApplicantDTO applicantDTO);
	
	// === 로그인 === //
	ApplicantDTO login(Map<String, String> paraMap);

}
