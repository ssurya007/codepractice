
public class Fibonacci {
	
	StringBuilder finalString = new StringBuilder("01");
	void m1(int limit) {
		int nextInt = getNext();
		if(nextInt < limit) {
			finalString.append(nextInt);
			m1(limit);
		} else {
			System.out.println("final string : "+finalString);
		}
			
	}

	private int getNext() {
		String subStr = finalString.substring(finalString.length()-2);
		int a = Integer.parseInt(subStr.substring(0,1));
		int b = Integer.parseInt(subStr.substring(1));
		return a+b;
		
	}

	public static void main(String args[]) {
		Fibonacci fibonacci = new Fibonacci();
		fibonacci.m1(16);
	}
}
