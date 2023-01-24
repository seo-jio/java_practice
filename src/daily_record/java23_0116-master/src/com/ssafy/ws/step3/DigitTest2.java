import java.util.Scanner;

public class DigitTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt=1;
		while(cnt <16) {
			for(int i=0; i<n/2+1; i++) {
				for(int j=0; j<i; j++) {
					System.out.print("\t");
				}
				
				for(int j=0; j<n-2*i; j++) {
					System.out.printf("%d\t", cnt);
					cnt++;
				}
				System.out.println();
			}
			for(int i=1; i<n/2+1; i++) {
				for(int j=0; j<n/2-i; j++) {
					System.out.print("\t");
				}
				
				for(int j=0; j<2*i+1; j++) {
					System.out.printf("%d\t", cnt);
					cnt++;
				}
				System.out.println();
			}
			
		}

	}

}
