package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlignUtil {
	
	private AlignUtil() {}
	
	public static String title(String titleStr) { // 자동 50칸 타이블 바
		String resultStr = title(titleStr, 50);
		return resultStr;
	}
	
	public static String title(String titleStr, int n) { // 직접 타이틀 바 수 설정
		
		String resultStr = "";
		
		String bar = "";
		int align = 0; // 0:왼쪽정렬, 1:중앙정렬
		
		if(titleStr.startsWith("-")) {
			bar = "-";
			align = 0;
		}
		else if(titleStr.startsWith("=")) {
			bar = "=";
			align = 1;
		}
		titleStr = titleStr.substring(1);
		double cnt = countStr(titleStr);
		
		if(align == 0) {
			resultStr = bar.repeat(1)
					+ "< "+titleStr+" >"
					+ bar.repeat((int)Math.floor(n-6-cnt));
		}
		else {
			resultStr = bar.repeat((int)Math.floor(n/2-2-cnt/2))
					+ "< "+titleStr+" >"
					+ bar.repeat((int)Math.ceil(n/2-2-cnt/2));
		}
		
		return resultStr + "\n";
	}
	
	public static StringBuilder tab(StringBuilder sb) {
		
		sb.append("\\\\"); // 마지막 문자로 사용
		String beforeStr = sb.toString();
		
		String[] strArr =  beforeStr.split("\t");
		
		StringBuilder resultSb = new StringBuilder();
		
		for(int i=0; i<strArr.length; i++) {
			if(strArr[i].isEmpty()) {
				continue;
			}
			else if(strArr[i].endsWith("\\\\")) { // 마지막 문자로 사용
				resultSb.append(strArr[i].split("\\\\")[0]);
				continue;
			}
			else if(strArr[i].contains("\n")) {
				int lastIdx = strArr[i].lastIndexOf("\n");
				resultSb.append(strArr[i].substring(0, lastIdx+1));
				strArr[i] = strArr[i].substring(lastIdx+1);
			}
			
			// 반복문 돌려서 뒤에 나오는 문자열이 빈칸인지 확인
			int tabCount = 1;
			for(int j = i+1; j<strArr.length; j++) {
				if(strArr[j].isEmpty()) {
					tabCount++;
				}
				else {
					break;
				}
			}
			
			double d = countStr(strArr[i]);
			
			int tab = tabCount-(int) Math.floor(d/8.0);
			if(tab<0) {
				tab = 1;
			}
			
			resultSb.append(strArr[i] + "\t".repeat(tab));
		}
		return resultSb;
	}
	
	private static double countStr(String str) {
		String regex = "[가-힣ㄱ-ㅎㅏ-ㅣ]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		double cnt = 0.0;
		
		while (matcher.find()) {
			cnt = cnt+1.334;
		}

		regex = "[^가-힣ㄱ-ㅎㅏ-ㅣ]";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(str);
		while (matcher.find()) {
			cnt = cnt+1.0;
		}
		
		return cnt;
	}
}
