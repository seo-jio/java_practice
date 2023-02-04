package forTest;

public class Test6 {

	public static void main(String[] args) {
		A a=new B("T");
		a.say();
		System.out.println(a.ss);
		String s="hello";
		System.out.println(s.toString());
		String aa="hello";
		String bb="hello";
		String cc=new String ("hello");
		System.out.println(aa==bb);
		System.out.println(aa.equals(bb));
		System.out.println(aa==cc);
		System.out.println(aa.equals(cc));
	}

}
