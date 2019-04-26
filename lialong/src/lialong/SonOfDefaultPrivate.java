package lialong;

public class SonOfDefaultPrivate extends DefaultPrivateDemo {
	public String son;
	public static void main(String[] args) {
		SonOfDefaultPrivate sdp = new SonOfDefaultPrivate();
		System.out.println(sdp.pub);
		System.out.println(sdp.def);
	}
}
