package lialong;

public class SingtletonDemo2 {
	public static SingtletonDemo2 instance = new SingtletonDemo2();
	private SingtletonDemo2() {};
	public static SingtletonDemo2 getSingtletonDemo2() {
		return instance;
	}
}
