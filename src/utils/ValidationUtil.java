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
		
		// 비밀번호의 최대길이가 20글자를 넘어가면 false 반환
		if(passwd.isBlank() || passwd.length() > 20) {
			return false;
		}

		// 알파벳이 포함되어 있는지 확인
		regex = "[a-zA-Z]";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(passwd);

		if (!matcher.find()) {
			return false;
		}

		// 숫자가 포함되어 있는지 확인
		regex = "[0-9]";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(passwd);

		if (!matcher.find()) {
			return false;
		}

		// 특수문자가 포함되어 있는지 확인
		regex = "[^a-zA-Z0-9가-힣ㄱ-ㅎㅏ-ㅣ\\s]"; // 알파벳, 숫자, 한자, 공백을 제외한 문자는 특수문자로 간주
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(passwd);

		if (!matcher.find()) {
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
			System.out.println(">> [경고] 입력값은 대소문자 구분없이 y 또는 n으로 입력해야 합니다. <<\n");
			return false;
		}
		
		return true;
	}
	
	/*
	 * 문자열이 숫자인지 검사
	 */
	public static boolean isNumberValid(String number) {
		String regex = "[0-9]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(number);

		if (!matcher.find()) {
			System.out.println(">> [경고] 입력값은 숫자로 입력해야 합니다. <<\n");
			return false;
		}
		
		return true;
	}
}
