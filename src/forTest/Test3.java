package forTest;

public class Test3 {

	public static void main(String[] args) {
		// 해당 case문 부터 break나 switch case문이 끝나는 지점까지 내려감
		// default문은 일치하는 case가 없는 경우에만 수행(무조건 수행X)
		int a=10;
		switch (a) {
			case 10: System.out.println("hello");
			case 20: System.out.println("allo");
				break;
			default:
				System.out.println("bello");
				break;
		}
		System.out.println("-");
		a=20;
		switch (a) {
			default:
				System.out.println("bello");
			case 10: System.out.println("hello");
			case 20: System.out.println("allo");
				break;
		}

	}

}
