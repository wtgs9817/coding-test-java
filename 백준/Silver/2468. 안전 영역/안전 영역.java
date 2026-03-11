import java.util.*;
import java.io.*;


public class Main {
	//상 하 좌 우
	static int[] X = {0,0,-1,1};
	static int[] Y = {-1,1,0,0};
	
	static int n;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		
		int result = 0;
		int max = 0;
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int k=0; k<n; k++) {
				map[i][k] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][k]);
			}
		}
		
		for(int a = 0; a<=max; a++) {
			visited = new boolean[n][n];
			int cnt = 0;
			for(int i=0; i<n; i++) {
				
				for(int k=0; k<n; k++) {
					if(!visited[i][k] && map[i][k] > a) {
						safeArea(i, k, a);
						cnt++;
					}
				}		
			}
			result = Math.max(result, cnt);
		}
		System.out.println(result);
 	}
	
	static void safeArea(int y, int x, int h) {
		visited[y][x] = true;
		
		for(int i=0; i<4; i++) {
			int dy = y + Y[i];
			int dx = x + X[i];
			
			if(dy < 0 || dy >= n || dx < 0 || dx >= n) continue;
			if(visited[dy][dx] || map[dy][dx] <= h) continue;
			
			safeArea(dy, dx, h);
		}
	}
}