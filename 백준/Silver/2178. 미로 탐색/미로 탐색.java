import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//상 하 좌 우
		int[] X = {0,0,-1,1};
		int[] Y = {-1,1,0,0};
		ArrayDeque<int[]> que = new ArrayDeque<>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			String num = br.readLine();
			for(int k=1; k<=M; k++) {
				char n = num.charAt(k-1);
				if(n == '1') {
					map[i][k] = Character.getNumericValue(n);
				}
			}
		}
		
		
		que.offer(new int[] {1,1});
		boolean flag = false;
		while(!que.isEmpty()) {
			if(flag) break;
			int[] loc = que.poll();
			
			int x = loc[1]; 
			int y = loc[0];
			
			for(int i=0; i<4; i++) {
				int dx = x + X[i];
				int dy = y + Y[i];
				
				if(dx < 1 || dx >M || dy < 1 || dy > N) continue;
				if(map[dy][dx] != 1) continue;
				if(dx == 1 && dy ==1 ) continue;
				
				map[dy][dx] = map[y][x] + 1;
				if(dy == N && dx == M) {
					flag = true;
					break;
				}
				que.offer(new int[] {dy, dx});
			}
		}
		
		System.out.println(map[N][M]);
	}
}
