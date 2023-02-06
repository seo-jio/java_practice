package forTest;

public class Test6 {

	public static void main(String[] args) {
		A a=new B(); // A -> C -> B
		a.say(); // overriding 된 메소드가 호출 됨
		System.out.println(a.s); // 선언한 클래스 타입의 멤버 변수가 호출 됨
		String s="hello";
		System.out.println(s.toString()); // println()은 String을 인자로 받을 때 자동으로 toString()을 호출한다.

		String aa="hello"; // string pool에 존재
		String bb="hello"; // string pool에 존재
		String cc=new String ("hello"); // heap 영역에 존재
		System.out.println(aa==bb); //true
		System.out.println(aa.equals(bb)); //true
		System.out.println(aa==cc); //false
		System.out.println(aa.equals(cc)); //true
	}

}
