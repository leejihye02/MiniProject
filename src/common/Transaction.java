package common;

import java.text.DecimalFormat;

public class Transaction {

	// 입력받은 경력 experience 0,1을 '신입', '경력'으로 바꿔주는 메소드
	public static String experience(int experience) {
		
		String msg="";
		
		if(experience == 0) {
			msg = "신입";
		}
		else if(experience == 1){
			msg = "경력직";
		}
		else {
			msg = "존재하지 않는 경력입니다. 경력은 '신입'과 '경력직'만 가능합니다.";
		}
		return msg;
		
	} // end of private String experience(int experience)-----------
	
	
	// 입력받은 경력 experience 0,1을 '신입', '경력'으로 바꿔주는 메소드
		public static String education(int education) {
			
			String msg="";
			
			if(education == 0) {
				msg = "대졸";
			}
			else if(education == 1){
				msg = "고졸";
			}
			else if(education == 2){
				msg = "초대졸";
			}
			else if(education == 3){
				msg = "대학교재학";
			}
			else if(education == 4){
				msg = "대학교휴학";
			}
			else {
				msg = "존재하지 않는 경력입니다. 경력은 '신입'과 '경력'만 가능합니다.";
			}
			return msg;
			
		} // end of private String experience(int experience)-----------
	
	
	
	// 입력받은 경력 experience '신입', '경력'을 0,1으로 바꿔주는 메소드
	public static int experience(String experience) {
		
		int msg=0;
		
		if(experience.equals("신입")) {
			msg = 0;
		}
		else if(experience.equals("경력직")){
			msg = 1;
		}
		else {
			msg = -1;
		}
		return msg;
		
	} // end of public static void experience(String experience)-----
	
	
	
	// 입력받은 채용형태 emp_type 0,1,2,3을 '정규직', '계약직', '인턴', '프리랜서'으로 바꿔주는 메소드
	public static String empType(int emp_type) {
		
		String msg="";
		
		if(emp_type == 0) {
			msg = "정규직";
		}
		else if(emp_type == 1){
			msg = "계약직";
		}
		else if(emp_type == 2) {
			msg = "인턴";
		}
		else if(emp_type == 3) {
			msg = "프리랜서";
		}
		else {
			msg = "존재하지 않는 채용형태입니다. 채용형태은 '정규직', '계약직', '인턴', '프리랜서'만 가능합니다.";
		}
		return msg;
		
	} // end of public static String empType(int emp_type)------------

	

	// 입력받은 채용형태 emp_type '정규직', '계약직', '인턴', '프리랜서'을 0,1,2,3으로 바꿔주는 메소드
	public static int empType(String emp_type) {

		int msg=0;
		
		if(emp_type.equals("정규직")) {
			msg = 0;
		}
		else if(emp_type.equals("계약직")){
			msg = 1;
		}
		else if(emp_type.equals("인턴")) {
			msg = 2;
		}
		else if(emp_type.equals("프리랜서")) {
			msg = 3;
		}
		else {
			msg = -1;
		}
		return msg;
		
	} // end of public static int empType(String emp_type)----------------

	
	
	// 입력받은 연봉 salary int타입을 #,###만원 형태로 변환시켜주는 메소드
	public static String salary(int salary) {
		
		DecimalFormat df = new DecimalFormat("#,###");
		
		String s_salary = df.format(salary); // s 는 타입을 뜻한다
		
		return s_salary + "만원";
	} // end of public static String salary(int salary)-------------------
	
	
	// 입력받은 성별 int 타입을 '남', '여'로 변환해주는 메소드
	public static String gender(int genderType) {
		return genderType == 0 ? "남" : "여";
	}
	
	// int 타입인 회원 계정 상태를 반환 
	public static String memberStatus(int status) {
		String strStatus = null;

		switch (status) {
		case 0:
			strStatus = "탈퇴";
			break;
		case 1:
			strStatus = "가입";
			break;
		case 2:
			strStatus = "차단";
			break;
		default:
			break;
		}
		return strStatus;
	}
	

	private Transaction() {}
	
}
