import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class BubbleSort {
	
	public static List<Comparable<Object>> sort(List<Comparable<Object>> unsortedList) {
		int listSize = unsortedList.size();
		boolean[] isSorted = {true};
		for(int a = 0; a < listSize ; a++) {
			for (int i = 0; i < listSize-a-1; i++) {
				Comparable<Object> ithElement = unsortedList.get(i);
				Comparable<Object> iPlusOnethElement = unsortedList.get(i+1);
				if(ithElement.compareTo(iPlusOnethElement) > 0) {
					unsortedList.set(i, iPlusOnethElement);
					unsortedList.set(i+1, ithElement);
					isSorted[0] = false;
				}
			};
			if(isSorted[0]) {
				return unsortedList;
			}
			isSorted[0] = true;
		};
		return unsortedList;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String... args) throws InterruptedException, ExecutionException {
		List<Comparable<Object>> unSortedList = new ArrayList<Comparable<Object>>();
		unSortedList.add((Comparable)10);
		unSortedList.add((Comparable)30);
		unSortedList.add((Comparable)20);
		List<Comparable<Object>> sortedList = sort(unSortedList);
		System.out.println(sortedList);
	}
}
