package recruitment.model;

import java.util.List;

import company.domain.CompanyDTO;
import recruitment.domain.RecruitmentDTO;


public interface RecruitmentDAO {

	// 채용공고 관리
//	postingManagement();
	
	// 글목록보기
	List<RecruitmentDTO> recruitmenList();

	// 채용공고 상세보기
	// 단 1개에 관한 select문
	RecruitmentDTO recruitmentInfoSelect(String recruitmentId);
	
	// 채용공고 등록
	int recruitmentInsert(CompanyDTO companyDTO, RecruitmentDTO recruitmentDTO);
	
	// 채용공고 수정
	int recruitmentUpdate(RecruitmentDTO recruitmentDTO);

	// 채용공고 삭제
	int recruitmentDelete(RecruitmentDTO recruitmentDTO);

}
