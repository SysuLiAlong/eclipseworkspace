package lialong;

public class DefaultPrivateDemo {
	private String pri;
	String def;
	public String pub;
	protected String pro;
	public DefaultPrivateDemo() {
		// TODO Auto-generated constructor stub
		pri = "pri";
		def = "def";
		pub = "pub";
		pro = "pro";
	}
	public void pub() {
		System.out.println(this.pub);
	}
	void def() {
		System.out.println(this.def);
	}
	private void pri() {
		System.out.println(this.pri);
	}
}
