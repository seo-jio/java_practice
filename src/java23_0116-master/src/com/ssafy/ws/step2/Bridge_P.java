import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bridge_P {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int[][] grid;
	static int[] dxs= {-1, 1, 0, 0};
	static int[] dys = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException{
		n = Integer.parseInt(br.readLine());
		
		grid = new int[n][n];
		for(int i=0; i<n; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<s.length; j++) {
				grid[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		int maxDis = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(grid[i][j] == 0) continue;
				
				for(int d=1; d<n-j; d++) {
					if(grid[i][j+d] == 1) {
						maxDis = Math.max(maxDis, d);
						break;
					}
				}
				
				for(int d=1; d<j; d++) {
					if(grid[i][j-d] == 1) {
						maxDis = Math.max(maxDis, d);
						break;
					}
				}
				
				for(int d=1; d<n-i; d++) {
					if(grid[i+d][j] == 1) {
						maxDis = Math.max(maxDis, d);
						break;
					}
				}
				
				for(int d=1; d <i; d++) {
					if(grid[i-d][j] == 1) {
						maxDis = Math.max(maxDis, d);
						break;
					}
				}	
			}
		}
		System.out.println(maxDis);
	}

}
