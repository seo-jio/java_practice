package forTest;

public class Test7 {
	public static void main(String[] args) {
		Object o1=new Object();
		Object o2=new String();
		String o3=new String();
		
		if(o1 instanceof Object) {
			System.out.println("1");
		}
		if(o1 instanceof String) {
			System.out.println("2");
		}
		if(o2 instanceof Object) {
			System.out.println("3");
		}
		if(o2 instanceof String) {
			System.out.println("4");
		}
		
	}
}
