public class Direction {
	static int[][] grid;
	static int[] dxs = {-1, 1, 0, 0};
	static int[] dys = {0, 0, -1, 1};
	static int n = 3;
	public static void main(String[] args) {
		grid = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int r=1;
		int c=1;
		for(int i=0; i<4; i++) {
			int nx = r + dxs[i];
			int ny = c + dys[i];
			if(!inRange(nx, ny)) continue;
			System.out.print(grid[nx][ny] + " ");
		}
	}
	
	public static boolean inRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n; 
	}

}
