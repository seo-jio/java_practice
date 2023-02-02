package com.ssafy.edu;

import java.io.Serializable;

//markup interface : 구현할 메소드가 없는 인터페이스
public class Grade implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7761666817282351063L; //serialVersionUID 설정
	/**
	 * 
	 */
	private int kor;
	private int eng;
	private int math;
	
	private static int nums; //안가
	private transient int tots = 3000; //못가
	
//	private final static long serialVersionUID = 3121656845L;
	
	@Override
	public String toString() {
		return "Grade [kor=" + kor + ", eng=" + eng + ", math=" + math + ", tots=" + tots + ", nums=" + nums + "]";
	}

	public Grade() {
		this(0, 0, 0);
	}

	public Grade(int kor, int eng, int math) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		nums = 2005; //생성자에서 동적으로 static 변수를 할당해야한다. 그래야 read test에서 올바르게 출력됨
	}

	
	
	public int getTotal() {
		return kor+eng+math;
	}
	
	public double getAvg() {
		return this.getTotal() / 3.0;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
	
	
	
}
