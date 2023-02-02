package com.ssafy.ws.test;

import java.util.Comparator;

public class GradeComp implements Comparator<Grade> {

	@Override
	public int compare(Grade o1, Grade o2) {
//		return o1.getTotal() - o2.getTotal(); //int 범위를 벗어날 수도 있으므로 밑에 방법 사용
		int tot = Integer.compare(o1.getTotal(), o2.getTotal()); //빼서 음수면 오름차순, 양수면 내림차순
		if(tot == 0) {
			return Integer.compare(o1.getKor(), o2.getKor()); //total 점수가 같으면 국어 점수로 비교
		}else return tot;
	}

}
