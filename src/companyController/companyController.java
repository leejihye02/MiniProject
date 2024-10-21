package companyController;

import java.util.Scanner;

import company.domain.companyDTO;
import company.model.companyDAO_imple;
public class companyController {

	//field
	companyDAO_imple  cdao = new companyDAO_imple();

	//method
	
	//register
	// == 구인회사 회원가입 메소드 ==//
	public void register(Scanner sc) {
		System.out.println("\n=== 구인회사 회원가입 ===\n");
		
		System.out.print("1. 아이디 : ");
		String company_id = sc.nextLine();
		
		
		System.out.print("2. 비밀버호 : ");
		String passwd = sc.nextLine(); 
		
		
		System.out.print("3. 이메일 : ");
		String email = sc.nextLine();
		
		System.out.print("4. 회사명 : ");
		String name = sc.nextLine();
		
		System.out.print("5. 사업자등록번호 : ");
		String business_no = sc.nextLine();
		
		System.out.print("6. 주소 : ");
		String address = sc.nextLine();
		
		System.out.print("7. 기업형태 : ");
		String business_type = sc.nextLine();
		
		System.out.print("8. 연락처 : ");
		String tel = sc.nextLine();
		
		
		companyDTO company = new companyDTO();
		company.setCompanyId(company_id);
		company.setPasswd(passwd);
		company.setEmail(email);
		company.setName(name);
		company.setBusinessNo(business_type);
		company.setAddress(address);
		company.setBusinessType(business_type);
		company.setTel(tel);
		
		int n = cdao.register(company);
		
	}
	
	
	
	
	//login
	
	
	//menu
	
}
