package forTest;

public class Test1 {

	public static void main(String[] args) {
		// 형변환 조심
		byte a=10;
		byte b=20;
		byte c=(byte)(a+30);    // byte short 의 변수는 int type
		//byte c2=(byte)(a)+30; // error???
		byte d=10+20;
		// 형변환 프로모션 <--> 캐스팅
		// 형변환 x;
		//boolean e=a;
		long f=Integer.MAX_VALUE+10;  //쓰레기, 이미 연산에서 overflow가 발생한 값을 long형에 넣기 때문
		long g=10L+Integer.MAX_VALUE; //정상 작동, 연산 중 long 형으로 자동 캐스팅
		int h=(int)g; //정상 작동하지만 값의 손실이 있을 수 있음
		float i=3.5f; //실수는 기본형이 double 형이기 때문에 float 사용시 f를 붙여줌
		double j=i; //float -> double, 묵시적 형변환 발생
		
		char k='A'; //
		char l=k;
		int m=k;
		char n=(char)('A'+4);
		char y = 97;
		System.out.printf("%c, %c, %d, %c, %c", k, l, m, n, y);
		
		// 박싱 언박싱 
		int o=10;
		Integer p=o; //박싱, to Wrapper class
		int q=p;     // 언박싱
		
		Object r=o;
		int s=(int)r;
		
		boolean[] bools; //배열의 생성과 선언을 분리할 때는 new 키워드 필수!
//		bools = {true, false, true};
		
		
	}

}
