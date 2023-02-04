package forTest;

public class Test2 {

	public static void main(String[] args) {
		
		int a=10;
		int b=20;
		if(++a>10 || b++<20) {     // shortcut 발생 O, false, a : 11 / b : 20
			System.out.println("Case 1");
			System.out.println(a);
			System.out.println(b);
		}

		if(++a>10 | b++<20) {      // shortcut 발생 X, false, a : 12 / b : 21
			System.out.println("Case 2");
			System.out.println(a);
			System.out.println(b);
		}
		if(++a<10 && b++<20) {     // shortcut 발생 O, a : 11, b : 20
			System.out.println("Case 3");
			System.out.println(a);
			System.out.println(b);
		}
	}

}
