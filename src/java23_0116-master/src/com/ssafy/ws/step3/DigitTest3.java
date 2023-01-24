import java.util.Scanner;

public class DigitTest3 {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
		System.out.println();
		System.out.println("5판3승");
		System.out.println("3판2승");
		System.out.println("1판1승");
		System.out.println();
		System.out.print("번호를 입력하세요.");
		int num = sc.nextInt();
		int round;
		
		switch(num) {
		case 1:
			round = 5;
			System.out.println(play(5));
			break;
		case 2:
			round =3;
			System.out.println(play(3));
			break;
		case 3:
			round = 1;
			System.out.println(play(1));
			break;
		}
		
	}
	
	public static String play(int round) {
		int win = 0;
		int loose = 0;
		String ans = "### 승자가 없이 비겼습니다!!!";
		for(int i=0; i<round; i++) {
			int csNum = (int)(Math.random()*3)+1;
			
			System.out.print("가위바위보 중 하나 입력:");
			String s = sc.next();
			if(s.equals("가위")) {
				if(csNum == 1) {
					System.out.println("비겼습니다!!!");
				}else if(csNum == 2) {
					System.out.println("졌습니다!!!");
					loose++;
				}else {
					System.out.println("이겼습니다!!!");
					win++;
				}
			}else if(s.equals("바위")) {
				if(csNum == 1) {
					System.out.println("이겼습니다!!!");
					win++;
				}else if(csNum == 2) {
					System.out.println("비겼습니다!!!");
				}else {
					System.out.println("졌습니다!!!");
					loose++;
				}
			}else {
				if(csNum == 1) {
					System.out.println("졌습니다!!!");
					loose++;
				}else if(csNum == 2) {
					System.out.println("이겼습니다!!!");
					win++;
				}else {
					System.out.println("비겼습니다!!!");
				}
			}
			
			if(win >= round/2+1) {
				ans = "### 사용자 승!!!";
				return ans;
			}else if(loose >= round/2+1) {
				ans = "### 컴퓨터 승!!!";
				return ans;
			}
		}
		return ans;
	}

}
