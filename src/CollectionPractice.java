import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class CollectionPractice {
	
	static List<String> removeDuplicates(List<String> al) {
		Set<String> tempSet = new LinkedHashSet<String>(al);
		al = new ArrayList<String>(tempSet);
		return al;
	}
	
	static void reverseList(List<String> al) {
		int length = al.size();
		IntStream.range(0, length/2).forEach(i -> {
			String temp = al.get(length-1-i);
			al.set(length-1-i,al.get(i));
			al.set(i,temp);
		});
	}
	
	public static void main(String... args) {
		String [] array = {"sss", "sss", "aaa", "xxx"};
		List<String> inputList = Arrays.asList(array);
		reverseList(inputList);
		System.out.println(inputList);
	}

}
