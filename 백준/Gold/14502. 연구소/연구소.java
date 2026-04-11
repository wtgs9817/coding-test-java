import java.util.*;
import java.io.*;

public class Main {
	
	//상 하 좌 우
	static int[] X = {0,0,-1,1};
	static int[] Y = {-1,1,0,0};
	
	static int[][] map;
	static int N,M;

	static int answer = 0;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=1; k<=M; k++) {
				map[i][k] = Integer.parseInt(st.nextToken());
			}
		}
		
		search(0);
		System.out.println(answer);
		
		
		
	}
	
	static void search(int count) {
		if(count == 3) {
			answer = Math.max(answer, bfs());
			return;
		}
		
		for(int i=1; i<=N; i++) {
			
			for(int k=1; k<=M; k++) {
				if(map[i][k] == 0) {
					map[i][k] = 1;
					search(count+1);
					map[i][k] = 0;
				}	
			}
		}		
	}
	
	static int bfs() {
		int count = 0;
		ArrayDeque<int[]> que = new ArrayDeque<>();
		int[][] temp = new int[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			
			for(int k=1; k<=M;  k++) {
				temp[i][k] = map[i][k];
				if(map[i][k] == 2) que.offer(new int[] {i,k});
			}
		}
		
		while(!que.isEmpty()) {
			int[] loc = que.poll();
			
			int x = loc[1];
			int y = loc[0];
			
			for(int i=0; i<4; i++) {
				int dx = x + X[i];
				int dy = y + Y[i];
				
				if(dx < 1 || dx > M || dy < 1 || dy > N) continue;
				if(temp[dy][dx] == 0) {
					temp[dy][dx] = 2;
					que.offer(new int[] {dy,dx});
				}
			}
		}
		int cnt = 0;
		for(int i=1; i<=N; i++) {
			for(int k=1; k<=M; k++) {
				if(temp[i][k] == 0) cnt++;
			}
		}
		
		return cnt;
	}
	
}