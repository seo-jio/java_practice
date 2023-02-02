package com.ssafy.ws.test;

public class Grade {
	private int kor;
	private int eng;
	private int math;
	
	public Grade() {
		this(0, 0, 0);
	}

	public Grade(int kor, int eng, int math) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	@Override
	public String toString() {
		return "Grade [kor=" + kor + ", eng=" + eng + ", math=" + math + 
				", tot= " + getTotal() + ", avg= " + getAvg() + "]";
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
