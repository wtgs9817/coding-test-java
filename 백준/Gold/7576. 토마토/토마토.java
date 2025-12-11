import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	
	//상하좌우
	static int[] X = {0,0,-1,1};
	static int[] Y = {-1,1,0,0};
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//상하좌우
		int[] X = {0,0,-1,1};
		int[] Y = {-1,1,0,0};
		
		int count = 0;
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] tomatoes = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> que = new ArrayDeque<>();
		
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int k=0; k<M; k++) {
				tomatoes[i][k] = Integer.parseInt(st.nextToken());
				if(tomatoes[i][k] == 1) que.offer(new int[] {i, k});
			}
		}
		
		
		while(!que.isEmpty()) {
			int[] loc = que.poll();
			int y = loc[0];
			int x = loc[1];
			
			visited[y][x] = true;
			
			for(int i=0; i<4; i++) {
				int dx = x + X[i];
				int dy = y + Y[i];
				
				if(dx < 0 || dx >= M || dy < 0 || dy >= N) continue;
				
				if(!visited[dy][dx] && tomatoes[dy][dx] == 0) {
					visited[dy][dx] = true;
					tomatoes[dy][dx] = tomatoes[y][x] + 1;
					que.offer(new int[] {dy, dx});
				}
			}
		}
		
		boolean flag = true;
		
		for(int i=0; i<N; i++) {
			
			for(int k=0; k<M; k++) {
				if(tomatoes[i][k] == 0) {
					count = -1;
					flag = false;
					break;
				}
				
				count = Math.max(count, tomatoes[i][k]);				
			}
			if(!flag) break;
		}
		
		if(!flag) System.out.println(count);
		else {
			System.out.println(count - 1); // 1부터 시작했으니까
		}
	
	}

}
