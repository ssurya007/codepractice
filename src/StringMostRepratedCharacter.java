import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.text.html.parser.Entity;

public class StringMostRepratedCharacter {
	
	static Map<Character, Integer> getCharactersCount(String str) {
		Map<Character , Integer> countMap = new LinkedHashMap<Character, Integer>();
		str.chars().mapToObj(c -> (char)c).collect(Collectors.toList()).stream().forEach(c -> countMap.merge(c,1,Integer::sum));
		return countMap;
	}

	static char getMostRepeatedCharacter(String str) {
		Map <Character, Integer> characterCountMap = getCharactersCount(str);
		int maxCount = characterCountMap.entrySet().stream().map(entry -> entry.getValue()).collect(Collectors.maxBy(Comparator.reverseOrder())).get();
		 return characterCountMap.entrySet().stream().filter(entry -> entry.getValue().equals(maxCount) ).map(entry-> entry.getKey()).findFirst().get();
	}
	
	public static void main(String... args) {
		char c = getMostRepeatedCharacter("aabbbccca");
		System.out.println("most repeated character is : "+ c);
	}
}
