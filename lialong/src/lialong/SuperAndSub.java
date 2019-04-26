package lialong;

import java.util.Date;
public class SuperAndSub {
	public static void main(String[] args) {
		Sub sub = new Sub();
		sub.overrideMe();
	}
}
class Super {
	Super(){
		overrideMe();
	}
	public void overrideMe() {}
}
class Sub extends Super{
	private final Date date;
	Sub(){
		super();
		date = new Date();
		
	}
	public void overrideMe() {
		System.out.println(date);	
	}
}
