package com.ssafy.ws.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GradeTest {

	public static void main(String[] args) {
		List<Grade> grades = new ArrayList<>();
		grades.add(new Grade(60, 80, 90));
		grades.add(new Grade(70, 80, 90));
		grades.add(new Grade(80, 90, 100));
		grades.add(new Grade(100, 100, 90));
		grades.add(new Grade(80, 60, 90));
		
		for(Grade g : grades) {
			System.out.println(g); //넣은 순서대로 출력 됨
		}
		System.out.println("=============================");
		//anonymous class => lambda(functional programming)
		//람다 사용 시 () 사용하면 return 생략 가능
//		grades.sort((o1, o2) -> (Integer.compare(o1.getTotal(), o2.getTotal())));
		grades.sort((o1, o2) -> {
						int tot = -Integer.compare(o1.getTotal(), o2.getTotal()); //빼서 음수면 오름차순, 양수면 내림차순
						if(tot == 0) {
							return -Integer.compare(o1.getKor(), o2.getKor()); //total 점수가 같으면 국어 점수로 비교
						}else return tot;
					});
		for(Grade g : grades) {
			System.out.println(g);
		}
		
	}

}
