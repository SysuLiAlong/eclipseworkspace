package mult.runnable;

public class Test {
	public static void main(String[] args) {
		Thread thread1 = new Thread(new Thread1(),"thread1");
		Thread thread2 = new Thread(new Thread2(),"thread2");
		thread1.start();
		thread2.start();
		
	}
}
class Thread1 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			System.out.println("currentThread:"+Thread.currentThread().getName()+" "+i);
		}
	}
	
}
class Thread2 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			System.out.println("currentThread:"+Thread.currentThread().getName()+" "+i);
		}
	}
	
}
