import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		//상하좌우
		int[] X = {0,0,-1,1};
		int[] Y = {-1,1,0,0};
				
		int[][] arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String num = br.readLine();
			for(int k=0; k<M; k++) {
				arr[i][k] = num.charAt(k) - '0';
			}
		}
		
		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] {0,0});
		
	
		while(!que.isEmpty()) {
			
			if(arr[N-1][M-1] > 1) break;
			
			int[] loc = que.poll();
			int x = loc[1];
			int y = loc[0];
			
			
			for(int i=0; i<4; i++) {
				int dx = x + X[i];
				int dy = y + Y[i];
				
				if(dx < 0 || dx >= M || dy < 0 || dy >= N) continue;
				
				if(arr[dy][dx] == 1) {
					arr[dy][dx] += arr[y][x];
					que.offer(new int[] {dy,dx});
				}
			}
		}
		
		System.out.println(arr[N-1][M-1]);
		
	}
}