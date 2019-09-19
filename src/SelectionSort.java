import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;

public class SelectionSort {
	public static List<Comparable<Object>> sort(List<Comparable<Object>> inputList) {
		IntStream.range(0, inputList.size()).forEach(i -> {
			int minIndex = findMinValue(inputList,i);
			swap(inputList, i, minIndex);
		});
		return inputList;
	}

	private static void swap(List<Comparable<Object>> inputList, int i, int minIndex) {
		Comparable<Object> tempValue = inputList.get(i);
		inputList.set(i, inputList.get(minIndex));
		inputList.set(minIndex, tempValue);		
	}

	private static int findMinValue(List<Comparable<Object>> inputList, int i) {
		Comparable<Object> minVlaue = inputList.get(i);
		int minIndex = i;
		for(int x = i+1; x < inputList.size(); x++) {
			Comparable<Object> currentValue = inputList.get(x);
			if(currentValue.compareTo(minVlaue) < 0) {
				minVlaue = currentValue;
				minIndex = x;
			}
		}
		return minIndex;
				
	}
	
	public static void main(String... args) throws InterruptedException, ExecutionException {
		List<Comparable<Object>> unSortedList = new ArrayList<Comparable<Object>>();
		unSortedList.add((Comparable)"xxx");
		unSortedList.add((Comparable)"aaa");
		unSortedList.add((Comparable)"bbb");
		System.out.println("sorted list is : "+ sort(unSortedList));
	}


}
