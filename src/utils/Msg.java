package utils;

public class Msg {
	public static void W(String msg){
		System.out.println(">> [경고] " + msg + " <<\n");
	}
	
	public static void N(String msg){
		System.out.println(">> " + msg + " <<\n");
	}
	
	private Msg() {}
}
