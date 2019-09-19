import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;

public class InsertionSort {
	public static List<Comparable<Object>> sort(List<Comparable<Object>> unsortedList) {
		int listSize = unsortedList.size();
		List<Comparable<Object>> sortedList = new ArrayList<Comparable<Object>>();
		IntStream.range(0, listSize).forEach(i -> {
			Comparable<Object> insertoinElement = unsortedList.get(i);
			sortedList.add(insertoinElement);
			int x = sortedList.size();
			
			
			while(x >= 2) {
				Comparable<Object> oneLessThanXthElement = sortedList.get(x-1);
				Comparable<Object> twoLessThanXthElement = sortedList.get(x-2);
				boolean swapped = false;
				if (oneLessThanXthElement.compareTo(twoLessThanXthElement) < 0) {
					swap(sortedList, x, oneLessThanXthElement, twoLessThanXthElement);
					x--;
					swapped = true;
				}
				if(!swapped) break;
			}
		});
		return sortedList;
	}
	
	private static void swap(List<Comparable<Object>> sortedList, int x, Comparable<Object> oneLessThanXthElement, Comparable<Object> twoLessThanXthElement) {
		sortedList.set(x-1, twoLessThanXthElement);
		sortedList.set(x-2, oneLessThanXthElement);
		
	}

	public static void main(String... args) throws InterruptedException, ExecutionException {
		List<Comparable<Object>> unSortedList = new ArrayList<Comparable<Object>>();
		unSortedList.add((Comparable)"xxx");
		unSortedList.add((Comparable)"aaa");
		unSortedList.add((Comparable)"bbb");
		System.out.println("sorted list is : "+ sort(unSortedList));
	}

}
