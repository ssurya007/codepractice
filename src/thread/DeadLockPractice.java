package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class DeadLockPractice {

	static List<Thread> prepareThreadList() {
		List<Thread> threadList = new ArrayList<Thread>();
		Thread t1 = new Thread(()-> {
			synchronized (Integer.class) {
				sampleThread("thread 1 with int lock");
				System.out.println("thread 1 with int lock need string");
				synchronized(String.class) {
					sampleThread("thread 1 with int and string locks");
					System.out.println("thread 1 with int  and string lock");
				}
			}
			
		});
		
		Thread t2 = new Thread(()->{
			synchronized (String.class) {
				sampleThread("thread 2 with String lock need int");
				System.out.println("thread 2 with string lock");
				synchronized(Integer.class) {
					sampleThread("thread 2 with int and string locks");
					System.out.println("thread 2 with int and string lock");
				}
			}
		});
		
		threadList.add(t1);
		threadList.add(t2);
		return threadList;
				
	}

	private static void sampleThread(String name) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String... args) {
		List<Thread> threadList = prepareThreadList();
		threadList.get(0).start();
		threadList.get(1).start();
	}
}

class A1 {
	static B b;
	private static A1 a1;
	
	private static A1 getA1(B b) {
		synchronized (a1) {
			if(null != a1) {
				a1 = new A1();
			}
		}
		A1.b = b;
		
		return a1;
	}
	
	synchronized void sleepThread(String name) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

class B {
private static B b;
	
	private static B getB() {
		synchronized (b) {
			if(null != b) {
				b = new B();
			}
		}
		
		return b;
	}
	
	synchronized void sleepThread(String name) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}