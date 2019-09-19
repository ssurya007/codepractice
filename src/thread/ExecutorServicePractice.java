package thread;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServicePractice {
	
	static List<Callable<Object>> prepareCallableList() {
		List<Callable<Object>> taskList = new ArrayList<Callable<Object>>();
		taskList.add(()->{
			sampleThread("thread 1");
			return "thread 1";
		});
		
		taskList.add(()->{
			sampleThread("thread 2");
			return "thread 2";
		});
		return taskList;
	}

	private static void sampleThread(String name) throws InterruptedException {
		System.out.println("before thread");
		Thread.sleep(2000);
		System.out.println("after sleep");
		
	}
	
	public static void main(String... args) throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newFixedThreadPool(10);
		List<Callable<Object>> taskList = prepareCallableList();
		List<Future<Object>> finalsList = null;
		try {
			finalsList = es.invokeAll(taskList);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("results : "+ finalsList.get(0).get().toString());
	}
}
