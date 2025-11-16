import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	
	
	public static int N;
	public static int[][] arr;
	public static boolean[][] visited;
	
	//상 하 좌 우
	public static int[] X = {0, 0, -1, 1};
	public static int[] Y = {-1, 1, 0, 0};
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int max = 0;
		
		arr = new int[N][N];
		int answer = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0; k<N; k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
				max = Math.max(max,arr[i][k]);
			}
		}
		
		for(int i=0; i<=max; i++) {
			int cnt = 0;
			visited = new boolean[N][N];
			for(int k=0; k<N; k++) {
				
				for(int z=0; z<N; z++) {
					if(!visited[k][z] && i < arr[k][z]) {
						dfs(k, z, i);
						cnt++;
					}		
				}
			}
			answer = Math.max(answer, cnt);	
			
		}
		
		System.out.println(answer);
	}
	
	public static void dfs(int y, int x, int rain) {
		visited[y][x] = true;  
		
		
		for(int i=0; i<4; i++) {
			int dx = x + X[i];
			int dy = y + Y[i];
			
			if(dx < 0 || dx >= N || dy < 0 || dy >= N) continue;
			
			if(!visited[dy][dx] && rain < arr[dy][dx]) {
				dfs(dy, dx, rain);
			}			
		}
	}
		

}