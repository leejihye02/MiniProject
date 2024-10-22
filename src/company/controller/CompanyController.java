package company.controller;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import company.domain.CompanyDTO;
import company.model.companyDAO_imple;
import utils.ValidationUtil;


public class CompanyController {

	//field
	companyDAO_imple cdao = new companyDAO_imple();
	CompanyDTO companyDTO = new CompanyDTO();

	//method
	
	//register
	// == 구인회사 회원가입 메소드 ==//
	
	public void register(Scanner sc) {


		String name = "";
		String businessNo= "";
		String address = "";
		String businessType = "";
		String industry = "";
		String tel= "";
		String companyId = "";
		String passwd ="";
		String email ="";
				
		System.out.println("\n=== 구인회사 회원가입 ===\n");
		
		
		do {
			System.out.print("1. 아이디 : ");
			companyId = sc.nextLine();
			
			if(ValidationUtil.isIDValid(companyId)) {
				break;
			}
		
		}while(true);
		
		
		
		do {
			System.out.print("2. 비밀번호 : ");
			passwd = sc.nextLine(); 
			
			if(ValidationUtil.isPasswordValid(passwd)) {
				break;
		    }
		
		}while(true);
	
		do {
			System.out.print("3. 이메일 : ");
			email = sc.nextLine();
		
			if(ValidationUtil.isEmailValid(email)) {
				break;
		    }
		
		}while(true);
		
		do {
			System.out.print("4. 회사명 : ");
			name = sc.nextLine();
			
			if(!name.isBlank()) {
				break;
			}
		
		}while(true);
		

		
		do {
			System.out.print("5. 사업자등록번호 : ");
			businessNo = sc.nextLine();
			
			
			if(!businessNo.isBlank()) {
				break;
			}
		
		}while(true);
		
		
		do {
			System.out.print("6. 주소 : ");
			address = sc.nextLine();
			
			if(!address.isBlank()) {
				break;
			}
		
		}while(true);
		
		
		do {
			System.out.print("7. 기업형태 [0:대기업, 1:중견기업 2:중소기업]: ");
			businessType = sc.nextLine();
			
			if(!businessType.isBlank()) {
				break;
			}
		
		
		}while(true);
		
		
		do {		
			System.out.print("8. 연락처 : ");
			tel = sc.nextLine();
			if(ValidationUtil.isTelValid(tel)) {
				break;
		    }
		}while(true);
		
		
		do {
			System.out.print("9. 업종 : ");
			 industry = sc.nextLine();
			if(!industry.isBlank()) {
				break;
			}
		 
		}while(true);
			
		
		
	
		//---------------------------------------------------------------//
		
		CompanyDTO company = new CompanyDTO();
		company.setCompanyId(companyId);
		company.setPasswd(passwd);
		company.setEmail(email);
		company.setName(name);
		company.setBusinessNo(businessNo);
		company.setAddress(address);
		company.setBusinessType(0);
		company.setIndustry(industry);
		company.setTel(tel);
		
		int n = cdao.register(company);
		
		if(n==1) {
			System.out.println("\n>>> 회원가입을 축하드립니다");
		}
		else {
			System.out.println("\n>>> 회원가입이 실패되었습니다 <<<\n");
		}
		
	
	}//public void register(Scanner sc)
	
	
	
	
	//login
	public CompanyDTO login(Scanner sc){
		
		
		
	
		System.out.println("=== 구인회사 로그인 ===");
		
		System.out.print("아이디 : ");
		String company_id = sc.nextLine();
		
		

		System.out.print("비밀번호 : ");
		String passwd = sc.nextLine();
	
		
		Map<String,String> paraMap = new HashMap<>();
		paraMap.put("company_id",company_id);
		paraMap.put("passwd",passwd);
		
		CompanyDTO company = cdao.login(paraMap);
		
		if (company != null) {
			System.out.println(">> ---- 로그인 성공! ---- <<");
		}
		else {
			System.out.println(">> ---- 로그인 실패 ---- <<");
		}
		
		return company;

	}//public void login(Scanner sc)
	
	
	
	
	
	
	
	//구인회사 전용 메뉴
	public void companyMenu(CompanyDTO companyDTO ,Scanner sc ){
		
		do {
		/////////////////////////////
			System.out.println(">> === 구인회사 전용메뉴 (로그인 "+companyDTO.getName()+"중...) ===<<");
			
			System.out.println("1. 우리회사정보관리   2.우리회사리뷰조회\n"
					          + "3. 우리회사 채용공고 관리   0.로그아웃");
			System.out.println("====================================");
			
			System.out.print("▷ 메뉴번호 선택 : ");
			String choiceNo = sc.nextLine();
			
			
			
			switch (choiceNo) {
			case "1"://우리회사정보관리 - 이지혜
				
				companyInfoManagement(companyDTO.getName(),sc);
				
				break;
				
			case "2"://우리회사리뷰조회 - 김규빈
				
				break;
				
			case "3"://우리회사채용공고 - 강이훈
				//menuRecruitment( cdto.getName() , sc);
				break;
		
		
			case "0"://로그아웃
		
				return;
	
			default:
				System.out.println(">>> [ 경고 ] 메뉴에 없는 번호입니다. 다시 선택해주세요.<<<\n");
				
				break;
			}
		/////////////////////////////////////////
		}while(true);
		
	}


	
	

	//우리회사정보관리
	private void companyInfoManagement(String name, Scanner sc) {
		
		
		System.out.println("==== 우리 회사 정보관리 =====");
		System.out.println(companyDTO.toString());//companyDTO > toString 에 정보 들어가있음 
		System.out.println("-".repeat(45));
		
		
		System.out.println("=======< 메뉴 >==========");
		System.out.println("1. 회사정보수정  0.돌아가기");
		System.out.println("-".repeat(30));
		
		System.out.print("▷ 메뉴번호선택");
		String choiceNo = sc.nextLine();
		
		switch (choiceNo) {
		case "1"://회사정보수정
			cpInfoModify(companyDTO, sc); //CompanyInfoModify
			break;
			
		case "0"://돌아가기
			
			break;

		default:
			System.out.println(">>> [ 경고 ] 메뉴에 없는 번호입니다. 다시 선택해주세요.<<<\n");
			break;
		}
		
		
		
		
	}//end of private void companyInfoManagement(String name, Scanner sc) {



	

	//회사정보 수정
	private void cpInfoModify(CompanyDTO cdto2, Scanner sc) {
		
		System.out.println(">> [ 주의사항 ] 변경하지 않고 예전의 데이터값을 그대로 사용하시려면 그냥 엔터하세요.");
		
		
	}//end of private void cpInfoModify(companyDTO cdto2, Scanner sc)
	
	
	
	
	}//end of public void mainMenu(Scanner sc){

