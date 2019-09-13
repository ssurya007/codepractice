package thread;

public class ThreadPractice {
	static A a = new A();
	static Thread createThread1(String name) {
		return new Thread(() -> {
			System.out.println("executing thread "+ name);
			a.m1();
			try {
				System.out.println("before wait "+ name);
				synchronized (a) {
					a.wait();	
				}
				System.out.println("after wait "+ name);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	}
	
	static Thread createThread2(String name) {
		return new Thread(() -> {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("executing thread "+ name);
			a.m1();
			System.out.println("before notify "+ name);
			synchronized(a){
				a.notify();
			}
			System.out.println("after notify "+ name);
		});
	}
	
	public static void main(String args[]) {
		Thread t1 = createThread1("thread 1");
		Thread t2 = createThread2("thread 2");
		
		t1.start();
		t2.start();
	}

}

class A {
	synchronized public void m1() {
		
	}
}
