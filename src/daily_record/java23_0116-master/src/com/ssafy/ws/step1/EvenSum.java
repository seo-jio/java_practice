import java.util.Scanner;

public class EvenSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력 >> ");
		int n = sc.nextInt();
		
		int s = 0;
		for(int i=1; i<=n; i++) {
			if(i%2==0) {
				s += i;
			}
		}
//		for(int i=2; i<=n; i+=2) {
//			s += i;
//		}
		System.out.println("1부터 " + n + "까지 수 중 짝수의 합 = " + s);
	}

}
