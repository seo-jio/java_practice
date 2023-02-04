package forTest;

public class Test5 {

	public static void main(String[] args) {

		// 이름이 붙은 for문으로 기존 하나의 반복문만 벗어날 수 있던 break문을 개선하기 위해 등장
		// for문 앞에 이름을 붙이고 break or contiue문 뒤에 이름을 적어준다.
		int sum=0;
		a: for (int i = 0; i < 10; i++) {
			for (int j =i+1; j < 10; j++) {
				sum+=j;
				if(j==5) break a;
			}
		}
		System.out.println(sum); // 15

	}

}
