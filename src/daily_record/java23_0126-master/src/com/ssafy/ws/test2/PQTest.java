package com.ssafy.ws.test2;

import java.util.PriorityQueue;

public class PQTest {

	public static void main(String[] args) {
		//우선순위 큐는 제네릭으로 들어간 클래스의 Comparable의 compareTo를 사용하여 자동으로 정렬한다.
		PriorityQueue<Grade> pq = new PriorityQueue<>();
		pq.offer(new Grade(60, 80, 90));
		pq.offer(new Grade(70, 80, 90));
		pq.offer(new Grade(80, 90, 100));
		pq.offer(new Grade(100, 100, 90));
		pq.offer(new Grade(80, 60, 90));
		
		while(!pq.isEmpty()){
			Grade g = pq.poll(); //우선순위 큐에서 젤 위에 껄 빼는 기능
			System.out.println(g);
		}
	}

}
