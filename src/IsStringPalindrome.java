import java.util.stream.IntStream;

public class IsStringPalindrome {
	
	static boolean isPalindrome(String str) {
		str.replaceAll("\\s+", "");
		int length = str.length();
		return IntStream.range(0, length/2).noneMatch(i -> str.charAt(i) != str.charAt(length-1-i));
		
	}
	
	public static void main(String... args) {
		System.out.println("result is : "+ isPalindrome("aba"));
	}

}
