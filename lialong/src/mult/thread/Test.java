package mult.thread;

public class Test {
	public static void main(String[] args) {
		Thread1 thread1 = new Thread1();
		Thread2 thread2 = new Thread2();
		thread1.start();
		thread2.start();
	}
}
class Thread1 extends Thread{
	public void run(){
		for(int i=0;i<10;i++) {
			System.out.println("currentThread:"+Thread.currentThread().getName()+i);
		}
	}
}
class Thread2 extends Thread{
	public void run(){
		for(int i=0;i<10;i++) {
			System.out.println("currentThread:"+Thread.currentThread().getName()+i);
		}
	}
}

