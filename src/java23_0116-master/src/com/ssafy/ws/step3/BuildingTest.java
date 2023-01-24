import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BuildingTest {
	static String[][] grid;
	static int[] dxs = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dys = {0, 0, 1, 1, 1, 0, -1, -1, -1};
	static int T;
	static int N;
	static int max;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<T+1; tc++) {
			N = Integer.parseInt(br.readLine());
			grid = new String[N][N];
	
			for(int i=0; i<N; i++) {
				grid[i] = br.readLine().split(" ");
			}
			max = -1;
			int temp_count = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(isPossible(i, j)) {
						temp_count = count(i, j);
					} else {
						temp_count = 2;
					}
					max = Math.max(max,  temp_count);
				}
			}
			System.out.printf("#%d %d", tc, max);
			System.out.println();
		}
	}
	
	public static boolean inRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
	
	public static boolean isPossible(int x, int y) {
		int flag = 1;
		for(int k=0; k<9; k++) {
			int nx = x + dxs[k];
			int ny = y + dys[k];
			if(!inRange(nx, ny)) continue;
			if(grid[nx][ny].equals("G")) {
				flag = 0;
			}
		}
		
		if(flag == 1) return true;
		return false;
	}
	
	public static int count(int x, int y) {
		int count = 0;
		for(int i=0; i<N; i++) {
			if(grid[x][i].equals("B")) count++;
		}
		for(int i=0; i<N; i++) {
			if(grid[i][y].equals("B")) count++;
		}
		return count-1;
	}
}
