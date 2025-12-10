import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;


public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<int[]> que = new ArrayDeque<>();
				  //상 하 좌 우
		int[] X = {0,0,-1,1};
		int[] Y = {-1,1,0,0};
		
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			String str = br.readLine();
			
			for(int k=1; k<=M; k++) {
				map[i][k] = Integer.parseInt(str.substring(k-1, k));
			}
		}
		
		que.offer(new int[] {1,1});
		
		while(!que.isEmpty()) {
			int[] start = que.poll();
			
			int x = start[1];
			int y = start[0];
			
			for(int i=0; i<4; i++) {
				int dx = x + X[i];
				int dy = y + Y[i];
				
				if(dx < 0 || dx >= map[0].length || dy < 0 || dy >= map.length) continue;
				
				if(map[dy][dx] == 1) {
					map[dy][dx] = map[y][x] + 1;
					que.offer(new int[] {dy, dx});
				}
			}		
		}
		
		System.out.println(map[N][M]);

	}

}