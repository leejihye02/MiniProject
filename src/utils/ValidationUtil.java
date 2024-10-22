package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * 입력값에 대한 유효성을 확인하는 유틸 클래스
 */
public class ValidationUtil {

	private ValidationUtil() {}

	/*
	 * 비밀번호 유효성 검사 메소드 
	 * 대소문자 구분 없는 영문자와 숫자, 특수문자가 포함되어 있는지 확인
	 * 비밀번호의 최대길이는 20글자
	 * 비밀번호 공백 검사 
	 * 유효하면 true, 유효하지 않으면 false 반환
	 */
	public static boolean isPasswordValid(String passwd) {
		Pattern pattern = null;
		String regex = null;
		Matcher matcher = null;
		
		// 비밀번호가 공백, 비밀번호의 길이가 8글자 미만, 20글자 초과면 false 반환
		if(passwd.isBlank() || passwd.length() < 8 || passwd.length() > 20) {
			Msg.W("비밀번호는 공백으로 입력할 수 없으며, 8글자 이상, 20글자 이하여야 합니다.");
			return false;
		}

		// 알파벳이 포함되어 있는지 확인
		regex = "[a-zA-Z]";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(passwd);

		if (!matcher.find()) {
			Msg.W("비밀번호에 영문이 반드시 포함되어야 합니다.");
			return false;
		}

		// 숫자가 포함되어 있는지 확인
		regex = "[0-9]";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(passwd);

		if (!matcher.find()) {
			Msg.W("비밀번호에 숫자가 반드시 포함되어야 합니다.");
			return false;
		}

		// 특수문자가 포함되어 있는지 확인
		regex = "[^a-zA-Z0-9가-힣ㄱ-ㅎㅏ-ㅣ\\s]"; // 알파벳, 숫자, 한자, 공백을 제외한 문자는 특수문자로 간주
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(passwd);

		if (!matcher.find()) {
			Msg.W("비밀번호에 특수문자가 반드시 포함되어야 합니다.");
			return false;
		}
		
		return true;
	}
	
	/*
	 * 아이디 유효성 검사 메소드 
	 * 아이디의 길이는 5글자 이상, 20글자 이하
	 * blank를 허용하지 않음
	 * 아이디는 영문, 숫자로만 이뤄져야 한다.
	 * 조건을 만족하면 true, 아니면 false 반환
	 */
	public static boolean isIDValid(String id) {
		Pattern pattern = null;
		String regex = null;
		Matcher matcher = null;
		
		// 공백, 5글자 미만, 20초과면 false 반환
		if (id.isBlank() || id.length() < 5 || id.length() > 30) {
			Msg.W("아이디는 공백으로 입력할 수 없으며, 5글자 이상 30글자 이하여야 합니다.");
			return false;
		}

		// 영문, 숫자로만 이루어져있지 않으면 false 반환
		regex = "[^a-zA-Z0-9]"; // 알파벳, 숫자, 한자, 공백을 제외한 문자는 특수문자로 간주
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(id);

		if (matcher.find()) {
			Msg.W("아이디는 영문 또는 숫자만 입력 가능합니다.");
			return false;
		}
		
		return true;
	}

	/*
	 * 이메일 유효성 검사 메소드 
	 * 성명의 길이는 40글자 이하
	 * blank를 허용하지 않음
	 * @가 포함되어야 함
	 * 조건을 만족하면 true, 아니면 false 반환
	 */
	public static boolean isEmailValid(String email) {
		Pattern pattern = null;
		String regex = null;
		Matcher matcher = null;
		
		// 공백, 40글자 초과면 false 반환
		if (email.isBlank() || email.length() > 40) {
			Msg.W("아이디는 공백으로 입력할 수 없으며, 5글자 이상 30글자 이하여야 합니다.");
			return false;
		}
		
		// 이메일에 @가 없으면 false
		regex = "[@]"; // 알파벳, 숫자, 한자, 공백을 제외한 문자는 특수문자로 간주
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(email);

		if (!matcher.find()) {
			Msg.W("이메일은 id@example.com 형식으로 입력해야 합니다.");
			return false;
		}
		
		return true;
	}
	
	/*
	 * 연락처 유효성 검사 메소드
	 * XX-XXX-XXXX
	 * XX-XXXX-XXXX
	 * XXX-XXX-XXXX
	 * XXX-XXXX-XXXX 형식이어야 함
	 * 조건에 맞지 않으면 false
	 */
	public static boolean isTelValid(String tel) {
		Pattern pattern = null;
		String regex = null;
		Matcher matcher = null;
		
		// 연락처 형식에 맞지 않으면 false
		regex = "^\\d{2,3}-\\d{3,4}-\\d{4}$"; // 알파벳, 숫자, 한자, 공백을 제외한 문자는 특수문자로 간주
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(tel);

		if (!matcher.find()) {
			Msg.W("연락처는 XXX-XXXX-XXXX 형식으로 입력해야 합니다.");
			return false;
		}
		
		return true;
	}

	/*
	 * Y or N 입력값에 대한 검사
	 * 대소문자 구분 없음
	 * 유효하면 true, 유효하지 않으면 false 반환
	 */
	public static boolean isYNValid(String yn) {
		// y 또는 n 이 아닌 경우 경고 문구 출력
		if(!("y".equalsIgnoreCase(yn) || "n".equalsIgnoreCase(yn))) {
			Msg.W("입력값은 대소문자 구분없이 y 또는 n으로 입력해야 합니다.");
			return false;
		}
		
		return true;
	}
	
	/*
	 * 문자열이 숫자로만 이루어져 있는지 검사
	 */
	public static boolean isNumberValid(String number) {
		boolean valid = true;
		String regex = "[0-9]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(number);

		// 숫자가 전혀 포함되지 않는 경우
		if (!matcher.find()) {
			valid = false;
		}
		
		// 숫자가 아닌 문자가 포함된 경우
		regex = "[^0-9]";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(number);
		
		if(matcher.find()) {
			valid = false;
		}
		
		if(!valid) {
			Msg.W("입력값은 숫자로 입력해야 합니다.");
		}
		
		return valid;
	}
}
