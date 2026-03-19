import java.util.*;
import java.io.*;


//복습
public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] X = {0,0,-1,1};
		int[] Y = {-1,1,0,0}; // 상 하 좌 우
		
		
		
		int N= Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayDeque<int[]> que = new ArrayDeque<>();
		
		
		int[][] map = new int[N+1][M+1];
		int[][][] distMap = new int[N+1][M+1][2];
		
		// 0 -> 그냥 1 -> 부숨
		for(int i=1; i<=N; i++) {
			String str = br.readLine();
			for(int k=1; k<=M; k++) {
				int n = str.charAt(k-1) -'0';
				map[i][k] = n;
				distMap[i][k][0] = 0;
				distMap[i][k][1] = 0; 		
			}
		}
		
		que.offer(new int[] {1,1,0});
		distMap[1][1][0] = 1;
		distMap[1][1][1] = 1;
		
		while(!que.isEmpty()) {
			int[] arr = que.poll();
			
			int x = arr[1];
			int y = arr[0]; 
			int broke = arr[2];
			
			if(x == M && N == y) {
				System.out.println(distMap[y][x][broke]);
				return;
			}
			
			for(int z=0; z<4; z++ ) {
				int dx = X[z] + x;
				int dy = Y[z] + y;
				
				if(dx < 1 || dx > M || dy < 1 || dy > N) continue;
				
				if(map[dy][dx] == 0 && distMap[dy][dx][broke] == 0) {
					distMap[dy][dx][broke] = distMap[y][x][broke] + 1;
					que.offer(new int[] {dy,dx,broke});
				}
				
				if(map[dy][dx] ==1 && broke == 0 && distMap[dy][dx][1] == 0) {
					distMap[dy][dx][1] = distMap[y][x][broke] + 1;
					que.offer(new int[] {dy,dx,broke+1});
				}
			}	
		}
		System.out.println(-1);		
	}
}
