package review.model;

import java.util.List;
import java.util.Map;

import review.domain.ReviewAuthDTO;

public interface ReviewAuthDAO {

	/*
	 * 구직자 1명의 회사인증목록 select
	 * 결과는 Map 형태
	 * 다음 key 를 포함하고 있음
	 * review_auth_id, fk_applicant_id, fk_company_id,
	 * company_name, is_permitted (미인증, 인증완료)
	 */
	List<Map<String, String>> getReviewAuth(String applicantId);

	// === 회사인증 insert === //
	int registerReviewAuth(ReviewAuthDTO reviewAuthDTO);

	// === 회사인증 요청 목록 조회 === //
	List<ReviewAuthDTO> getReqReviewAuthList();

	// === 회사인증 요청 허가/거부 === //
	int manageRequest(ReviewAuthDTO reviewAuthDTO);
	
}
