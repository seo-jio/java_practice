package com.ssafy.edu;

import java.util.Arrays;

//nPr => 서로 다른 n개에서 서로 다른  r개를 선택 후 나열
//5P3 = 5*4*3
public class PermTest {
	static int[] p = {1, 2, 3, 4, 5};
	static int N=p.length;
	static int R;
	static boolean[] visited;
	static int[] nums;
	static int count;
	
	public static void main(String[] args) {
		R=3;
		visited = new boolean[N];
		nums = new int[R];
		count = 0;
		//----------------------
		
		perm(0); //재귀 -> 자신이 자신 호출 -> while -> dfs -> 종료조건 명시
		System.out.println(count);
	}
	
	static void perm(int depth) {
		if(depth == R) {
			System.out.println(Arrays.toString(nums));
			count++;
			return;
		}
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			nums[depth] = p[i];
			perm(depth+1);
			nums[depth] = 0;
			visited[i] = false;
		}
	}

}
