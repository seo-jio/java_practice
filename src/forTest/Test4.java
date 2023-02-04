package forTest;

public class Test4 {

	public static void main(String[] args) {
		int sum=0;
		int a=0;
		while(a<=10) {
			sum+=a++;
		}
		System.out.println(sum); // 55
		
		sum=0;
		for (int i = 0; i < 11; i++) {
			sum+=i;
		}
		System.out.println(sum); // 55


		// for문 사용 시 여러 변수를 초기화 할 수 있고, 여러 조건을 걸 수도 있으며, 증감식은 for문 안에 넣어줄수있다.
		sum=0;
		int j=0;
		for (int k=2,l=3; j < 11 && k<6;  ) {
			sum+=j++;
			k++;
		}
		System.out.println(sum); // 6
		
	}

}
