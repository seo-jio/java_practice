import java.util.Scanner;

public class Season1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p = 3;
		int i=0;
		while(i<3) {
			System.out.print("월 입력>>");
			int n = sc.nextInt();
			switch(n) {
			case 3:
			case 4:
			case 5:
				System.out.println(n +"월은 봄입니다.");
				break;
			case 6:
			case 7:
			case 8:
				System.out.println(n +"월은 여름입니다.");
				break;
			case 9:
			case 10:
			case 11:
				System.out.println(n +"월은 가을입니다.");
				break;
			case 12:
			case 1:
			case 2:
				System.out.println(n +"월은 여름입니다.");
				break;
			}
			i++;
		}
	}

}
