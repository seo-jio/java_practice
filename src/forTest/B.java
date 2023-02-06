package forTest;

public class B extends A {
	String s = "BBB";
	public B() {
//		this("C");
		System.out.println("B");
	}

	public B(String h) {
		System.out.println(h);
	}
	public void say() {
		System.out.println(s);
	}
}
