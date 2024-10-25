package company.model;

import java.util.Map;

import company.domain.CompanyDTO;

public interface CompanyDAO {

	//회원가입 메소드
	int register(CompanyDTO companyDTO);

	//로그인 메소드
	CompanyDTO login(Map<String, String> paraMap);


	int cpInfoUpdate(CompanyDTO companyDTO);

	// 기업형태별 회사 통계
	Map<String, Integer> getBusinessTypeRatio();

}
